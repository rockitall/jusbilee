package com.jusbilee.app.user.dao;

import com.jusbilee.app.user.param.ThirdUserCredentials;
import com.jusbilee.app.user.param.UserRegistration;
import com.jusbilee.app.user.pojo.AppUser;
import com.jusbilee.app.user.pojo.Passport;
import com.jusbilee.app.user.pojo.UserBind;
import com.jusbilee.app.user.pojo.WeixinUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

/**
 * Created by Allen on 2016/7/16.
 */

@Mapper
public interface AppUserDao {
    @Select("select user_id as userId, username, password, salt from t_passport where username=#{username}")
    Passport getAppUserPassportByUsername(@Param("username") String username);

    @Update("update t_passport set password=#{password},salt=#{salt} where user_id=#{userId}")
    void updateUserPassport(Passport passport);

    @Insert("insert into t_app_user(nickname,create_time) values (#{nickname},now())")
    @SelectKey(before = false, keyProperty = "userId", keyColumn = "id", resultType = Long.class, statementType = StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID()")
    void createAppUserForRegistration(UserRegistration registration);

    @Insert("insert into t_passport (user_id, username, password, salt, create_time) values (#{userId}, #{username}, #{password}, #{salt}, now())")
    void createAppUserPassport(Passport passport);

    @Insert("insert into t_user_bind (user_id, third_user_type, third_user_identify, third_login_type, create_time) values (#{userId}, #{thirdUserType}, #{thirdUserIdentify}, #{thirdLoginType}, now())")
    @SelectKey(before = false, keyProperty = "id", keyColumn = "id", resultType = Long.class, statementType = StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID()")
    void createUserBind(UserBind bind);

    @Select("select id, user_id, third_user_type, third_user_identify, third_login_type from t_user_bind where user_id=#{userId} and third_login_type =#{userTypeName}")
    UserBind getUserBind(ThirdUserCredentials credentials);
}
