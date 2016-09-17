package com.jusbilee.app.admin.manager;

import com.jusbilee.app.admin.criteria.RaceSeasonQueryCriteria;
import com.jusbilee.app.admin.domain.AdminRaceSeasonListItem;
import com.jusbilee.app.admin.request.RaceSeasonRequest;
import com.jusbilee.app.admin.service.RaceSeasonService;
import com.jusbilee.app.mybatis.pojo.RaceSeason;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Allen on 2016/9/15.
 */
@Service
public class RaceSeasonManager {
    @Autowired
    private RaceSeasonService raceSeasonService;

    public long countRaceSeason(RaceSeasonQueryCriteria criteria) {
        return raceSeasonService.countRaceSeason(criteria);
    }

    public List<AdminRaceSeasonListItem> queryRaceSeason(RaceSeasonQueryCriteria criteria, Pagination pagination) {
        return raceSeasonService.queryRaceSeason(criteria, pagination);
    }

    public void addRaceSeason(RaceSeasonRequest request) {
        RaceSeason season = transformToRaceSeason(request);
        raceSeasonService.addRaceSeason(season);
    }

    public void updateRaceSeason(Integer seasonId, RaceSeasonRequest request) {
        RaceSeason season = transformToRaceSeason(request);
        raceSeasonService.updateRaceSeason(seasonId, season);
    }

    private RaceSeason transformToRaceSeason(RaceSeasonRequest request) {
        RaceSeason season = new RaceSeason();
        DateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
        try {
            season.setCreateTime(fmt.parse(request.getStartTime()));
            season.setEndTime(fmt.parse(request.getEndTime()));
            season.setSeasonName(request.getSeasonName());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return season;
    }

    public RaceSeason getRaceSeason(Integer seasonId) {
        return raceSeasonService.getRaceSeason(seasonId);
    }

    public void deleteRaceSeason(Integer seasonId) {
        raceSeasonService.deleteRaceSeason(seasonId);
    }
}
