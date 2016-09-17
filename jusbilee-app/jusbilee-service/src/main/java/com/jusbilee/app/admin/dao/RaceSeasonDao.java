package com.jusbilee.app.admin.dao;

import com.jusbilee.app.admin.criteria.RaceSeasonQueryCriteria;
import com.jusbilee.app.admin.dao.sql.RaceSeasonDaoSqlProvider;
import com.jusbilee.app.admin.domain.AdminRaceSeasonListItem;
import com.rockit.core.pojo.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by Allen on 2016/9/15.
 */
@Mapper
public interface RaceSeasonDao {
    @SelectProvider(type = RaceSeasonDaoSqlProvider.class, method = "querySql")
    List<AdminRaceSeasonListItem> query(@Param("c") RaceSeasonQueryCriteria criteria, Pagination pagination);

    @SelectProvider(type = RaceSeasonDaoSqlProvider.class, method = "countSql")
    long count(@Param("c") RaceSeasonQueryCriteria criteria);
}
