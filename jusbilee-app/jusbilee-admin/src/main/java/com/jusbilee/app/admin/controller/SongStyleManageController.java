package com.jusbilee.app.admin.controller;

import com.jusbilee.app.admin.manager.SongStyleManager;
import com.jusbilee.app.admin.request.SongStyleRequest;
import com.jusbilee.app.mybatis.pojo.SongStyle;
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
@RequestMapping("/meta/song/style")
public class SongStyleManageController {
    @Autowired
    private SongStyleManager songStyleManager;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("meta/song_style_list");
        List<SongStyle> allLevels = songStyleManager.list();
        mv.addObject("styles", allLevels);
        return mv;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(@Valid @ModelAttribute SongStyleRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        songStyleManager.addSongStyle(request);
        return JsonResult.ok();
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@RequestParam Integer styleId, @Valid @ModelAttribute SongStyleRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        songStyleManager.updateSongStyle(styleId, request);
        return JsonResult.ok();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam(required = true) Integer songStyleId) {
        songStyleManager.deleteSongStyle(songStyleId);
        return JsonResult.ok();
    }
}
