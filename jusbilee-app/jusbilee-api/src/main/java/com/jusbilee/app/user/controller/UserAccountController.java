package com.jusbilee.app.user.controller;


import java.io.File;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jusbilee.app.base.BaseController;
import com.jusbilee.app.common.context.HttpContext;
import com.jusbilee.app.common.pojo.JsonResult;
import com.jusbilee.app.user.domain.AccessToken;
import com.jusbilee.app.user.domain.AppUser;
import com.jusbilee.app.user.param.Credentials;
import com.jusbilee.app.user.param.PasswordModification;
import com.jusbilee.app.user.param.Registration;
import com.jusbilee.app.user.param.ThirdUserCredentials;
import com.jusbilee.app.user.service.IUserAccountService;

@RestController
@RequestMapping("/user")
public class UserAccountController extends BaseController {
    @Autowired
    private IUserAccountService userAccountService;

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
