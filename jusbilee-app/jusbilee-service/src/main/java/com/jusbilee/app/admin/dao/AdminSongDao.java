package com.jusbilee.app.admin.dao;

import com.jusbilee.app.admin.criteria.AdminSongQueryCriteria;
import com.jusbilee.app.admin.dao.sql.AdminSongDaoSqlProvider;
import com.jusbilee.app.admin.domain.AdminSongListItem;
import com.rockit.core.pojo.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by Allen on 2016/9/3.
 */
@Mapper
public interface AdminSongDao {
    @SelectProvider(type = AdminSongDaoSqlProvider.class, method = "querySql")
    List<AdminSongListItem> query(@Param("c") AdminSongQueryCriteria cretiria, Pagination pagination);

    @SelectProvider(type = AdminSongDaoSqlProvider.class, method = "countSql")
    long count(@Param("c") AdminSongQueryCriteria cretiria, Pagination pagination);
}
