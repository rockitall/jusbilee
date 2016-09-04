/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.admin.dao;

import com.jusbilee.app.admin.criteria.AdminStageSongQueryCriteria;
import com.jusbilee.app.admin.dao.sql.AdminStageSongDaoSqlProvider;
import com.jusbilee.app.admin.domain.AdminStageSongListItem;
import com.rockit.core.pojo.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface AdminStageSongDao {
    @SelectProvider(type = AdminStageSongDaoSqlProvider.class, method = "querySql")
    List<AdminStageSongListItem> query(@Param("c") AdminStageSongQueryCriteria criteria, Pagination pagination);

    @SelectProvider(type = AdminStageSongDaoSqlProvider.class, method = "countSql")
    long count(@Param("c") AdminStageSongQueryCriteria criteria);
}
