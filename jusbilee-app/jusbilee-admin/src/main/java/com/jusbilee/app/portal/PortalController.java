package com.jusbilee.app.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Allen on 2016/7/15.
 */

@Controller
public class PortalController {
    @RequestMapping("/index")
    public String hello() {
        return "main";
    }
}
