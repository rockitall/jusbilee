package com.jusbilee.app.api.practice.dao;

import com.jusbilee.app.api.practice.dao.sql.ApiPracticeSongDaoSqlProvider;
import com.jusbilee.app.api.practice.domain.ApiPracticeSong;
import com.jusbilee.app.api.practice.domain.ApiSongExt;
import com.jusbilee.app.api.practice.param.ApiPracticeSongCriteria;
import com.rockit.core.pojo.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by Allen on 2016/9/10.
 */
@Mapper
public interface ApiPracticeSongDao {
    @Select(ApiPracticeSongDaoSqlProvider.STYLE_ONLINE_PRACTICE_SONG_SQL)
    List<ApiPracticeSong> getStyleOnlinePracticeSongList(@Param("styleId") Integer styleId, @Param("p") Pagination pagination);

    @SelectProvider(type = ApiPracticeSongDaoSqlProvider.class, method = "queryPracticeSongSql")
    List<ApiSongExt> queryPracticeSong(@Param("c") ApiPracticeSongCriteria criteria, Pagination pagination);
}
