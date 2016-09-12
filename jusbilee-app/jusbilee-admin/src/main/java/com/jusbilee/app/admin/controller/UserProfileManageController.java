package com.jusbilee.app.admin.controller;

import com.jusbilee.app.admin.manager.UserProfileManager;
import com.jusbilee.app.admin.request.AdminUserPasswordModifyRequest;
import com.jusbilee.app.security.AdminUserDetails;
import com.rockit.core.exception.BadCredentialsException;
import com.rockit.core.pojo.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Allen on 2016/9/12.
 */
@Controller
@RequestMapping("/user/profile")
public class UserProfileManageController {
    private static final Logger logger = LoggerFactory.getLogger(UserProfileManageController.class);

    @Autowired
    private UserProfileManager userProfileManager;

    @RequestMapping("/pwd/reset")
    @ResponseBody
    public JsonResult modifyPassword(@ModelAttribute AdminUserPasswordModifyRequest request,
                                     BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
            }

            AdminUserDetails details = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            userProfileManager.modifyPassword(details, request);
            return JsonResult.ok();
        } catch (BadCredentialsException e) {
            return JsonResult.error(1, "原密码不正确");
        } catch (Exception e) {
            return JsonResult.error(1, "修改密码失败");
        }
    }

}
