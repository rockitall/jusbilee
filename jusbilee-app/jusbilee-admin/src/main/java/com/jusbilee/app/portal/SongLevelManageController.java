package com.jusbilee.app.portal;

import com.jusbilee.app.leve.service.SongLevelService;
import com.jusbilee.app.mybatis.pojo.SongLevel;
import com.jusbilee.app.portal.request.SongLevelRequests;
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
    private SongLevelService songLevelService;

    @RequestMapping("/manage")
    public String manage() {
        return "meta/song_level_list";
    }

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("meta/song_level_list");
        List<SongLevel> allLevels = songLevelService.list();
        mv.addObject("levels", allLevels);
        return mv;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(@Valid @ModelAttribute SongLevelRequests.SongLevelParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        SongLevel level = new SongLevel();
        level.setName(param.getName());
        songLevelService.addSongLevel(level);

        return JsonResult.ok();
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@RequestParam(required = true) Integer songLevelId, @Valid @ModelAttribute SongLevelRequests.SongLevelParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        SongLevel level = new SongLevel();
        level.setId(songLevelId);
        level.setName(param.getName());

        songLevelService.updateSongLevel(level);

        return JsonResult.ok();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam(required = true) Integer songLevelId) {
        songLevelService.deleteSongLevel(songLevelId);
        return JsonResult.ok();
    }


}
