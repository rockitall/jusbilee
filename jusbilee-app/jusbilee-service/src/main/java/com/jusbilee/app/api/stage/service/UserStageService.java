package com.jusbilee.app.api.stage.service;

import com.jusbilee.app.mybatis.dao.StageSongMapper;
import com.jusbilee.app.mybatis.dao.UserStageActLogMapper;
import com.jusbilee.app.mybatis.dao.UserSummaryMapper;
import com.jusbilee.app.mybatis.pojo.*;
import com.jusbilee.app.api.stage.dao.UserStageDao;
import com.jusbilee.app.api.stage.domain.UserStageLevel;
import com.jusbilee.app.api.stage.domain.UserStageSong;
import com.rockit.core.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Allen on 2016/8/24.
 */
@Service
public class UserStageService {
    @Autowired
    private UserStageDao userStageDao;

    @Autowired
    private UserStageActLogMapper userStageActLogMapper;

    @Autowired
    private StageSongMapper stageSongMapper;

    @Autowired
    private UserSummaryMapper userSummaryMapper;


    public List<UserStageLevel> getUserStageLevelList(Long userId) {
        return userStageDao.getUserStageLevelList(userId);
    }

    public List<UserStageSong> getUserStageSongList(Long userId, Integer stageLevelId) {
        return userStageDao.getUserStageSongList(userId, stageLevelId);
    }

    public void recordStagePlay(UserStageActLog log) {
        UserStageActLog existsLog = getUserStageActLogByStageSongId(log.getUserId(), log.getStageSongId());
        if (existsLog != null) {
            if (log.getScore() <= existsLog.getScore()) {
                UserStageActLog update = new UserStageActLog();
                update.setId(existsLog.getId());
                update.setActCount(existsLog.getActCount() + 1);
                userStageActLogMapper.updateByPrimaryKeySelective(update);
                return;
            }

            log.setActCount(existsLog.getActCount() + 1);
            log.setId(existsLog.getId());

            if (!Constants.BOOL.isTrue(existsLog.getIsPassed())) {
                StageSong song = stageSongMapper.selectByPrimaryKey(log.getStageSongId());
                if (song.getPassScore() <= log.getScore()) {
                    log.setIsPassed(Constants.BOOL.YES);
                }
            }


            userStageActLogMapper.updateByPrimaryKeySelective(log);
            return;
        }

        StageSong song = stageSongMapper.selectByPrimaryKey(log.getStageSongId());


        if (log.getScore() >= song.getPassScore()) {
            log.setIsPassed(Constants.BOOL.YES);
        }

        log.setCreateTime(new Date());
        userStageActLogMapper.insertSelective(log);
    }

    private UserSummary getUserSummaryBuUserId(Long userId) {
        UserSummaryCriteria criteria = new UserSummaryCriteria();
        criteria.createCriteria().andUserIdEqualTo(userId);
        List<UserSummary> summaryList = userSummaryMapper.selectByExample(criteria);
        return summaryList.get(0);
    }

    private UserStageActLog getUserStageActLogByStageSongId(Long userId, Integer stageSongId) {
        UserStageActLogCriteria criteria = new UserStageActLogCriteria();
        criteria.createCriteria().andUserIdEqualTo(userId).andStageSongIdEqualTo(stageSongId).andIsDeletedEqualTo(Constants.BOOL.NO);
        List<UserStageActLog> logs = userStageActLogMapper.selectByExample(criteria);
        if (logs.isEmpty()) {
            return null;
        }
        return logs.get(0);
    }
}