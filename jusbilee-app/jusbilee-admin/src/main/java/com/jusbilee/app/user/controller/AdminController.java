package com.jusbilee.app.user.controller;

import com.jusbilee.app.common.utils.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Allen on 2016/7/18.
 */
@Controller
public class AdminController {
    @RequestMapping("/admin")
    public ModelAndView admin() {
        ModelAndView mv = new ModelAndView("test");
        String json = JacksonUtil.toJson(freeMarkerProperties);
        mv.addObject("json", json);
        return mv;
    }

    @Autowired
    private FreeMarkerProperties freeMarkerProperties;
}
