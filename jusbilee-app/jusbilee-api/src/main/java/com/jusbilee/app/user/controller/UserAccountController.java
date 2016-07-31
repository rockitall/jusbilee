package com.jusbilee.app.user.controller;

import com.jusbilee.app.base.BaseController;
import com.jusbilee.app.common.pojo.JsonResult;
import com.jusbilee.app.user.param.UserRegistration;
import com.jusbilee.app.user.pojo.AccessToken;
import com.jusbilee.app.user.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Allen on 2016/7/30.
 */
@RestController
@RequestMapping("/user")
public class UserAccountController extends BaseController {
    @Autowired
    private AppUserService userAccountService;

    @RequestMapping("/register")
    public JsonResult register(@Valid @ModelAttribute UserRegistration registration, BindingResult bindingResult) {
        assertValid(bindingResult);
        
        AccessToken accessToken = userAccountService.regster(registration);
        return ok(accessToken);
    }
}
