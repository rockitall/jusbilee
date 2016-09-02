package com.jusbilee.app.admin.controller;

import org.springframework.stereotype.Controller;

/**
 * Created by Allen on 2016/8/21.
 */
@Controller
public class SongModuleController {
    public String list() {
        return "song_list";
    }
}
