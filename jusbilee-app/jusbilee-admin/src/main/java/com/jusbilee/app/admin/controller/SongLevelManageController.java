package com.jusbilee.app.admin.controller;

import com.jusbilee.app.admin.manager.SongLevelManager;
import com.jusbilee.app.admin.request.SongLevelRequest;
import com.jusbilee.app.mybatis.pojo.SongLevel;
import com.rockit.core.pojo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Allen on 2016/8/23.
 */
@Controller
@RequestMapping("/meta/song/level")
public class SongLevelManageController {
    @Autowired
    private SongLevelManager songLevelManager;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("meta/song_level_list");
        List<SongLevel> allLevels = songLevelManager.list();
        mv.addObject("levels", allLevels);
        return mv;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(@Valid @ModelAttribute SongLevelRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        songLevelManager.addSongLevel(request);
        return JsonResult.ok();
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@RequestParam Integer levelId,
                             @Valid @ModelAttribute SongLevelRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        songLevelManager.updateSongLevel(levelId, request);
        return JsonResult.ok();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam Integer levelId) {
        songLevelManager.deleteSongLevel(levelId);
        return JsonResult.ok();
    }
}
