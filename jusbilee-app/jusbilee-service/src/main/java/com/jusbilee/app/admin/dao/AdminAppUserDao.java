/**
 * zhandc 2016年8月7日
 */
package com.jusbilee.app.admin.dao;

import com.jusbilee.app.admin.criteria.AdminAppUserCriteria;
import com.jusbilee.app.admin.dao.sql.AdminAppUserDaoProvider;
import com.jusbilee.app.api.user.account.domain.AppUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author zhandc 2016年8月7日
 */

@Mapper
public interface AdminAppUserDao {

    @SelectProvider(type = AdminAppUserDaoProvider.class, method = "statisticsList")
    List<AppUser> statisticsList(AdminAppUserCriteria criteria);

    @SelectProvider(type = AdminAppUserDaoProvider.class, method = "statisticsCount")
    int statisticsCount(AdminAppUserCriteria criteria);
}
