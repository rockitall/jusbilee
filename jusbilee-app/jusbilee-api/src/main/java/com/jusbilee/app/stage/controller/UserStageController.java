package com.jusbilee.app.stage.controller;


import com.jusbilee.app.base.BaseController;
import com.jusbilee.app.mybatis.pojo.UserStageActLog;
import com.jusbilee.app.sms.param.SmsParam;
import com.jusbilee.app.sms.param.VerifyCode;
import com.jusbilee.app.sms.service.SmsService;
import com.jusbilee.app.stage.domain.UserStageLevel;
import com.jusbilee.app.stage.domain.UserStageSong;
import com.jusbilee.app.stage.request.UserStageRequests;
import com.jusbilee.app.stage.service.UserStageService;
import com.jusbilee.app.user.account.domain.AccessToken;
import com.jusbilee.app.user.account.domain.AppUser;
import com.jusbilee.app.user.account.param.Credentials;
import com.jusbilee.app.user.account.param.PasswordModification;
import com.jusbilee.app.user.account.param.Registration;
import com.jusbilee.app.user.account.param.ThirdUserCredentials;
import com.jusbilee.app.user.account.service.IUserAccountService;
import com.jusbilee.app.user.domain.AppUserProfile;
import com.jusbilee.app.user.request.UserProfileModificationRequest;
import com.rockit.core.context.HttpContext;
import com.rockit.core.pojo.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.File;
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
