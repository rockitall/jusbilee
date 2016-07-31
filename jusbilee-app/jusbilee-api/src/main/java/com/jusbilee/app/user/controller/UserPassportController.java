package com.jusbilee.app.user.controller;


import com.jusbilee.app.base.BaseController;
import com.jusbilee.app.common.context.HttpContext;
import com.jusbilee.app.common.pojo.JsonResult;
import com.jusbilee.app.user.param.Credentials;
import com.jusbilee.app.user.param.PasswordModification;
import com.jusbilee.app.user.param.ThirdUserCredentials;
import com.jusbilee.app.user.param.ThirdUserType;
import com.jusbilee.app.user.pojo.AccessToken;
import com.jusbilee.app.user.service.AppUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserPassportController extends BaseController {
    @Autowired
    private AppUserService userAccountService;

    @RequestMapping("/trdlogin")
    public JsonResult trdlogin(@Valid @ModelAttribute ThirdUserCredentials credentials, BindingResult bindingResult) {
        if (credentials.getUserType() == ThirdUserType.WEIXIN) {
            AccessToken token = userAccountService.doWeixinUserLogin(credentials);
            return ok(token);
        }

        AccessToken token = userAccountService.doSinweiboUserLogin(credentials);
        return ok(token);
    }

    @RequestMapping("/login")
    public JsonResult login(@Valid @ModelAttribute Credentials credentials, BindingResult bindingResult) {
        AccessToken token = userAccountService.login(credentials);
        return ok(token);
    }


    @RequestMapping("/pwd/modify")
    public JsonResult modifyPassword(@Valid @ModelAttribute PasswordModification modification, BindingResult bindingResult) {
        modification.setUserId(HttpContext.current().getUserId());
        userAccountService.updateNewPassword(modification);
        return ok();
    }

    @RequestMapping("/logout")
    public JsonResult logout() {
        String userToken = HttpContext.current().getUserToken();
        if (StringUtils.isNotBlank(userToken)) {
            userAccountService.logout(userToken);
        }
        return ok();
    }
}
