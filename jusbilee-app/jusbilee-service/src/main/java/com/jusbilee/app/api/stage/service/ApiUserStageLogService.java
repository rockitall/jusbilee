package com.jusbilee.app.api.stage.service;

import com.jusbilee.app.mybatis.dao.UserStageLogMapper;
import com.jusbilee.app.mybatis.pojo.StageSong;
import com.jusbilee.app.mybatis.pojo.UserStageLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.rockit.core.Constants.BOOL.NO;
import static com.rockit.core.Constants.BOOL.YES;

/**
 * Created by Allen on 2016/8/23.
 */
@Service
public class ApiUserStageLogService {
    @Autowired
    private UserStageLogMapper userStageLogMapper;

    public void log(Long userId, StageSong song, Integer score, Long assistUserId) {
        UserStageLog log = new UserStageLog();
        log.setUserId(userId);
        if (assistUserId == null) {
            log.setIsAssist(NO);
            log.setAssistUserId(0L);
        } else {
            log.setIsAssist(YES);
            log.setAssistUserId(assistUserId);
        }
        log.setSongId(song.getSongId());
        log.setStageLevelId(song.getStageLevelId());
        log.setStageSongId(song.getId());
        Byte isPassed = (score >= song.getPassScore() ? YES : NO);
        log.setIsPassed(isPassed);
        log.setScore(score);
        log.setCreateTime(new Date());

        userStageLogMapper.insertSelective(log);
    }
}
