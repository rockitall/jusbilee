package com.jusbilee.app.admin.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Allen on 2016/7/15.
 */

@Controller
public class MainController {
    @RequestMapping("/main")
    public String hello(HttpServletRequest request) {
        return "main";
    }

    @RequestMapping("/heartbeat")
    public void heartBeat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("OK");
    }
}
