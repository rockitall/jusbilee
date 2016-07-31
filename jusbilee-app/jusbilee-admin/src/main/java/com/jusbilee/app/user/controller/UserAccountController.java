package com.jusbilee.app.user.controller;

import com.jusbilee.app.common.pojo.JsonResult;
import com.jusbilee.app.user.pojo.UserAccount;
import com.jusbilee.app.user.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Allen on 2016/7/16.
 */
@RestController
@RequestMapping("/user/")
public class UserAccountController {
    @Autowired
    private AppUserService userAccountService;

    @RequestMapping(value = "/nickname", method = RequestMethod.GET)
    public JsonResult getUserNicknameAndAvatar(Integer userId) {
        return JsonResult.ok();
    }
}
