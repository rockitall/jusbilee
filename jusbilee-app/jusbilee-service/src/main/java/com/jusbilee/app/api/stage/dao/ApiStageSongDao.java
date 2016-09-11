package com.jusbilee.app.api.stage.dao;

import com.jusbilee.app.api.stage.dao.sql.ApiStageSongDaoSqlProvider;
import com.jusbilee.app.api.stage.domain.ApiStageLevelSongCount;
import com.jusbilee.app.api.stage.domain.ApiStageSong;
import com.rockit.core.pojo.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Allen on 2016/8/24.
 */
@Mapper
public interface ApiStageSongDao {
    @Select(ApiStageSongDaoSqlProvider.ALL_STAGE_LEVEL_SONG_COUNT_SQL)
    List<ApiStageLevelSongCount> getAllStageLevelSongCount();

    @Select(ApiStageSongDaoSqlProvider.STAGE_LEVEL_SONG_SQL)
    List<ApiStageSong> getByStyleId(@Param("stageLevelId") Integer stageLevelId, @Param("p") Pagination pagination);
}
