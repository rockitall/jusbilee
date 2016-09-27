package com.jusbilee.app.api.user.controller;


import com.jusbilee.app.api.user.account.domain.AccessToken;
import com.jusbilee.app.api.user.account.domain.AppUserProfile;
import com.jusbilee.app.api.user.account.domain.UserSummary;
import com.jusbilee.app.api.user.account.param.Credentials;
import com.jusbilee.app.api.user.account.param.PasswordModification;
import com.jusbilee.app.api.user.account.param.Registration;
import com.jusbilee.app.api.user.account.param.ThirdUserCredentials;
import com.jusbilee.app.api.user.domain.UploadToken;
import com.jusbilee.app.api.user.manager.UserAccountManager;
import com.jusbilee.app.api.user.request.UserAvatarModificationRequest;
import com.jusbilee.app.api.user.request.UserProfileModificationRequest;
import com.jusbilee.app.api.BaseController;
import com.jusbilee.app.context.HttpContext;
import com.jusbilee.app.qiniu.QiniuBucket;
import com.jusbilee.app.qiniu.QiniuSDKProperties;
import com.jusbilee.app.qiniu.QiniuSdkAuth;
import com.rockit.core.pojo.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserAccountController extends BaseController {
    @Autowired
    private UserAccountManager userAccountManager;

    @Autowired
    private QiniuSDKProperties qiniuSDKProperties;

    @Autowired
    private QiniuSdkAuth qiniuSdkAuth;

    @RequestMapping("/register")
    public JsonResult register(@Valid @ModelAttribute Registration registration, BindingResult bindingResult) {
        assertValid(bindingResult);

        AccessToken accessToken = userAccountManager.register(registration);
        return ok(accessToken);
    }

    @RequestMapping("/login")
    public JsonResult login(@Valid @ModelAttribute Credentials credentials, BindingResult bindingResult) {
        assertValid(bindingResult);
        AccessToken token = userAccountManager.login(credentials);
        return ok(token);
    }

    @RequestMapping("/trdlogin")
    public JsonResult trdlogin(@Valid @ModelAttribute ThirdUserCredentials credentials, BindingResult bindingResult) {
        assertValid(bindingResult);
        AccessToken token = userAccountManager.trdlogin(credentials);
        return ok(token);
    }

    @RequestMapping("/pwd/modify")
    public JsonResult modifyPassword(@Valid @ModelAttribute PasswordModification modification, BindingResult bindingResult) {
        assertValid(bindingResult);
        Long userId = HttpContext.current().getRequireUserId();
        modification.setUserId(userId);
        userAccountManager.modifyPassword(modification);
        return ok();
    }

    @RequestMapping("/logout")
    public JsonResult logout() {
        String userToken = HttpContext.current().getUserToken();
        userAccountManager.logout(userToken);
        return ok();
    }

    @RequestMapping("/profile")
    public JsonResult getAppUserProfile() {
        Long userId = HttpContext.current().getRequireUserId();
        AppUserProfile profile = userAccountManager.getAppUserProfile(userId);
        return ok(profile);
    }

    @RequestMapping("/profile/update")
    public JsonResult modifyNickname(@Valid @ModelAttribute UserProfileModificationRequest request, BindingResult bindingResult) {
        assertValid(bindingResult);

        Long userId = HttpContext.current().getRequireUserId();
        String nickname = StringUtils.trim(request.getNickname());
        userAccountManager.modifyNickname(userId, nickname);
        return ok();
    }

    @RequestMapping("/avatar/upload")
    public JsonResult uploadAvatar(@Valid @ModelAttribute UserAvatarModificationRequest request, BindingResult bindingResult) {
        Long userId = HttpContext.current().getRequireUserId();
        userAccountManager.uploadAvatar(userId, request.getAvatar());
        return ok();
    }

    @RequestMapping("/upload/token")
    public JsonResult uploadToken() {
        HttpContext.current().getRequireUserId();
        QiniuBucket bucket = qiniuSDKProperties.getAvatar();
        String token = qiniuSdkAuth.uploadToken(bucket.getName(), null, 10L * 365 * 24 * 60 * 60, null);

        UploadToken uploadToken = new UploadToken();
        uploadToken.setBucket(bucket.getName());
        uploadToken.setToken(token);
        uploadToken.setDomain(bucket.getDomain());

        return ok(uploadToken);
    }

    @RequestMapping("/summary")
    public JsonResult getUserSummary() {
        Long userId = HttpContext.current().getRequireUserId();
        UserSummary summary = userAccountManager.getUserSummary(userId);
        return ok(summary);
    }

    @RequestMapping("/other/profile")
    public JsonResult viewUserInfo(@RequestParam Long userId) {
        HttpContext.current().getRequireUserId();
        AppUserProfile profile = userAccountManager.getAppUserProfile(userId);
        return ok(profile);
    }
}
