package com.jusbilee.app.admin.service;

import com.jusbilee.app.admin.criteria.AdminSongQueryCriteria;
import com.jusbilee.app.admin.dao.AdminSongDao;
import com.jusbilee.app.admin.domain.AdminSongListItem;
import com.jusbilee.app.mybatis.dao.SongMapper;
import com.jusbilee.app.mybatis.pojo.Song;
import com.jusbilee.app.mybatis.pojo.SongCriteria;
import com.rockit.core.Constants;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Allen on 2016/9/3.
 */
@Service
public class AdminSongService {
    @Autowired
    private AdminSongDao songDao;

    @Autowired
    private SongMapper mapper;

    public List<AdminSongListItem> query(AdminSongQueryCriteria cretiria, Pagination pagination) {
        return songDao.query(cretiria, pagination);
    }

    public long count(AdminSongQueryCriteria cretiria, Pagination pagination) {
        return songDao.count(cretiria, pagination);
    }

    public void addSong(Song song) {
        song.setCreateTime(new Date());
        mapper.insertSelective(song);
    }

    public void deleteSong(Integer id) {
        Song song = new Song();
        song.setId(id);
        song.setIsDeleted(Constants.BOOL.YES);
        mapper.updateByPrimaryKeySelective(song);
    }

    public List<Song> selectByIdList(List<Integer> ids) {
        SongCriteria criteria = new SongCriteria();
        criteria.createCriteria().andIdIn(ids);
        return mapper.selectByExample(criteria);
    }

    public Song selectById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public void update(Song song) {
        mapper.updateByPrimaryKeySelective(song);
    }
}
