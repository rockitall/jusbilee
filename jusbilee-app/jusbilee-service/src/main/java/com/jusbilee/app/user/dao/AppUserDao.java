package com.jusbilee.app.user.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.jusbilee.app.user.dao.sql.AppUserDaoSqlProvider;
import com.jusbilee.app.user.domain.AppUser;

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
    AppUser selectById(Long userId);

    @Update("update t_app_user set avatar=#{avatarUrl} where id=#{userId}")
    void updateAvatar(@Param("userId") String userId, @Param("avatarUrl") String avatarUrl);
    
    
    //新加部分，打个标识
    @Update("update t_app_user set nickname=#{nickname},description=#{description},birthday=#{birthday},province=#{province},city=#{city} where id=#{id}")
    void updateAppUser(AppUser appUser);
    
}
