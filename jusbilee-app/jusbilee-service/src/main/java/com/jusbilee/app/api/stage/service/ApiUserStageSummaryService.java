package com.jusbilee.app.api.stage.service;

import com.jusbilee.app.api.stage.dao.ApiUserStageSummaryDao;
import com.jusbilee.app.api.stage.domain.ApiStageLevelSongCount;
import com.jusbilee.app.api.stage.domain.ApiUserStageSummary;
import com.jusbilee.app.mybatis.dao.UserStageSummaryMapper;
import com.jusbilee.app.mybatis.pojo.StageSong;
import com.jusbilee.app.mybatis.pojo.UserStageSummary;
import com.jusbilee.app.mybatis.pojo.UserStageSummaryCriteria;
import com.rockit.core.utils.IdentityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.rockit.core.Constants.BOOL.NO;
import static com.rockit.core.Constants.BOOL.YES;

/**
 * Created by Allen on 2016/8/23.
 */
@Service
public class ApiUserStageSummaryService {
    @Autowired
    private ApiUserStageSummaryDao apiUserStageSummaryDao;
    @Autowired
    private UserStageSummaryMapper userStageSummaryMapper;

    public Map<Integer, ApiStageLevelSongCount> getUserAllStageLevelPassedSongCount(Long userId) {
        List<ApiStageLevelSongCount> counts = apiUserStageSummaryDao.getUserAllStageLevelPassedSongCount(userId);
        return IdentityUtils.asMap(counts, v -> v.getLevelId());
    }

    public Map<Integer, ApiUserStageSummary> getUserStageSummaryListBySongIdList(Long userId, List<Integer> songIdList) {
        List<ApiUserStageSummary> summaries = apiUserStageSummaryDao.selectBySongIdList(userId, songIdList);
        return IdentityUtils.asMap(summaries, v -> v.getSongId());
    }

    public UserStageSummary getUserStageSummaryBySongId(Integer songId) {
        UserStageSummaryCriteria criteria = new UserStageSummaryCriteria();
        criteria.createCriteria().andSongIdEqualTo(songId);
        List<UserStageSummary> summaries = userStageSummaryMapper.selectByExample(criteria);
        return summaries.isEmpty() ? null : summaries.get(0);
    }

    public void increaseStageCountById(Integer id) {
        apiUserStageSummaryDao.increaseStageCountById(id);
    }

    public void updateScoreAndAssistUserIdById(Integer id, Integer score, Long assistUserId) {
        if (assistUserId == null) {
            apiUserStageSummaryDao.updateScoreWithAssistById(id, score, assistUserId);
        } else {
            apiUserStageSummaryDao.updateScoreWithoutAssistById(id, score);
        }
    }

    public void addUserStageSummaryViaPassStage(Long userId, StageSong song, Integer score, Long assistUserId) {
        UserStageSummary summary = new UserStageSummary();
        summary.setUserId(userId);
        updateAsssistUserId(summary, assistUserId);
        summary.setStageCount(1);
        summary.setSongId(song.getSongId());
        summary.setStageLevelId(song.getStageLevelId());
        summary.setStageSongId(song.getId());
        Byte isPassed = (score >= song.getPassScore() ? YES : NO);
        summary.setIsPassed(isPassed);
        summary.setScore(score);
        summary.setCreateTime(new Date());

        userStageSummaryMapper.insertSelective(summary);
    }

    public void updateUserStageSummary(UserStageSummary summary, Byte isPassed, Integer score, Long assistUserId) {
        UserStageSummary update = new UserStageSummary();
        update.setScore(score);
        update.setIsPassed(isPassed);
        update.setId(summary.getId());
        update.setStageCount(summary.getStageCount() + 1);
        updateAsssistUserId(update, assistUserId);

        userStageSummaryMapper.updateByPrimaryKeySelective(update);
    }

    private void updateAsssistUserId(UserStageSummary summary, Long assistUserId) {
        if (assistUserId == null) {
            summary.setIsAssist(NO);
            summary.setAssistUserId(0L);
        } else {
            summary.setIsAssist(YES);
            summary.setAssistUserId(assistUserId);
        }
    }
}
