package com.jusbilee.app.portal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Allen on 2016/7/15.
 */

@RestController
public class PortalController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello21";
    }
}
