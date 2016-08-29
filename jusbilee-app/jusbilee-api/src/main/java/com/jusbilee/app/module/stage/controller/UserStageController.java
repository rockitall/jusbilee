package com.jusbilee.app.module.stage.controller;


import com.jusbilee.app.base.BaseController;
import com.jusbilee.app.module.stage.domain.UserStageSong;
import com.jusbilee.app.module.stage.request.UserStageRequests;
import com.jusbilee.app.module.stage.service.UserStageService;
import com.jusbilee.app.mybatis.pojo.UserStageActLog;
import com.jusbilee.app.module.stage.domain.UserStageLevel;
import com.jusbilee.app.context.HttpContext;
import com.rockit.core.pojo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user/stage")
public class UserStageController extends BaseController {
    @Autowired
    private UserStageService userStageService;

    @RequestMapping("/level/list")
    public JsonResult getUserStageLevelList() {
        Long userId = HttpContext.current().getUserId();
        List<UserStageLevel> levels = userStageService.getUserStageLevelList(userId);
        return ok(levels);
    }

    @RequestMapping("/song/list")
    public JsonResult getStageLevelSongList(@RequestParam(required = true) Integer stageLevelId) {
        Long userId = HttpContext.current().getUserId();
        List<UserStageSong> songs = userStageService.getUserStageSongList(userId, stageLevelId);
        return ok(songs);
    }

    @RequestMapping("/record")
    public JsonResult recordStagePlay(@Valid @ModelAttribute UserStageRequests.UserStageData data, BindingResult bindingResult) {
        assertValid(bindingResult);

        Long userId = HttpContext.current().getUserId();
        UserStageActLog log = new UserStageActLog();
        log.setUserId(userId);
        log.setAssistUserId(data.getAssistUserId());
        log.setStageSongId(data.getStageSongId());
        log.setScore(data.getScore());

        userStageService.recordStagePlay(log);
        return ok();
    }
}
