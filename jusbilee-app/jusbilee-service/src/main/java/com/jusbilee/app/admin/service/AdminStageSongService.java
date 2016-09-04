/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.admin.service;

import com.jusbilee.app.admin.criteria.AdminStageSongQueryCriteria;
import com.jusbilee.app.admin.dao.AdminStageSongDao;
import com.jusbilee.app.admin.domain.AdminStageSongListItem;
import com.jusbilee.app.admin.domain.Status;
import com.jusbilee.app.mybatis.dao.StageSongMapper;
import com.jusbilee.app.mybatis.pojo.StageSong;
import com.jusbilee.app.mybatis.pojo.StageSongCriteria;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zhandc 2016年8月28日
 */

@Service
public class AdminStageSongService {
    @Autowired
    private StageSongMapper stageSongMapper;
    @Autowired
    private AdminStageSongDao adminStageSongDao;

    public void add(StageSong stageSong) {
        StageSongCriteria criteria = new StageSongCriteria();
        criteria.createCriteria().andStatusNotEqualTo(Status.StageSongStatus.DELETED).andSongIdEqualTo(stageSong.getSongId());
        List<StageSong> songs = stageSongMapper.selectByExample(criteria);
        if (songs.isEmpty()) {
            stageSong.setCreateTime(new Date());
            stageSongMapper.insertSelective(stageSong);
        }
    }

    public void delete(Integer id) {
        stageSongMapper.deleteByPrimaryKey(id);
    }

    public void updateById(Integer id, StageSong song) {
        song.setId(id);
        stageSongMapper.updateByPrimaryKeySelective(song);
    }

    public StageSong selectById(Integer stageSongId) {
        return stageSongMapper.selectByPrimaryKey(stageSongId);
    }

    public List<AdminStageSongListItem> queryStageSong(AdminStageSongQueryCriteria criteria, Pagination pagination) {
        return adminStageSongDao.query(criteria, pagination);
    }

    public long countStageSong(AdminStageSongQueryCriteria criteria) {
        return adminStageSongDao.count(criteria);
    }

    public void deleteById(Integer stageSongId) {
        StageSong song = new StageSong();
        song.setStatus(Status.StageSongStatus.DELETED);
        song.setId(stageSongId);
        stageSongMapper.updateByPrimaryKeySelective(song);
    }
}
