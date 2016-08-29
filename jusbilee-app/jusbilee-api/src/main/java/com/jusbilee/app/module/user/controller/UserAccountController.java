package com.jusbilee.app.module.user.controller;


import com.jusbilee.app.base.BaseController;
import com.jusbilee.app.context.HttpContext;
import com.jusbilee.app.module.user.account.domain.AccessToken;
import com.jusbilee.app.module.user.account.domain.AppUserProfile;
import com.jusbilee.app.module.user.account.param.Credentials;
import com.jusbilee.app.module.user.account.param.ThirdUserCredentials;
import com.jusbilee.app.module.user.account.service.IUserAccountService;
import com.jusbilee.app.module.user.request.UserAvatarModificationRequest;
import com.jusbilee.app.module.user.request.UserProfileModificationRequest;
import com.jusbilee.app.qiniu.QiniuSDKProperties;
import com.jusbilee.app.qiniu.QiniuSdkAuth;
import com.jusbilee.app.module.user.account.domain.UserSummary;
import com.jusbilee.app.module.user.account.param.PasswordModification;
import com.jusbilee.app.module.user.account.param.Registration;
import com.rockit.core.pojo.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserAccountController extends BaseController {
    @Autowired
    private IUserAccountService userAccountService;

    @Autowired
    private QiniuSDKProperties qiniuSDKProperties;

    @Autowired
    private QiniuSdkAuth qiniuSdkAuth;

    @RequestMapping("/register")
    public JsonResult register(@Valid @ModelAttribute Registration registration, BindingResult bindingResult) {
        assertValid(bindingResult);

        AccessToken accessToken = userAccountService.register(registration);
        return ok(accessToken);
    }

    @RequestMapping("/login")
    public JsonResult login(@Valid @ModelAttribute Credentials credentials, BindingResult bindingResult) {
        assertValid(bindingResult);
        AccessToken token = userAccountService.login(credentials);
        return ok(token);
    }

    @RequestMapping("/trdlogin")
    public JsonResult trdlogin(@Valid @ModelAttribute ThirdUserCredentials credentials, BindingResult bindingResult) {
        assertValid(bindingResult);
        AccessToken token = userAccountService.trdlogin(credentials);
        return ok(token);
    }

    @RequestMapping("/pwd/modify")
    public JsonResult modifyPassword(@Valid @ModelAttribute PasswordModification modification, BindingResult bindingResult) {
        assertValid(bindingResult);
        modification.setUserId(HttpContext.current().getUserId());
        userAccountService.modifyPassword(modification);
        return ok();
    }

    @RequestMapping("/logout")
    public JsonResult logout() {
        String userToken = HttpContext.current().getUserToken();
        userAccountService.logout(userToken);
        return ok();
    }

    @RequestMapping("/profile")
    public JsonResult getAppUserProfile() {
        Long userId = HttpContext.current().getUserId();
        AppUserProfile profile = userAccountService.getAppUserProfile(userId);
        return ok(profile);
    }

    @RequestMapping("/profile/update")
    public JsonResult modifyNickname(@Valid @ModelAttribute UserProfileModificationRequest request, BindingResult bindingResult) {
        assertValid(bindingResult);

        Long userId = HttpContext.current().getUserId();
        String nickname = StringUtils.trim(request.getNickname());
        userAccountService.modifyNickname(userId, nickname);
        return ok();
    }

    @RequestMapping("/avatar/upload")
    public JsonResult uploadAvatar(@Valid @ModelAttribute UserAvatarModificationRequest request, BindingResult bindingResult) {
        Long userId = HttpContext.current().getUserId();
        userAccountService.uploadAvatar(userId, request.getAvatar());
        return ok();
    }

    @RequestMapping("/upload/token")
    public JsonResult uploadToken() {
        String token = qiniuSdkAuth.uploadToken(qiniuSDKProperties.getBucketName(), null, 10L * 365 * 24 * 60 * 60, null);
        return ok("token", token);
    }

    @RequestMapping("/summary")
    public JsonResult getUserSummary() {
        Long userId = HttpContext.current().getUserId();
        UserSummary summary = userAccountService.getUserSummary(userId);
        return ok(summary);
    }
}
