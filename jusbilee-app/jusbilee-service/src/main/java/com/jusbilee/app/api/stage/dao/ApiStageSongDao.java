package com.jusbilee.app.api.stage.dao;

import com.jusbilee.app.api.stage.dao.sql.ApiStageSongDaoSqlProvider;
import com.jusbilee.app.api.stage.domain.ApiLevelStageSongCount;
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
    @Select(ApiStageSongDaoSqlProvider.ALL_LEVEL_STAGE_SONG_COUNT_SQL)
    List<ApiLevelStageSongCount> getAllLevelStageSongCount();

    @Select(ApiStageSongDaoSqlProvider.LEVEL_STAGE_SONG_SQL)
    List<ApiStageSong> selectByLevelId(@Param("levelId") Integer levelId, @Param("p") Pagination pagination);
}
