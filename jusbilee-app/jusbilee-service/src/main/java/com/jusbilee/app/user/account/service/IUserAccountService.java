package com.jusbilee.app.user.account.service;

import com.jusbilee.app.user.account.domain.UserSummary;
import com.rockit.core.exception.BadCredentialsException;
import com.rockit.core.exception.UserAccountLockedException;
import com.rockit.core.exception.UserAlreadyExistsException;
import com.jusbilee.app.user.account.domain.AppUser;
import com.jusbilee.app.user.account.param.Credentials;
import com.jusbilee.app.user.account.param.PasswordModification;
import com.jusbilee.app.user.account.param.Registration;
import com.jusbilee.app.user.account.param.ThirdUserCredentials;
import com.jusbilee.app.user.account.domain.AccessToken;

import java.io.File;

/**
 * Created by Allen on 2016/8/2.
 */
public interface IUserAccountService {
    AccessToken register(Registration registration) throws UserAlreadyExistsException;

    AccessToken trdlogin(ThirdUserCredentials credentials) throws BadCredentialsException, UserAccountLockedException;

    AccessToken login(Credentials credentials) throws BadCredentialsException, UserAccountLockedException;

    void modifyPassword(PasswordModification modification);

    void checkUsernameExists(String username) throws UserAlreadyExistsException;

    void logout(String userToken);

    AppUser getUserInfo(Long userId);

    void uploadAvatar(Long userId, String avatar);

    void modifyNickname(Long userId, String nickname);

    UserSummary getUserSummary(Long userId);
}
