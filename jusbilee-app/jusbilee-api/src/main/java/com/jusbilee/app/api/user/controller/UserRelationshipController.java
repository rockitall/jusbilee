package com.jusbilee.app.api.user.controller;


import com.jusbilee.app.api.user.account.service.IUserAccountService;
import com.jusbilee.app.api.user.relationship.domain.UserFriendProfile;
import com.jusbilee.app.api.user.relationship.service.IUserRelationshipService;
import com.jusbilee.app.api.user.request.UserFriendRequest;
import com.jusbilee.app.api.BaseController;
import com.jusbilee.app.context.HttpContext;
import com.rockit.core.pojo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
        Long userId = HttpContext.current().getRequireUserId();
        userRelationshipService.addFriend(userId, param.getFriendId());
        return ok();
    }

    @RequestMapping("/delete")
    public JsonResult delete(@Valid @ModelAttribute UserFriendRequest param, BindingResult bindingResult) {
        assertValid(bindingResult);
        Long userId = HttpContext.current().getRequireUserId();
        userRelationshipService.deleteFriend(userId, param.getFriendId());
        return ok();
    }
}
