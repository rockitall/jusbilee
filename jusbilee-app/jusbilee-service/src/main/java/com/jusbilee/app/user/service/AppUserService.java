package com.jusbilee.app.user.service;

import com.jusbilee.app.common.exception.BadCredentialsException;
import com.jusbilee.app.common.exception.UserAlreadyExistsException;
import com.jusbilee.app.common.utils.UniqueIdUtils;
import com.jusbilee.app.redis.RedisCacheService;
import com.jusbilee.app.user.dao.AppUserDao;
import com.jusbilee.app.user.param.Credentials;
import com.jusbilee.app.user.param.PasswordModification;
import com.jusbilee.app.user.param.ThirdUserCredentials;
import com.jusbilee.app.user.param.UserRegistration;
import com.jusbilee.app.user.pojo.*;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by Allen on 2016/7/16.
 */
@Service
public class AppUserService {
    @Autowired
    private AppUserDao appUserDao;

    @Autowired
    private RedisCacheService redisCacheService;

    @Autowired
    private ThirdLoginUserService thirdLoginUserService;

    @Value("${passport.securityKey}")
    private String securityKey;

    public AccessToken login(Credentials credentials) {
        Passport passport = appUserDao.getAppUserPassportByUsername(credentials.getUsername());
        if (passport == null) {
            throw new BadCredentialsException();
        }

        String pwd = new Md5Hash(credentials.getPassword(), passport.getSalt()).toHex();
        if (!pwd.equals(passport.getPassword())) {
            throw new BadCredentialsException();
        }
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

        return accessToken;
    }

    public AccessToken doWeixinUserLogin(ThirdUserCredentials credentials) {
        WeixinUser user = thirdLoginUserService.getWeixinUserInfo(credentials);
        credentials.setNickname(user.getNickname());
        return doThirdUserLogin(credentials);
    }

    public AccessToken doSinweiboUserLogin(ThirdUserCredentials credentials) {
        SinaWeiboUser user = thirdLoginUserService.getSinaWeiboUserInfo(credentials);
        credentials.setNickname(user.getName());

        return doThirdUserLogin(credentials);
    }


    private AccessToken doThirdUserLogin(ThirdUserCredentials credentials) {
        UserBind bind = appUserDao.getUserBind(credentials);

        Passport passport = new Passport();
        if (bind == null) {
            UserRegistration registration = new UserRegistration();
            registration.setNickname(credentials.getNickname());
            appUserDao.createAppUserForRegistration(registration);
            passport.setUserId(registration.getUserId());
        } else {
            passport.setUserId(bind.getUserId());
        }

        return getSuccessAccessToken(passport);
    }

    public void updateNewPassword(PasswordModification modification) {
        Passport passport = new Passport();
        passport.setUserId(modification.getUserId());
        resetPassword(passport, modification.getPassword());

        appUserDao.updateUserPassport(passport);
    }

    public AccessToken regster(UserRegistration registration) throws UserAlreadyExistsException {
        this.checkUsernameExists(registration.getUsername());

        this.appUserDao.createAppUserForRegistration(registration);
        Passport passport = this.createAppUserPassport(registration.getUserId(), registration);
        AccessToken accessToken = getSuccessAccessToken(passport);
        return accessToken;
    }

    public Passport createAppUserPassport(Long userId, Credentials credentials) throws UserAlreadyExistsException {
        Passport passport = new Passport();
        passport.setUserId(userId);
        passport.setUsername(credentials.getUsername());
        resetPassword(passport, credentials.getPassword());

        appUserDao.createAppUserPassport(passport);
        return passport;
    }

    private void resetPassword(Passport passport, String password) {
        String salt = UniqueIdUtils.getSalt();
        String hash = new Md5Hash(password, salt).toHex();

        passport.setSalt(salt);
        passport.setPassword(hash);
    }

    public void checkUsernameExists(String username) throws UserAlreadyExistsException {
        Passport passport = appUserDao.getAppUserPassportByUsername(username);
        if (passport != null) {
            throw new UserAlreadyExistsException();
        }
    }

    public void logout(String userToken) {
        redisCacheService.deleteAccessToken(userToken);
    }

}
