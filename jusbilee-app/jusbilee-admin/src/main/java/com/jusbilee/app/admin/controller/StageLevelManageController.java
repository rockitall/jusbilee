package com.jusbilee.app.admin.controller;

import com.jusbilee.app.admin.manager.StageLevelManager;
import com.jusbilee.app.admin.request.StageLevelRequest;
import com.jusbilee.app.mybatis.pojo.StageLevel;
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
@RequestMapping("/meta/stage/level")
public class StageLevelManageController {
    @Autowired
    private StageLevelManager stageLevelManager;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("meta/stage_level_list");
        List<StageLevel> allLevels = stageLevelManager.list();
        mv.addObject("levels", allLevels);
        return mv;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(@Valid @ModelAttribute StageLevelRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        stageLevelManager.addStageLevel(request);
        return JsonResult.ok();
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@RequestParam(required = true) Integer stageLevelId,
                             @Valid @ModelAttribute StageLevelRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        stageLevelManager.updateStageLevel(stageLevelId, request);
        return JsonResult.ok();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam(required = true) Integer stageLevelId) {
        stageLevelManager.deleteStageLevel(stageLevelId);
        return JsonResult.ok();
    }
}
