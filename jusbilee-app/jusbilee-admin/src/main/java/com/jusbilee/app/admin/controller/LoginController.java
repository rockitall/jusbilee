package com.jusbilee.app.admin.controller;

import com.rockit.core.pojo.JsonResult;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Allen on 2016/8/5.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request) {
        return "login";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public JsonResult error(HttpServletRequest request) {
        return JsonResult.error(1, "sys_error");
    }
}
