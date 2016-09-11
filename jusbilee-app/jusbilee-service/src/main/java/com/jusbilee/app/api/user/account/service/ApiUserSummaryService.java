package com.jusbilee.app.api.user.account.service;

import com.jusbilee.app.mybatis.dao.UserSummaryMapper;
import com.jusbilee.app.mybatis.pojo.UserSummary;
import com.jusbilee.app.mybatis.pojo.UserSummaryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Allen on 2016/9/11.
 */
@Service
public class ApiUserSummaryService {
    @Autowired
    private UserSummaryMapper userSummaryMapper;

    public void updateUserSummaryByUserId(Long userId, UserSummary summary) {
        UserSummaryCriteria criteria = new UserSummaryCriteria();
        criteria.createCriteria().andUserIdEqualTo(userId);

        userSummaryMapper.updateByExampleSelective(summary, criteria);
    }
}
