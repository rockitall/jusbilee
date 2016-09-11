package com.jusbilee.app.api.practice.controller;

import com.jusbilee.app.api.practice.manager.PracticeManager;
import com.jusbilee.app.api.practice.request.UserPracticeRequest;
import com.jusbilee.app.api.practice.response.PracticeLogSongFacade;
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

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user/practice")
public class UserPracticeController extends BaseController {
    @Autowired
    private PracticeManager practiceManager;

    /**
     * 获取用户练习记录列表
     *
     * @param styleId
     * @param pagination
     * @param bindingResult
     * @return
     */
    @RequestMapping("/log/song/list")
    public JsonResult getPracticeLogSongList(@RequestParam Integer styleId,
                                             @ModelAttribute Pagination pagination, BindingResult bindingResult) {
        assertValid(bindingResult);
        Long userId = HttpContext.current().getUserId();
        List<PracticeLogSongFacade> facades = practiceManager.getPracticeLogSongListByStyleId(userId, styleId,
                pagination);
        return ok(facades);
    }

    /**
     * 解锁歌曲练习
     *
     * @param songId
     * @return
     */
    @RequestMapping("/song/unlock")
    public JsonResult unlockPracticeSongViaGoldCoin(@RequestParam("songId") Integer songId) {
        Long userId = HttpContext.current().getUserId();
        practiceManager.unlockPracticeSongViaGoldCoin(userId, songId);
        return ok();
    }


    /**
     * 歌曲练习
     *
     * @param request
     * @param bindingResult
     * @return
     */
    @RequestMapping("/song")
    public JsonResult practice(@Valid @ModelAttribute UserPracticeRequest request,
                               BindingResult bindingResult) {
        assertValid(bindingResult);
        Long userId = HttpContext.current().getUserId();
        practiceManager.practice(userId, request);
        return ok();
    }
}
