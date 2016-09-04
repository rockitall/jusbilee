/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.admin.service;

import com.jusbilee.app.admin.criteria.AdminPracticeSongCriteria;
import com.jusbilee.app.admin.dao.AdminPracticeSongDao;
import com.jusbilee.app.admin.domain.AdminPracticeSongListItem;
import com.jusbilee.app.admin.domain.Status;
import com.jusbilee.app.mybatis.dao.PracticeSongMapper;
import com.jusbilee.app.mybatis.pojo.PracticeSong;
import com.jusbilee.app.mybatis.pojo.PracticeSongCriteria;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class AdminPracticeSongService {
    @Autowired
    private PracticeSongMapper practiceSongMapper;

    @Autowired
    private AdminPracticeSongDao adminPracticeSongDao;

    public void add(PracticeSong practiceSong) {
        PracticeSongCriteria criteria = new PracticeSongCriteria();
        criteria.createCriteria().andStatusNotEqualTo(Status.PracticeSongStatus.DELETED).andSongIdEqualTo(practiceSong.getSongId());
        List<PracticeSong> songs = practiceSongMapper.selectByExample(criteria);
        if (songs.isEmpty()) {
            practiceSong.setCreateTime(new Date());
            practiceSongMapper.insertSelective(practiceSong);
        }
    }

    public void updateById(Integer practiceSongId, PracticeSong song) {
        song.setId(practiceSongId);
        practiceSongMapper.updateByPrimaryKeySelective(song);
    }

    public PracticeSong selectById(Integer practiceSongId) {
        return practiceSongMapper.selectByPrimaryKey(practiceSongId);
    }

    public List<AdminPracticeSongListItem> queryPracticeSong(AdminPracticeSongCriteria criteria, Pagination pagination) {
        return adminPracticeSongDao.query(criteria, pagination);
    }

    public long countPracticeSong(AdminPracticeSongCriteria criteria) {
        return adminPracticeSongDao.count(criteria);
    }

    public void deletePracticeSong(Integer practiceSongId) {
        PracticeSong song = new PracticeSong();
        song.setId(practiceSongId);
        song.setStatus(Status.PracticeSongStatus.DELETED);
        practiceSongMapper.updateByPrimaryKeySelective(song);
    }
}
