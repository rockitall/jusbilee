package com.jusbilee.app.admin;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Allen on 2016/8/5.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login")
    public String loginPage(HttpServletRequest request) {
        return "login_page";
    }
}
