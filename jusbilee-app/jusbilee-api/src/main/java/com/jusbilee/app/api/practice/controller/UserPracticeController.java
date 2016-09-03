/**
 * zhandc 2016年9月2日
 */
package com.jusbilee.app.api.practice.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jusbilee.app.api.practice.domain.UserPracticeActLogDomain;
import com.jusbilee.app.api.practice.domain.UserPracticeSong;
import com.jusbilee.app.api.practice.request.UserPracticeRequest;
import com.jusbilee.app.api.practice.service.UserPracticeService;
import com.jusbilee.app.base.BaseController;
import com.jusbilee.app.context.HttpContext;
import com.jusbilee.app.mybatis.pojo.UserPracticeActLog;
import com.jusbilee.app.mybatis.pojo.UserPracticeUnlockLog;
import com.rockit.core.pojo.JsonResult;

/**
 * @author zhandc 2016年9月2日
 *
 */

@RestController
@RequestMapping("/user/practice")
public class UserPracticeController extends BaseController{
	
	@Autowired
	private UserPracticeService userPracticeService;

	/**
	 * 获取用户练习记录列表
	 * @param styleId
	 * @return
	 */
    @RequestMapping("/log/list")
    public JsonResult getUserPracticeList(@RequestParam(required = true) Integer styleId) {
        Long userId = HttpContext.current().getUserId();
        List<UserPracticeActLogDomain> practiceSongs = userPracticeService.getUserPracticeList(userId, styleId);
        return ok(practiceSongs);
    }

    /**
     * 获取用户练习库的歌曲列表
     * @param styleId
     * @return
     */
    @RequestMapping("/song/list")
    public JsonResult getUserStageSongList(@RequestParam(required = true) Integer styleId) {
        Long userId = HttpContext.current().getUserId();
        List<UserPracticeSong> songs = userPracticeService.getUserStageSongList(userId, styleId);
        return ok(songs);
    }
    
    /**
     * 练习歌曲的解锁
     * @param data
     * @param bindingResult
     * @return
     */
    @RequestMapping("/unlock")
    public JsonResult practiceSongUnlock(@Valid @ModelAttribute UserPracticeRequest.practiceUnlockData data, BindingResult bindingResult) {
        assertValid(bindingResult);

        Long userId = HttpContext.current().getUserId();
        UserPracticeUnlockLog userPracticeUnlockLog = new UserPracticeUnlockLog();
        userPracticeUnlockLog.setUserId(userId);
        userPracticeUnlockLog.setPracticeSongId(data.getPracticeSongId());
        userPracticeUnlockLog.setGoldCoin(data.getGoldCoin());
        userPracticeUnlockLog.setCreateTime(new Date());

        userPracticeService.practiceSongUnlock(userPracticeUnlockLog);
        return ok();
    }
    
    /**
     * 练习歌曲的练习
     * @param data
     * @param bindingResult
     * @return
     */
    @RequestMapping("/act")
    public JsonResult practiceActLog(@Valid @ModelAttribute UserPracticeRequest.actLogData data, BindingResult bindingResult) {
        assertValid(bindingResult);

        Long userId = HttpContext.current().getUserId();
        UserPracticeActLog userPracticeActLog = new UserPracticeActLog();
        userPracticeActLog.setUserId(userId);
        userPracticeActLog.setPracticeSongId(data.getPracticeSongId());
        userPracticeActLog.setStyleId(data.getStyleId());
        userPracticeActLog.setTotalPracticeTime(data.getPracticeTime());
        userPracticeActLog.setTotalPracticeScore(data.getPracticeScore());
        userPracticeActLog.setBestAvgScore(data.getBestTime());
        userPracticeActLog.setCreateTime(new Date());

        userPracticeService.practiceActLog(userPracticeActLog);
        return ok();
    }
    

}
