package com.jusbilee.app.admin.dao;

import com.jusbilee.app.admin.criteria.RaceSeasonSongQueryCriteria;
import com.jusbilee.app.admin.criteria.RaceSeasonSongSelectQueryCriteria;
import com.jusbilee.app.admin.dao.sql.RaceSeasonSongDaoSqlProvider;
import com.jusbilee.app.admin.domain.AdminRaceSeasonSongListItem;
import com.jusbilee.app.admin.domain.AdminRaceSeasonSongSelectListItem;
import com.rockit.core.pojo.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by Allen on 2016/9/16.
 */
@Mapper
public interface RaceSeasonSongDao {
    @SelectProvider(type = RaceSeasonSongDaoSqlProvider.class, method = "querySql")
    List<AdminRaceSeasonSongListItem> query(@Param("c") RaceSeasonSongQueryCriteria criteria, Pagination pagination);

    @SelectProvider(type = RaceSeasonSongDaoSqlProvider.class, method = "countSql")
    long count(@Param("c") RaceSeasonSongQueryCriteria criteria);

    @SelectProvider(type = RaceSeasonSongDaoSqlProvider.class, method = "countSelectSql")
    long countSelect(@Param("c") RaceSeasonSongSelectQueryCriteria criteria);

    @SelectProvider(type = RaceSeasonSongDaoSqlProvider.class, method = "querySelectSql")
    List<AdminRaceSeasonSongSelectListItem> querySelect(@Param("c") RaceSeasonSongSelectQueryCriteria criteria, Pagination pagination);
}
