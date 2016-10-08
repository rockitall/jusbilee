package com.jusbilee.app.api.user.account.service;

import com.jusbilee.app.api.user.account.dao.ApiUserSummaryDao;
import com.jusbilee.app.api.user.account.dao.AppUserDao;
import com.jusbilee.app.api.user.account.dao.PassportDao;
import com.jusbilee.app.api.user.account.dao.ThirdUserBindDao;
import com.jusbilee.app.api.user.account.domain.*;
import com.jusbilee.app.api.user.account.param.Credentials;
import com.jusbilee.app.api.user.account.param.PasswordModification;
import com.jusbilee.app.api.user.account.param.Registration;
import com.jusbilee.app.api.user.account.param.ThirdUserCredentials;
import com.jusbilee.app.redis.RedisCacheService;
import com.rockit.core.Constants;
import com.rockit.core.exception.BadCredentialsException;
import com.rockit.core.exception.PasswordModificationException;
import com.rockit.core.exception.UserAccountLockedException;
import com.rockit.core.exception.UserAlreadyExistsException;
import com.rockit.core.qcloud.im.signature.TLSSignatureGenerator;
import com.rockit.core.utils.UniqueIdUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Created by Allen on 2016/7/16.
 */
@Service
public class ApiUserAccountService {
    @Autowired
    private AppUserDao appUserDao;

    @Autowired
    private ApiUserSummaryDao apiUserSummaryDao;

    @Autowired
    private PassportDao passportDao;

    @Autowired
    private ThirdUserBindDao thirdUserBindDao;

    @Autowired
    private RedisCacheService redisCacheService;

    @Autowired
    private TLSSignatureGenerator signatureGenerator;

    @Value("${passport.securityKey}")
    private String securityKey;

    public AccessToken login(Credentials credentials) throws BadCredentialsException, UserAccountLockedException {
        Passport passport = passportDao.selectByUsername(credentials.getUsername());
        if (passport == null) {
            throw new BadCredentialsException();
        }

        String pwd = new Md5Hash(credentials.getPassword(), passport.getSalt()).toHex();
        if (!pwd.equals(passport.getPassword())) {
            throw new BadCredentialsException();
        }

        this.checkUserAccountLocked(passport.getUserId());

        AccessToken token = getSuccessAccessToken(passport);
        return token;
    }

    @Transactional
    public AccessToken doThirdUserLogin(ThirdUserCredentials credentials, ThirdUserBase thirdUserBase) throws UserAccountLockedException {
        ThirdUserBind bind = thirdUserBindDao.selectByOpenid(credentials.getOpenid(), credentials.getUserTypeName());

        Passport passport = new Passport();
        if (bind == null) {
            //create new user account
            AppUser appUser = new AppUser();
            appUser.setNickname(thirdUserBase.getNickname());
            appUser.setAvatar(thirdUserBase.getAvatar());
            appUserDao.insert(appUser);

            //bind user
            bind = new ThirdUserBind();
            bind.setUserId(appUser.getId());
            bind.setOpenid(credentials.getOpenid());
            bind.setUserType(credentials.getUserTypeName());
            this.thirdUserBindDao.insert(bind);
            this.apiUserSummaryDao.initUserSummary(appUser.getId());
            passport.setUserId(appUser.getId());
        } else {
            //check user account locked status
            passport.setUserId(bind.getUserId());
            checkUserAccountLocked(bind.getUserId());
        }

        return getSuccessAccessToken(passport);
    }

    public AccessToken getSuccessAccessToken(Passport passport) {
        Assert.notNull(passport, "passport is null");

        String userToken = HmacUtils.hmacSha1Hex(securityKey.getBytes(), passport.toString().getBytes()).toUpperCase();
        String userSecret = UniqueIdUtils.getUserSecret();

        AccessToken token = new AccessToken();
        token.setUserId(passport.getUserId());
        token.setUserToken(userToken);
        token.setUserSecret(userSecret);

        String identifier = passport.getUserId().toString();
        String userSignature = signatureGenerator.getUserSignature(identifier);
        token.setIdentifier(identifier);
        token.setUserSignature(userSignature);

        redisCacheService.setUserAccessToken(token);

        return token;
    }

    private void checkUserAccountLocked(Long userId) throws UserAccountLockedException {
        Byte locked = appUserDao.getLockStatus(userId);
        if (Constants.BOOL.isTrue(locked)) {
            throw new UserAccountLockedException();
        }
    }

    public void modifyPassword(PasswordModification modification) {
        Passport old = passportDao.selectByUserId(modification.getUserId());
        String pwd = new Md5Hash(modification.getOldPassword(), old.getSalt()).toHex();

        if (!pwd.equals(old.getPassword())) {
            throw new PasswordModificationException();
        }

        Passport passport = new Passport();
        passport.setUserId(modification.getUserId());
        resetPassword(passport, modification.getPassword());

        passportDao.updatePassword(passport);
    }

    @Transactional
    public AccessToken register(Registration registration) throws UserAlreadyExistsException {
        this.checkUsernameExists(registration.getUsername());

        AppUser appUser = new AppUser();
        appUser.setNickname("");
        this.appUserDao.insert(appUser);
        this.apiUserSummaryDao.initUserSummary(appUser.getId());

        Passport passport = this.createAppUserPassport(appUser.getId(), registration);
        AccessToken accessToken = getSuccessAccessToken(passport);
        return accessToken;
    }

    public Passport createAppUserPassport(Long userId, Credentials credentials) throws UserAlreadyExistsException {
        Passport passport = new Passport();
        passport.setUserId(userId);
        passport.setUsername(credentials.getUsername());
        resetPassword(passport, credentials.getPassword());

        passportDao.insert(passport);
        return passport;
    }

    public void resetPassword(Passport passport, String password) {
        String salt = UniqueIdUtils.getSalt();
        String hash = new Md5Hash(password, salt).toHex();

        passport.setSalt(salt);
        passport.setPassword(hash);
    }

    public void checkUsernameExists(String username) throws UserAlreadyExistsException {
        Passport passport = passportDao.selectByUsername(username);
        if (passport != null) {
            throw new UserAlreadyExistsException();
        }
    }

    public void logout(String userToken) {
        if (StringUtils.isNotBlank(userToken)) {
            redisCacheService.deleteAccessToken(userToken);
        }
    }

    public MyProfile getAppUserProfile(Long userId) {
        MyProfile profile = appUserDao.getUserProfile(userId);
        int nextLevelPoints = 80 + (profile.getLevel() - 1) * 20;
        int upgradePoints = nextLevelPoints - profile.getPoints();
        profile.setUpgradePoints(upgradePoints);
        return profile;
    }

    public void uploadAvatar(Long userId, String avatar) {
        appUserDao.updateAvatar(userId, avatar);
    }

    public void modifyNickname(Long userId, String nickname) {
        appUserDao.updateNickname(userId, nickname);
    }

    public UserSummary getUserSummary(Long userId) {
        UserSummary userSummary = apiUserSummaryDao.getUserSummary(userId);
        return userSummary;
    }
}
