package com.jusbilee.app.admin.service;

import com.jusbilee.app.mybatis.dao.SongStyleMapper;
import com.jusbilee.app.mybatis.pojo.SongStyle;
import com.jusbilee.app.mybatis.pojo.SongStyleCriteria;
import com.rockit.core.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Allen on 2016/8/23.
 */
@Service
public class AdminSongStyleService {
    @Autowired
    private SongStyleMapper songStyleMapper;

    public List<SongStyle> list() {
        SongStyleCriteria criteria = new SongStyleCriteria();
        criteria.createCriteria().andIsDeletedEqualTo(Constants.BOOL.NO);
        criteria.setOrderByClause("sort_order asc, create_time desc");
        return songStyleMapper.selectByExample(criteria);
    }

    public void addSongStyle(SongStyle style) {
        style.setCreateTime(new Date());
        songStyleMapper.insertSelective(style);
    }

    public void updateSongStyle(SongStyle style) {
        songStyleMapper.updateByPrimaryKeySelective(style);
    }

    public void deleteSongStyle(Integer id) {
        SongStyle style = new SongStyle();
        style.setId(id);
        style.setIsDeleted(Constants.BOOL.YES);
        songStyleMapper.updateByPrimaryKeySelective(style);
    }
}
