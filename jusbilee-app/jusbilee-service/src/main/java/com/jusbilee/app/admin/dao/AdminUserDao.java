package com.jusbilee.app.admin.dao;

import com.jusbilee.app.admin.criteria.AdminUserQueryCriteria;
import com.jusbilee.app.admin.dao.sql.AdminUserDaoSqlProvider;
import com.jusbilee.app.admin.domain.AdminUserListItem;
import com.rockit.core.pojo.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface AdminUserDao {
    @SelectProvider(type = AdminUserDaoSqlProvider.class, method = "querySql")
    List<AdminUserListItem> query(@Param("c") AdminUserQueryCriteria criteria, Pagination pagination);

    @SelectProvider(type = AdminUserDaoSqlProvider.class, method = "countSql")
    long count(@Param("c") AdminUserQueryCriteria criteria);
}
