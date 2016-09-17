package com.jusbilee.app.admin.manager;

import com.jusbilee.app.admin.criteria.RaceSeasonSongQueryCriteria;
import com.jusbilee.app.admin.criteria.RaceSeasonSongSelectQueryCriteria;
import com.jusbilee.app.admin.domain.AdminRaceSeasonSongListItem;
import com.jusbilee.app.admin.domain.AdminRaceSeasonSongSelectListItem;
import com.jusbilee.app.admin.request.RaceSeasonSongRequest;
import com.jusbilee.app.admin.service.AdminSongService;
import com.jusbilee.app.admin.service.RaceSeasonSongService;
import com.jusbilee.app.mybatis.pojo.RaceSeasonSong;
import com.jusbilee.app.mybatis.pojo.Song;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Allen on 2016/9/15.
 */
@Service
public class RaceSeasonSongManager {
    @Autowired
    private RaceSeasonSongService raceSeasonSongService;
    @Autowired
    private AdminSongService adminSongService;

    public List<AdminRaceSeasonSongListItem> queryRaceSeasonSong(RaceSeasonSongQueryCriteria criteria, Pagination pagination) {
        return raceSeasonSongService.queryRaceSeasonSong(criteria, pagination);
    }

    public long countRaceSeasonSong(RaceSeasonSongQueryCriteria criteria) {
        return raceSeasonSongService.countRaceSeasonSong(criteria);
    }

    @Transactional
    public void addRaceSeasonSong(RaceSeasonSongRequest request) {

        List<Song> songs = adminSongService.selectByIdList(Arrays.asList(request.getSongIdList()));

        RaceSeasonSong song = new RaceSeasonSong();
        song.setSeasonId(request.getSeasonId());
        song.setSubLevelId(request.getSubLevelId());
        songs.stream().forEach(s -> {
            song.setLevelId(s.getLevelId());
            song.setSongId(s.getId());

            raceSeasonSongService.addRaceSeasonSong(song);
        });
    }

    public void deleteRaceSeasonSong(Integer seasonSongId) {
        raceSeasonSongService.deleteRaceSeasonSong(seasonSongId);
    }

    public long countRaceSeasonSongSelect(RaceSeasonSongSelectQueryCriteria criteria) {
        return raceSeasonSongService.countRaceSeasonSongSelect(criteria);
    }

    public List<AdminRaceSeasonSongSelectListItem> queryRaceSeasonSongSelect(RaceSeasonSongSelectQueryCriteria criteria, Pagination pagination) {
        return raceSeasonSongService.queryRaceSeasonSongSelect(criteria, pagination);
    }
}
