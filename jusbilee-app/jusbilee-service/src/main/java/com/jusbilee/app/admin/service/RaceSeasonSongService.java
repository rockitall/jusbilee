package com.jusbilee.app.admin.service;

import com.jusbilee.app.admin.criteria.RaceSeasonSongQueryCriteria;
import com.jusbilee.app.admin.criteria.RaceSeasonSongSelectQueryCriteria;
import com.jusbilee.app.admin.dao.RaceSeasonSongDao;
import com.jusbilee.app.admin.domain.AdminRaceSeasonSongListItem;
import com.jusbilee.app.admin.domain.AdminRaceSeasonSongSelectListItem;
import com.jusbilee.app.mybatis.dao.RaceSeasonSongMapper;
import com.jusbilee.app.mybatis.pojo.RaceSeasonSong;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.rockit.core.Constants.BOOL.YES;

/**
 * Created by Allen on 2016/9/16.
 */

@Service
public class RaceSeasonSongService {
    @Autowired
    private RaceSeasonSongDao raceSeasonSongDao;
    @Autowired
    private RaceSeasonSongMapper raceSeasonSongMapper;

    public List<AdminRaceSeasonSongListItem> queryRaceSeasonSong(RaceSeasonSongQueryCriteria criteria, Pagination pagination) {
        return raceSeasonSongDao.query(criteria, pagination);
    }

    public long countRaceSeasonSong(RaceSeasonSongQueryCriteria criteria) {
        return raceSeasonSongDao.count(criteria);
    }

    public void deleteRaceSeasonSong(Integer seasonSongId) {
        RaceSeasonSong song = new RaceSeasonSong();
        song.setId(seasonSongId);
        song.setIsDeleted(YES);
        raceSeasonSongMapper.updateByPrimaryKeySelective(song);
    }

    public long countRaceSeasonSongSelect(RaceSeasonSongSelectQueryCriteria criteria) {
        return raceSeasonSongDao.countSelect(criteria);
    }

    public List<AdminRaceSeasonSongSelectListItem> queryRaceSeasonSongSelect(RaceSeasonSongSelectQueryCriteria criteria, Pagination pagination) {
        return raceSeasonSongDao.querySelect(criteria, pagination);
    }

    public void addRaceSeasonSong(RaceSeasonSong song) {
        song.setCreateTime(new Date());
        raceSeasonSongMapper.insertSelective(song);
    }
}
