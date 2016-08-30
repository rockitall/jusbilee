package com.jusbilee.app.admin;

import com.jusbilee.app.admin.request.SongStyleRequests;
import com.jusbilee.app.mybatis.pojo.SongStyle;
import com.jusbilee.app.api.style.service.SongStyleService;
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
    private SongStyleService songStyleService;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("meta/song_style_list");
        List<SongStyle> allLevels = songStyleService.list();
        mv.addObject("styles", allLevels);
        return mv;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(@Valid @ModelAttribute SongStyleRequests.SongStyleParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        SongStyle style = new SongStyle();
        style.setName(param.getName());
        style.setSortOrder(param.getSortOrder());
        songStyleService.addStageLevel(style);

        return JsonResult.ok();
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@RequestParam(required = true) Integer songStyleId, @Valid @ModelAttribute SongStyleRequests.SongStyleParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        SongStyle style = new SongStyle();
        style.setId(songStyleId);
        style.setName(param.getName());
        style.setSortOrder(param.getSortOrder());

        songStyleService.updateStageLevel(style);

        return JsonResult.ok();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam(required = true) Integer songStyleId) {
        songStyleService.deleteStageLevel(songStyleId);
        return JsonResult.ok();
    }
}
