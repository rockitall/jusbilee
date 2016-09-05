package com.jusbilee.app.admin.controller;

import com.jusbilee.app.admin.criteria.AdminUserQueryCriteria;
import com.jusbilee.app.admin.domain.AdminUserListItem;
import com.jusbilee.app.admin.manager.AdminUserManager;
import com.jusbilee.app.admin.request.AdminUserRequest;
import com.jusbilee.app.mybatis.pojo.AdminUser;
import com.rockit.core.exception.UserAlreadyExistsException;
import com.rockit.core.pojo.JsonResult;
import com.rockit.core.pojo.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * Created by Allen on 2016/9/5.
 */
@Controller
@RequestMapping("/user")
public class AdminUserManageController {
    private static final Logger logger = LoggerFactory.getLogger(AdminUserManageController.class);

    @Autowired
    private AdminUserManager adminUserManager;

    @RequestMapping("/list")
    @ResponseBody
    public ModelAndView add(@Valid @ModelAttribute AdminUserQueryCriteria criteria,
                            @Valid @ModelAttribute Pagination pagination, BindingResult bindingResult) throws Exception {
        ModelAndView mv = new ModelAndView("user/admin_user_list");
        try {
            long total = adminUserManager.countAdminUser(criteria);

            List<AdminUserListItem> songs = Collections.emptyList();
            if (total > 0) {
                pagination.setTotal(total);
                songs = adminUserManager.queryAdminUser(criteria, pagination);
            }
            mv.addObject("users", songs);
            mv.addObject("c", criteria);
            mv.addObject("p", pagination);
        } catch (Exception e) {
            logger.error("", e);
        }
        return mv;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(@Valid @ModelAttribute AdminUserRequest request, BindingResult bindingResult) throws Exception {
        try {
            if (bindingResult.hasErrors()) {
                return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
            }
            if (StringUtils.isBlank(request.getPassword())) {
                return JsonResult.error(1, "用户密码不能为空");
            }
            if (request.getPassword().length() < 6) {
                return JsonResult.error(1, "用户密码长度不能少于6位");
            }

            adminUserManager.addAdminUser(request);
            return JsonResult.ok();
        } catch (UserAlreadyExistsException e) {
            logger.error("", e);
            return JsonResult.error(1, "该用户名已经存在");
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@RequestParam Integer userId,
                             @Valid @ModelAttribute AdminUserRequest request, BindingResult bindingResult) throws Exception {
        try {
            adminUserManager.updateAdminUser(userId, request);
            return JsonResult.ok();
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public JsonResult get(@PathVariable("id") Integer userId) throws Exception {
        try {
            AdminUser user = adminUserManager.getAdminUser(userId);
            return JsonResult.ok(new AdminUserModificationWrapper(user));
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam("id") Integer userId) throws Exception {
        try {
            adminUserManager.deleteAdminUser(userId);
            return JsonResult.ok();
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    @RequestMapping("/lock")
    @ResponseBody
    public JsonResult lock(@RequestParam("id") Integer userId) throws Exception {
        try {
            adminUserManager.lockAdminUser(userId);
            return JsonResult.ok();
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    @RequestMapping("/unlock")
    @ResponseBody
    public JsonResult unlock(@RequestParam("id") Integer userId) throws Exception {
        try {
            adminUserManager.unlockAdminUser(userId);
            return JsonResult.ok();
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    private static class AdminUserModificationWrapper {
        private AdminUser user;

        public AdminUserModificationWrapper(AdminUser user) {
            this.user = user;
        }

        public String getNickname() {
            return user.getNickname();
        }

        public String getMobile() {
            return user.getMobile();
        }

        public Byte getIsAdmin() {
            return user.getIsAdmin();
        }

        public String getEmail() {
            return user.getEmail();
        }

        public String getUsername() {
            return user.getUsername();
        }
    }
}
