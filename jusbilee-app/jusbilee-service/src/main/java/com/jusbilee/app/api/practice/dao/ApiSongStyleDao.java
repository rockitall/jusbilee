package com.jusbilee.app.api.practice.dao;

import com.jusbilee.app.api.practice.dao.sql.ApiSongStyleDaoSqlProvider;
import com.jusbilee.app.api.practice.domain.ApiSongStyle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Allen on 2016/9/10.
 */
@Mapper
public interface ApiSongStyleDao {
    @Select(ApiSongStyleDaoSqlProvider.ALL_STYLE_SQL)
    List<ApiSongStyle> getAllSongStyle();
}
