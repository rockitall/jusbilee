package com.jusbilee.app.admin.service;

import com.jusbilee.app.admin.criteria.AdminSongSubLevelQueryCriteria;
import com.jusbilee.app.admin.dao.SongSubLevelDao;
import com.jusbilee.app.admin.domain.AdminSongSubLevelListItem;
import com.jusbilee.app.mybatis.dao.SongSubLevelMapper;
import com.jusbilee.app.mybatis.pojo.SongSubLevel;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.rockit.core.Constants.BOOL.YES;

/**
 * Created by Allen on 2016/9/15.
 */
@Service
public class SongSubLevelService {
    @Autowired
    private SongSubLevelDao songSubLevelDao;

    @Autowired
    private SongSubLevelMapper songSubLevelMapper;

    public long countSongSubLevel(AdminSongSubLevelQueryCriteria criteria) {
        return songSubLevelDao.count(criteria);
    }

    public List<AdminSongSubLevelListItem> querySongSubLevel(AdminSongSubLevelQueryCriteria criteria, Pagination pagination) {
        return songSubLevelDao.query(criteria, pagination);
    }

    public void addSongSubLevel(SongSubLevel level) {
        level.setCreateTime(new Date());
        songSubLevelMapper.insertSelective(level);
    }

    public void updateSongSubLevel(Integer subLevelId, SongSubLevel level) {
        level.setId(subLevelId);
        songSubLevelMapper.updateByPrimaryKeySelective(level);
    }

    public void deleteSongSubLevel(Integer subLevelId) {
        SongSubLevel level = new SongSubLevel();
        level.setIsDeleted(YES);
        level.setId(subLevelId);
        songSubLevelMapper.updateByPrimaryKeySelective(level);
    }

    public SongSubLevel getSongSubLevel(Integer subLevelId) {
        return songSubLevelMapper.selectByPrimaryKey(subLevelId);
    }
}
