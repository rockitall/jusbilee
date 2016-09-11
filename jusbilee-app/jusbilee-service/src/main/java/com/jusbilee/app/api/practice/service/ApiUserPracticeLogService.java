package com.jusbilee.app.api.practice.service;

import com.jusbilee.app.mybatis.dao.UserPracticeLogMapper;
import com.jusbilee.app.mybatis.pojo.UserPracticeLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Allen on 2016/9/11.
 */
@Service
public class ApiUserPracticeLogService {
    @Autowired
    private UserPracticeLogMapper userPracticeLogMapper;

    public void addPracticeLog(UserPracticeLog log) {
        log.setCreateTime(new Date());
        userPracticeLogMapper.insertSelective(log);
    }
}
