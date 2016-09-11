package com.jusbilee.app.api.stage.controller;


import com.jusbilee.app.api.stage.manager.StageManager;
import com.jusbilee.app.api.stage.request.UserStageChallengeResultRequest;
import com.jusbilee.app.base.BaseController;
import com.jusbilee.app.context.HttpContext;
import com.rockit.core.pojo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user/stage")
public class UserStageController extends BaseController {
    @Autowired
    private StageManager stageManager;

    @RequestMapping("/song/challenge")
    public JsonResult recordStagePlay(@Valid @ModelAttribute UserStageChallengeResultRequest request, BindingResult bindingResult) {
        assertValid(bindingResult);
        Long userId = HttpContext.current().getUserId();
        stageManager.recordUserStageChallengeResult(userId, request);
        return ok();
    }
}
