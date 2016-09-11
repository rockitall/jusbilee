package com.jusbilee.app.api.coin.service;

import com.jusbilee.app.api.coin.domain.GoldCoinEventType;
import com.jusbilee.app.api.coin.domain.GoldCoinLogType;
import com.jusbilee.app.api.user.account.dao.ApiUserSummaryDao;
import com.jusbilee.app.mybatis.dao.UserGoldCoinLogMapper;
import com.jusbilee.app.mybatis.pojo.UserGoldCoinLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Allen on 2016/9/10.
 */
@Service
public class ApiUserGoldCoinService {
    @Autowired
    private ApiUserSummaryDao apiUserSummaryDao;
    @Autowired
    private UserGoldCoinLogMapper userGoldCoinLogMapper;

    public int getUserGoldCoin(Long userId) {
        return apiUserSummaryDao.getUserGoldCoin(userId);
    }

    public void consumeUserGoldCoinAndIncreaseUnlockCount(Long userId, Integer goldCoin) {
        apiUserSummaryDao.consumeUserGoldCoinAndIncreaseUnlockCount(userId, goldCoin);
    }

    public void consume(Long userId, Integer goldCoin) {
        apiUserSummaryDao.consumeUserGoldCoin(userId, goldCoin);
    }


    public void produce(Long userId, Integer goldCoin) {
        apiUserSummaryDao.produceUserGoldCoin(userId, goldCoin);
    }

    public void consumeLog(Long userId, GoldCoinEventType eventType, Integer goldCoin, Long targetId) {
        log(userId, GoldCoinLogType.CONSUME, eventType, goldCoin, targetId);
    }

    public void produceLog(Long userId, GoldCoinEventType eventType, Integer goldCoin, Long targetId) {
        log(userId, GoldCoinLogType.PRODUCE, eventType, goldCoin, targetId);
    }

    private void log(Long userId, GoldCoinLogType logType, GoldCoinEventType eventType, Integer goldCoin, Long eventTargetId) {
        UserGoldCoinLog log = new UserGoldCoinLog();
        log.setEventId(eventType.getEventId());
        log.setEventName(eventType.getEventName());
        log.setType(logType.getValue());
        log.setEventTargetId(eventTargetId);
        log.setGoldCoin(goldCoin);
        log.setUserId(userId);
        log.setCreateTime(new Date());
        userGoldCoinLogMapper.insertSelective(log);
    }
}
