package com.jusbilee.app.api.stage.service;

import com.jusbilee.app.api.stage.dao.ApiStageSongDao;
import com.jusbilee.app.api.stage.domain.ApiStageSong;
import com.jusbilee.app.mybatis.dao.StageSongMapper;
import com.jusbilee.app.mybatis.pojo.StageSong;
import com.jusbilee.app.mybatis.pojo.StageSongCriteria;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Allen on 2016/8/23.
 */
@Service
public class ApiStageSongService {
    @Autowired
    private ApiStageSongDao apiStageSongDao;
    @Autowired
    private StageSongMapper stageSongMapper;

    public List<ApiStageSong> getStageSongByStageLevelId(Integer stageLevelId, Pagination pagination) {
        return apiStageSongDao.getByStyleId(stageLevelId, pagination);
    }

    public StageSong getStageSongBySongId(Integer songId) {
        StageSongCriteria criteria = new StageSongCriteria();
        criteria.createCriteria().andSongIdEqualTo(songId);
        List<StageSong> songs = stageSongMapper.selectByExample(criteria);
        return songs.isEmpty() ? null : songs.get(0);
    }
}
