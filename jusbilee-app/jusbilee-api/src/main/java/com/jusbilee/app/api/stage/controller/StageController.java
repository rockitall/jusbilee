package com.jusbilee.app.api.stage.controller;


import com.jusbilee.app.api.stage.manager.StageManager;
import com.jusbilee.app.api.stage.response.StageLevelFacade;
import com.jusbilee.app.api.stage.response.StageSongFacade;
import com.jusbilee.app.base.BaseController;
import com.jusbilee.app.context.HttpContext;
import com.rockit.core.pojo.JsonResult;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StageController extends BaseController {
    @Autowired
    private StageManager stageManager;

    @RequestMapping("/stage/level/list")
    public JsonResult getSongLevelList() {
        Long userId = HttpContext.current().getUserId();
        List<StageLevelFacade> levels = stageManager.getAllSongLevel(userId);
        return ok(levels);
    }

    @RequestMapping("/stage/level/song/list")
    public JsonResult getUserStageLevelSongList(@RequestParam("levelId") Integer levelId,
                                                @ModelAttribute Pagination pagination, BindingResult bindingResult) {
        assertValid(bindingResult);

        Long userId = HttpContext.current().getUserId();
        List<StageSongFacade> facades = stageManager.getLevelStageSongList(userId, levelId, pagination);
        return ok(facades);
    }
}
