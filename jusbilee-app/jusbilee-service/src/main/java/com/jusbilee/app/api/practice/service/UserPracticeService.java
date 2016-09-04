/**
 * zhandc 2016年9月2日
 */
package com.jusbilee.app.api.practice.service;

import com.jusbilee.app.api.practice.dao.UserPracticeDao;
import com.jusbilee.app.api.practice.domain.UserPracticeActLogDomain;
import com.jusbilee.app.api.practice.domain.UserPracticeSong;
import com.jusbilee.app.exception.GoldCoinNotEnoughException;
import com.jusbilee.app.mybatis.dao.UserGoldCoinLogMapper;
import com.jusbilee.app.mybatis.dao.UserPracticeActLogMapper;
import com.jusbilee.app.mybatis.dao.UserPracticeUnlockLogMapper;
import com.jusbilee.app.mybatis.dao.UserSummaryMapper;
import com.jusbilee.app.mybatis.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author zhandc 2016年9月2日
 */

@Service
public class UserPracticeService {

    @Autowired
    private UserPracticeDao userPracticeDao;

    @Autowired
    private UserPracticeUnlockLogMapper userPracticeUnlockLogMapper;

    @Autowired
    private UserSummaryMapper userSummaryMapper;

    @Autowired
    private UserGoldCoinLogMapper userGoldCoinLogMapper;

    @Autowired
    UserPracticeActLogMapper userPracticeActLogMapper;

    public List<UserPracticeActLogDomain> getUserPracticeList(Long userId, Integer styleId) {
        return userPracticeDao.getUserPracticeList(userId, styleId);
    }

    public List<UserPracticeSong> getUserStageSongList(Long userId, Integer styleId) {
        return userPracticeDao.getUserStageSongList(userId, styleId);
    }

    @Transactional
    public void practiceSongUnlock(UserPracticeUnlockLog userPracticeUnlockLog) throws GoldCoinNotEnoughException {
        UserSummary userSummary = getUserSummaryBuUserId(userPracticeUnlockLog.getUserId());
        if (userPracticeUnlockLog.getGoldCoin() > userSummary.getTotalGoldCoin()) {
            throw new GoldCoinNotEnoughException();
        }
        // 解锁表
        userPracticeUnlockLogMapper.insertSelective(userPracticeUnlockLog);

        // 用户总结表
        userSummary.setTotalGoldCoin(userSummary.getTotalGoldCoin() - userPracticeUnlockLog.getGoldCoin());
        userSummary.setUnlockPracticeSongCount(userSummary.getUnlockPracticeSongCount() + 1);
        userSummary.setUpdateTime(new Date());
        userSummaryMapper.updateByPrimaryKeySelective(userSummary);

        // 用户金币收支记录表
        UserGoldCoinLog userGoldCoinLog = new UserGoldCoinLog();
        userGoldCoinLog.setUserId(userPracticeUnlockLog.getUserId());
        userGoldCoinLog.setType((byte) -1);
        userGoldCoinLog.setGoldCoin(userPracticeUnlockLog.getGoldCoin());
        userGoldCoinLog.setEventId(1);
        userGoldCoinLog.setEventTargetId(userPracticeUnlockLog.getPracticeSongId().longValue());
        userGoldCoinLog.setCreateTime(new Date());
        userGoldCoinLogMapper.insertSelective(userGoldCoinLog);
    }

    @Transactional
    public void practiceActLog(UserPracticeActLog userPracticeActLog) {

        UserPracticeActLog _userPracticeActLog = selectUserPracticeActLog(userPracticeActLog);

        if (_userPracticeActLog == null) {
            userPracticeActLogMapper.insertSelective(userPracticeActLog);
        } else {
            _userPracticeActLog.setTotalPracticeTime(_userPracticeActLog.getTotalPracticeTime() + userPracticeActLog.getTotalPracticeTime());
            _userPracticeActLog.setTotalPracticeCount(_userPracticeActLog.getTotalPracticeCount() + 1);
            _userPracticeActLog.setTotalPracticeScore(_userPracticeActLog.getTotalPracticeScore() + userPracticeActLog.getTotalPracticeScore());
            if (_userPracticeActLog.getBestAvgScore() < userPracticeActLog.getBestAvgScore()) {
                _userPracticeActLog.setBestAvgScore(userPracticeActLog.getBestAvgScore());
            }
            _userPracticeActLog.setFullScoreBestTime(_userPracticeActLog.getFullScoreBestTime() + userPracticeActLog.getFullScoreBestTime());
            _userPracticeActLog.setUpdateTime(new Date());
            userPracticeActLogMapper.updateByPrimaryKeySelective(_userPracticeActLog);
        }

        //更新用户总结表
        UserSummary userSummary = getUserSummaryBuUserId(userPracticeActLog.getUserId());
        userSummary.setTotalPracticeTime(userSummary.getTotalPracticeTime() + userPracticeActLog.getTotalPracticeTime());
        userSummary.setTotalPracticeScore(userSummary.getTotalPracticeCount() + userPracticeActLog.getTotalPracticeScore());
        userSummary.setTotalPracticeCount(userSummary.getTotalPracticeCount() + 1);
        userSummary.setUpdateTime(new Date());
        userSummaryMapper.updateByPrimaryKeySelective(userSummary);


    }

    private UserPracticeActLog selectUserPracticeActLog(UserPracticeActLog userPracticeActLog) {
        UserPracticeActLogCriteria criteria = new UserPracticeActLogCriteria();
        criteria.createCriteria().andUserIdEqualTo(userPracticeActLog.getUserId())
                .andPracticeSongIdEqualTo(userPracticeActLog.getPracticeSongId());
        List<UserPracticeActLog> list = userPracticeActLogMapper.selectByExample(criteria);
        if (list.size() < 1)
            return null;
        return list.get(0);
    }

    private UserSummary getUserSummaryBuUserId(Long userId) {
        UserSummaryCriteria criteria = new UserSummaryCriteria();
        criteria.createCriteria().andUserIdEqualTo(userId);
        List<UserSummary> summaryList = userSummaryMapper.selectByExample(criteria);

        return summaryList.get(0);
    }
}
