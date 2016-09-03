package com.jusbilee.app.admin.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Allen on 2016/7/15.
 */

@Controller
public class PortalController {
    @RequestMapping("/index")
    public String hello(HttpServletRequest request) {
        return "main";
    }
}
