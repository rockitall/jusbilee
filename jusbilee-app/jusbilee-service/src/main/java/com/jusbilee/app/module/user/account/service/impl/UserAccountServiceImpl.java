package com.jusbilee.app.module.user.account.service.impl;

import com.jusbilee.app.module.user.account.dao.PassportDao;
import com.jusbilee.app.module.user.account.dao.ThirdUserBindDao;
import com.jusbilee.app.module.user.account.domain.*;
import com.jusbilee.app.module.user.account.param.*;
import com.jusbilee.app.module.user.account.service.IUserAccountService;
import com.jusbilee.app.redis.RedisCacheService;
import com.jusbilee.app.module.user.account.dao.AppUserDao;
import com.rockit.core.Constants;
import com.rockit.core.exception.BadCredentialsException;
import com.rockit.core.exception.PasswordModificationException;
import com.rockit.core.exception.UserAccountLockedException;
import com.rockit.core.exception.UserAlreadyExistsException;
import com.rockit.core.utils.UniqueIdUtils;
import com.rockit.core.qcloud.im.signature.TLSSignatureGenerator;
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
public class UserAccountServiceImpl implements IUserAccountService {
    @Autowired
    private AppUserDao appUserDao;

    @Autowired
    private PassportDao passportDao;

    @Autowired
    private ThirdUserBindDao thirdUserBindDao;

    @Autowired
    private RedisCacheService redisCacheService;

    @Autowired
    private WeixinUserService weixinUserService;

    @Autowired
    private SinaWeiboUserService weiboUserService;

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
        redisCacheService.setUserAccessToken(token);
        return token;
    }

    protected AccessToken getSuccessAccessToken(Passport passport) {
        Assert.notNull(passport, "passport is null");

        String userToken = HmacUtils.hmacSha1Hex(securityKey.getBytes(), passport.toString().getBytes()).toUpperCase();
        String userSecret = UniqueIdUtils.getUserSecret();

        AccessToken accessToken = new AccessToken();
        accessToken.setUserId(passport.getUserId());
        accessToken.setUserToken(userToken);
        accessToken.setUserSecret(userSecret);

        String identifier = signatureGenerator.getIdentifier(passport.getUserId());
        String userSignature = signatureGenerator.getUserSignature(identifier);
        accessToken.setIdentifier(identifier);
        accessToken.setUserSignature(userSignature);
        return accessToken;
    }

    public AccessToken doWeixinUserLogin(ThirdUserCredentials credentials) throws UserAccountLockedException {
        WeixinUser user = weixinUserService.lookup(credentials);
        return doThirdUserLogin(credentials, user);
    }

    public AccessToken doSinaWeiboUserLogin(ThirdUserCredentials credentials) throws UserAccountLockedException {
        SinaWeiboUser user = weiboUserService.lookup(credentials);
        return doThirdUserLogin(credentials, user);
    }

    @Transactional
    private AccessToken doThirdUserLogin(ThirdUserCredentials credentials, ThirdUserBase thirdUserBase) throws UserAccountLockedException {
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
            this.appUserDao.initUserSummary(appUser.getId());
        } else {

            //check user account locked status
            passport.setUserId(bind.getUserId());
            checkUserAccountLocked(bind.getUserId());
        }

        return getSuccessAccessToken(passport);
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
        this.appUserDao.initUserSummary(appUser.getId());

        Passport passport = this.createAppUserPassport(appUser.getId(), registration);
        AccessToken accessToken = getSuccessAccessToken(passport);
        return accessToken;
    }

    @Override
    public AccessToken trdlogin(ThirdUserCredentials credentials) throws BadCredentialsException, UserAccountLockedException {
        if (credentials.getUserType() == ThirdUserType.WEIXIN) {
            return this.doWeixinUserLogin(credentials);
        }

        return this.doSinaWeiboUserLogin(credentials);
    }

    public Passport createAppUserPassport(Long userId, Credentials credentials) throws UserAlreadyExistsException {
        Passport passport = new Passport();
        passport.setUserId(userId);
        passport.setUsername(credentials.getUsername());
        resetPassword(passport, credentials.getPassword());

        passportDao.insert(passport);
        return passport;
    }

    private void resetPassword(Passport passport, String password) {
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

    @Override
    public AppUserProfile getAppUserProfile(Long userId) {
        return appUserDao.getUserProfile(userId);
    }

    @Override
    public void uploadAvatar(Long userId, String avatar) {
        appUserDao.updateAvatar(userId, avatar);
    }

    @Override
    public void modifyNickname(Long userId, String nickname) {
        appUserDao.updateNickname(userId, nickname);
    }

    @Override
    public UserSummary getUserSummary(Long userId) {
        UserSummary userSummary = appUserDao.getUserSummary(userId);

        return userSummary;
    }
}
