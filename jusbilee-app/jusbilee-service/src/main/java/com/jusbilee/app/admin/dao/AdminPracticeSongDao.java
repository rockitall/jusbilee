/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.admin.dao;

import com.jusbilee.app.admin.criteria.AdminPracticeSongCriteria;
import com.jusbilee.app.admin.dao.sql.AdminPracticeSongDaoSqlProvider;
import com.jusbilee.app.admin.domain.AdminPracticeSongListItem;
import com.rockit.core.pojo.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author zhandc 2016年8月28日
 */

@Mapper
public interface AdminPracticeSongDao {

    @SelectProvider(type = AdminPracticeSongDaoSqlProvider.class, method = "querySql")
    List<AdminPracticeSongListItem> query(@Param("c") AdminPracticeSongCriteria criteria, Pagination pagination);

    @SelectProvider(type = AdminPracticeSongDaoSqlProvider.class, method = "countSql")
    long count(@Param("c") AdminPracticeSongCriteria criteria);
}
