package com.jusbilee.app.user.account.dao;

import com.jusbilee.app.user.account.domain.Passport;
import org.apache.ibatis.annotations.*;

/**
 * Created by Allen on 2016/7/16.
 */

@Mapper
public interface PassportDao {
    @Select("select user_id as userId, username, password, salt from t_passport where username=#{username}")
    Passport selectByUsername(@Param("username") String username);

    @Update("update t_passport set password=#{password},salt=#{salt} where user_id=#{userId}")
    void updatePassword(Passport passport);

    @Insert("insert into t_passport (user_id, username, password, salt, create_time) values (#{userId}, #{username}, #{password}, #{salt}, now())")
    void insert(Passport passport);
}
