package com.jusbilee.app.admin.dao;

import com.jusbilee.app.admin.criteria.AdminSongSubLevelQueryCriteria;
import com.jusbilee.app.admin.dao.sql.SongSubLevelDaoSqlProvider;
import com.jusbilee.app.admin.domain.AdminSongSubLevelListItem;
import com.rockit.core.pojo.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by Allen on 2016/9/15.
 */
@Mapper
public interface SongSubLevelDao {
    @SelectProvider(type = SongSubLevelDaoSqlProvider.class, method = "countSql")
    long count(@Param("c") AdminSongSubLevelQueryCriteria criteria);

    @SelectProvider(type = SongSubLevelDaoSqlProvider.class, method = "querySql")
    List<AdminSongSubLevelListItem> query(@Param("c") AdminSongSubLevelQueryCriteria criteria, Pagination pagination);
}
