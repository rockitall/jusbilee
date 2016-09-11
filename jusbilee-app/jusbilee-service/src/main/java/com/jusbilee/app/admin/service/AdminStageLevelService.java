package com.jusbilee.app.admin.service;

import com.jusbilee.app.mybatis.dao.StageLevelMapper;
import com.jusbilee.app.mybatis.pojo.StageLevel;
import com.jusbilee.app.mybatis.pojo.StageLevelCriteria;
import com.rockit.core.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Allen on 2016/8/23.
 */
@Service
public class AdminStageLevelService {
    @Autowired
    private StageLevelMapper stageLevelMapper;

    public List<StageLevel> list() {
        StageLevelCriteria criteria = new StageLevelCriteria();
        criteria.createCriteria().andIsDeletedEqualTo(Constants.BOOL.NO);
        criteria.setOrderByClause("weight asc, create_time desc");
        return stageLevelMapper.selectByExample(criteria);
    }

    public void addStageLevel(StageLevel level) {
        level.setCreateTime(new Date());
        stageLevelMapper.insertSelective(level);
    }

    public void updateStageLevel(StageLevel level) {
        stageLevelMapper.updateByPrimaryKeySelective(level);
    }

    public void deleteStageLevel(Integer id) {
        StageLevel level = new StageLevel();
        level.setId(id);
        level.setIsDeleted(Constants.BOOL.YES);
        stageLevelMapper.updateByPrimaryKeySelective(level);
    }
}
