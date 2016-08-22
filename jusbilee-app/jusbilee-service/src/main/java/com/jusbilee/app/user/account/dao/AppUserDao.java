package com.jusbilee.app.user.account.dao;

import com.jusbilee.app.user.account.dao.sql.AppUserDaoSqlProvider;
import com.jusbilee.app.user.account.domain.AppUser;
import org.apache.ibatis.annotations.*;

/**
 * Created by Allen on 2016/7/16.
 */

@Mapper
public interface AppUserDao {
    @InsertProvider(type = AppUserDaoSqlProvider.class, method = "insert")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", resultType = Long.class, before = false)
    void insert(AppUser appUser);

    @Select("select is_locked from t_app_user where id=#{userId}")
    Byte getLockStatus(@Param("userId") Long userId);

    @Select("select nickname, avatar, sex, description, province, city, birthday from t_app_user where id=#{userId}")
    AppUser selectById(@Param("userId") Long userId);

    @Select("select id from t_app_user where id=#{userId}")
    Long checkExistsById(@Param("userId") Long userId);

    @Update("update t_app_user set avatar=#{avatarUrl} where id=#{userId}")
    void updateAvatar(@Param("userId") Long userId, @Param("avatarUrl") String avatarUrl);

    @Update("update t_app_user set nickname=#{nicnkame} where id=#{userId}")
    void updateNickname(@Param("userId") Long userId, @Param("nicnkame") String nicnkame);
}
