/**
 * zhandc 2016年8月31日
 */
package com.jusbilee.app.api.practice.dao;

import com.jusbilee.app.api.practice.dao.sql.ApiUserPracticeDaoSqlProvider;
import com.jusbilee.app.api.practice.domain.ApiUserPracticeSummary;
import com.rockit.core.pojo.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface ApiUserPracticeSummaryDao {
    @SelectProvider(type = ApiUserPracticeDaoSqlProvider.class, method = "getBySongIdListSql")
    List<ApiUserPracticeSummary> getBySongIdList(@Param("userId") Long userId, List<Integer> songIdList);

    @SelectProvider(type = ApiUserPracticeDaoSqlProvider.class, method = "getByStyleIdSql")
    List<ApiUserPracticeSummary> getByStyleId(@Param("userId") Long userId, @Param("styleId") Integer styleId, Pagination pagination);
}
