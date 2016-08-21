package com.jusbilee.app.user.service;

import java.io.File;

import com.jusbilee.app.user.domain.AccessToken;
import com.jusbilee.app.user.domain.AppUser;
import com.jusbilee.app.user.param.Credentials;
import com.jusbilee.app.user.param.PasswordModification;
import com.jusbilee.app.user.param.Registration;
import com.jusbilee.app.user.param.ThirdUserCredentials;
import com.rockit.core.exception.BadCredentialsException;
import com.rockit.core.exception.UserAccountLockedException;
import com.rockit.core.exception.UserAlreadyExistsException;

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

    String uploadAvatar(Long userId, File file);
    
    //新加部分
    void updateAppUser(AppUser appUser);
    
}
