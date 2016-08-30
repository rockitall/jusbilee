/**
 * zhandc 2016年8月7日
 */
package com.jusbilee.app.admin.dao;

import com.jusbilee.app.admin.dao.sql.AppUserAdminDaoProvider;
import com.jusbilee.app.admin.domain.AppUserCriteria;
import com.jusbilee.app.api.user.account.domain.AppUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author zhandc 2016年8月7日
 */

@Mapper
public interface AppUserAdminDao {

    @SelectProvider(type = AppUserAdminDaoProvider.class, method = "statisticsList")
    List<AppUser> statisticsList(AppUserCriteria criteria);

    @SelectProvider(type = AppUserAdminDaoProvider.class, method = "statisticsCount")
    int statisticsCount(AppUserCriteria criteria);
}
