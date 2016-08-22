package com.jusbilee.app.user.controller;


import com.jusbilee.app.base.BaseController;
import com.jusbilee.app.sms.param.SmsParam;
import com.jusbilee.app.sms.param.VerifyCode;
import com.jusbilee.app.sms.service.SmsService;
import com.jusbilee.app.user.account.domain.AccessToken;
import com.jusbilee.app.user.account.domain.AppUser;
import com.jusbilee.app.user.account.param.Credentials;
import com.jusbilee.app.user.account.param.PasswordModification;
import com.jusbilee.app.user.account.param.Registration;
import com.jusbilee.app.user.account.param.ThirdUserCredentials;
import com.jusbilee.app.user.account.service.IUserAccountService;
import com.jusbilee.app.user.relationship.domain.UserFriendProfile;
import com.jusbilee.app.user.relationship.service.IUserRelationshipService;
import com.jusbilee.app.user.request.UserFriendRequest;
import com.rockit.core.context.HttpContext;
import com.rockit.core.pojo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/user/friend")
public class UserRelationshipController extends BaseController {

    @Autowired
    private IUserAccountService userAccountService;

    @Autowired
    private IUserRelationshipService userRelationshipService;

    @RequestMapping("/list")
    public JsonResult list() {
        List<UserFriendProfile> friends = userRelationshipService.getAllFriends(HttpContext.current().getUserId());
        return ok(friends);
    }

    @RequestMapping("/add")
    public JsonResult add(@Valid @ModelAttribute UserFriendRequest param, BindingResult bindingResult) {
        assertValid(bindingResult);
        Long userId = HttpContext.current().getUserId();
        userRelationshipService.addFriend(userId, param.getFriendId());
        return ok();
    }

    @RequestMapping("/delete")
    public JsonResult delete(@Valid @ModelAttribute UserFriendRequest param, BindingResult bindingResult) {
        assertValid(bindingResult);
        Long userId = HttpContext.current().getUserId();
        userRelationshipService.deleteFriend(userId, param.getFriendId());
        return ok();
    }
}
