package com.jusbilee.app.api.stage.dao;

import com.jusbilee.app.api.stage.domain.ApiSongLevel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Allen on 2016/8/24.
 */
@Mapper
public interface ApiStageLevelDao {
    @Select("select id as levelId,name as levelName from t_song_level where is_deleted=0 order by weight asc,id asc")
    List<ApiSongLevel> getAllSongLevel();
}
