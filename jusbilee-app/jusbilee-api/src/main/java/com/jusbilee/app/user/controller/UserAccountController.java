package com.jusbilee.app.user.controller;


import com.jusbilee.app.base.BaseController;
import com.rockit.core.context.HttpContext;
import com.rockit.core.pojo.JsonResult;
import com.jusbilee.app.sms.param.SmsParam;
import com.jusbilee.app.sms.param.VerifyCode;
import com.jusbilee.app.sms.service.SmsService;
import com.jusbilee.app.user.domain.AppUser;
import com.jusbilee.app.user.param.*;
import com.jusbilee.app.user.domain.AccessToken;
import com.jusbilee.app.user.service.IUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.File;

@RestController
@RequestMapping("/user")
public class UserAccountController extends BaseController {
    @Autowired
    private IUserAccountService userAccountService;

    @Autowired
    private SmsService smsService;

    @RequestMapping("/sms")
    public JsonResult sms(@Valid @ModelAttribute SmsParam param, BindingResult bindingResult) {
        assertValid(bindingResult);

        VerifyCode verifyCode = smsService.getVerifyCode(param);
        return JsonResult.ok(verifyCode);
    }

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
    public JsonResult getUserInfo() {
        Long userId = HttpContext.current().getUserId();
        AppUser appUser = userAccountService.getUserInfo(userId);
        return ok(appUser);
    }

    @RequestMapping("/avatar/upload")
    public JsonResult uploadAvatar(File file) {
        Long userId = HttpContext.current().getUserId();
        String avatarUrl = userAccountService.uploadAvatar(userId, file);
        return ok("avatar", avatarUrl);
    }
}
