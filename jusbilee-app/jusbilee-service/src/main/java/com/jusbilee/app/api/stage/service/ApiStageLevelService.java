package com.jusbilee.app.api.stage.service;

import com.jusbilee.app.api.stage.dao.ApiStageLevelDao;
import com.jusbilee.app.api.stage.dao.ApiStageSongDao;
import com.jusbilee.app.api.stage.domain.ApiLevelStageSongCount;
import com.jusbilee.app.api.stage.domain.ApiSongLevel;
import com.rockit.core.utils.IdentityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2016/8/23.
 */
@Service
public class ApiStageLevelService {
    @Autowired
    private ApiStageLevelDao apiStageLevelDao;

    @Autowired
    private ApiStageSongDao apiStageSongDao;


    public List<ApiSongLevel> getAllSongLevel() {
        return apiStageLevelDao.getAllSongLevel();
    }

    public Map<Integer, ApiLevelStageSongCount> getAllLevelStageSongCountAsMap() {
        List<ApiLevelStageSongCount> counts = apiStageSongDao.getAllLevelStageSongCount();
        return IdentityUtils.asMap(counts, v -> v.getLevelId());
    }

}
