package com.jusbilee.app.api.user.manager;

import com.jusbilee.app.api.user.account.domain.*;
import com.jusbilee.app.api.user.account.param.*;
import com.jusbilee.app.api.user.account.service.ApiUserAccountService;
import com.rockit.core.exception.BadCredentialsException;
import com.rockit.core.exception.UserAccountLockedException;
import com.rockit.core.exception.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Allen on 2016/9/27.
 */
@Service
public class UserAccountManager {
    @Autowired
    private ApiUserAccountService apiUserAccountService;

    @Autowired
    private WeixinThirdLoginUserManager weixinThirdLoginUserManager;

    @Autowired
    private SinaWeiboThirdLoginUserManager thirdLoginUserManager;

    @Autowired
    private QQThirdLoginUserManager qqThirdLoginUserManager;

    public AccessToken login(Credentials credentials) throws BadCredentialsException, UserAccountLockedException {
        return apiUserAccountService.login(credentials);
    }

    public AccessToken trdlogin(ThirdUserCredentials credentials) throws BadCredentialsException, UserAccountLockedException {
        if (credentials.getUserType() == ThirdUserType.WEIXIN) {
            WeixinUser user = weixinThirdLoginUserManager.lookup(credentials);
            return apiUserAccountService.doThirdUserLogin(credentials, user);
        } else if (credentials.getUserType() == ThirdUserType.QQ) {
            QQUser user = qqThirdLoginUserManager.lookup(credentials);
            return apiUserAccountService.doThirdUserLogin(credentials, user);
        } else {
            SinaWeiboUser user = thirdLoginUserManager.lookup(credentials);
            return apiUserAccountService.doThirdUserLogin(credentials, user);
        }
    }

    public void modifyPassword(PasswordModification modification) {
        apiUserAccountService.modifyPassword(modification);
    }

    @Transactional
    public AccessToken register(Registration registration) throws UserAlreadyExistsException {
        return apiUserAccountService.register(registration);
    }

    public Passport createAppUserPassport(Long userId, Credentials credentials) throws UserAlreadyExistsException {
        return apiUserAccountService.createAppUserPassport(userId, credentials);
    }

    private void resetPassword(Passport passport, String password) {
        apiUserAccountService.resetPassword(passport, password);
    }

    public void logout(String userToken) {
        apiUserAccountService.logout(userToken);
    }

    public AppUserProfile getAppUserProfile(Long userId) {
        return apiUserAccountService.getAppUserProfile(userId);
    }

    public void uploadAvatar(Long userId, String avatar) {
        apiUserAccountService.uploadAvatar(userId, avatar);
    }

    public void modifyNickname(Long userId, String nickname) {
        apiUserAccountService.modifyNickname(userId, nickname);
    }

    public UserSummary getUserSummary(Long userId) {
        return apiUserAccountService.getUserSummary(userId);
    }
}
