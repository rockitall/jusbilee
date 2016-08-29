package com.jusbilee.app.admin;

import com.jusbilee.app.api.stage.service.StageLevelService;
import com.jusbilee.app.mybatis.pojo.StageLevel;
import com.jusbilee.app.admin.request.StageLevelRequests;
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
    private StageLevelService stageLevelService;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("meta/stage_level_list");
        List<StageLevel> allLevels = stageLevelService.list();
        mv.addObject("levels", allLevels);
        return mv;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(@Valid @ModelAttribute StageLevelRequests.StageLevelParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        StageLevel level = new StageLevel();
        level.setName(param.getName());
        level.setWeight(param.getWeight());
        stageLevelService.addStageLevel(level);

        return JsonResult.ok();
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@RequestParam(required = true) Integer stageLevelId, @Valid @ModelAttribute StageLevelRequests.StageLevelParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        StageLevel level = new StageLevel();
        level.setId(stageLevelId);
        level.setWeight(param.getWeight());
        level.setName(param.getName());

        stageLevelService.updateStageLevel(level);

        return JsonResult.ok();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam(required = true) Integer stageLevelId) {
        stageLevelService.deleteStageLevel(stageLevelId);
        return JsonResult.ok();
    }
}
