package com.jusbilee.app.api.song.dao;

import com.jusbilee.app.api.song.dao.sql.ApiSongDaoSqlProvider;
import com.jusbilee.app.api.song.domain.ApiSong;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by Allen on 2016/9/10.
 */
@Mapper
public interface ApiSongDao {
    @SelectProvider(type = ApiSongDaoSqlProvider.class, method = "getSongListByIdListSql")
    List<ApiSong> getSongListByIdList(@Param("idList") List<Integer> songIdList);
}
