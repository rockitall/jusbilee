package com.jusbilee.app.admin.service;

import com.jusbilee.app.admin.criteria.RaceSeasonQueryCriteria;
import com.jusbilee.app.admin.dao.RaceSeasonDao;
import com.jusbilee.app.admin.domain.AdminRaceSeasonListItem;
import com.jusbilee.app.mybatis.dao.RaceSeasonMapper;
import com.jusbilee.app.mybatis.pojo.RaceSeason;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.rockit.core.Constants.BOOL.YES;

/**
 * Created by Allen on 2016/9/15.
 */
@Service
public class RaceSeasonService {
    @Autowired
    private RaceSeasonDao raceSeasonDao;
    @Autowired
    private RaceSeasonMapper raceSeasonMapper;

    public long countRaceSeason(RaceSeasonQueryCriteria criteria) {
        return raceSeasonDao.count(criteria);
    }

    public List<AdminRaceSeasonListItem> queryRaceSeason(RaceSeasonQueryCriteria criteria, Pagination pagination) {
        return raceSeasonDao.query(criteria, pagination);
    }

    public void updateRaceSeason(Integer seasonId, RaceSeason season) {
        season.setId(seasonId);
        raceSeasonMapper.updateByPrimaryKeySelective(season);
    }

    public void addRaceSeason(RaceSeason season) {
        raceSeasonMapper.insertSelective(season);
    }

    public RaceSeason getRaceSeason(Integer seasonId) {
        return raceSeasonMapper.selectByPrimaryKey(seasonId);
    }

    public void deleteRaceSeason(Integer seasonId) {
        RaceSeason season = new RaceSeason();
        season.setIsDeleted(YES);
        season.setId(seasonId);
        raceSeasonMapper.updateByPrimaryKeySelective(season);
    }
}
