package com.jusbilee.app.admin.service;

import com.jusbilee.app.mybatis.dao.SongLevelMapper;
import com.jusbilee.app.mybatis.pojo.SongLevel;
import com.jusbilee.app.mybatis.pojo.SongLevelCriteria;
import com.rockit.core.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Allen on 2016/8/23.
 */
@Service
public class AdminSongLevelService {
    @Autowired
    private SongLevelMapper songLevelMapper;

    public List<SongLevel> list() {
        SongLevelCriteria criteria = new SongLevelCriteria();
        criteria.createCriteria().andIsDeletedEqualTo(Constants.BOOL.NO);
        criteria.setOrderByClause("weight asc, create_time desc");
        return songLevelMapper.selectByExample(criteria);
    }

    public void addSongLevel(SongLevel level) {
        level.setCreateTime(new Date());
        songLevelMapper.insertSelective(level);
    }

    public void updateSongLevel(SongLevel level) {
        songLevelMapper.updateByPrimaryKeySelective(level);
    }

    public void deleteSongLevel(Integer id) {
        SongLevel level = new SongLevel();
        level.setId(id);
        level.setIsDeleted(Constants.BOOL.YES);
        songLevelMapper.updateByPrimaryKeySelective(level);
    }
}
