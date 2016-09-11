package com.jusbilee.app.api.practice.dao;

import com.jusbilee.app.api.practice.dao.sql.ApiPracticeSongDaoSqlProvider;
import com.jusbilee.app.api.practice.domain.ApiPracticeSong;
import com.rockit.core.pojo.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Allen on 2016/9/10.
 */
@Mapper
public interface ApiPracticeSongDao {
    @Select(ApiPracticeSongDaoSqlProvider.STYLE_ONLINE_PRACTICE_SONG_SQL)
    List<ApiPracticeSong> getStyleOnlinePracticeSongList(@Param("styleId") Integer styleId, @Param("p") Pagination pagination);
}
