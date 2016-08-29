package com.jusbilee.app.api.user.account.dao;

import com.jusbilee.app.api.user.account.domain.ThirdUserBind;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

/**
 * Created by Allen on 2016/7/16.
 */

@Mapper
public interface ThirdUserBindDao {
    @Insert("insert into t_third_user_bind (user_id, user_type, openid, create_time) values (#{userId}, #{userType}, #{openid}, now())")
    @SelectKey(before = false, keyProperty = "bindId", keyColumn = "id", resultType = Long.class, statementType = StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID()")
    void insert(ThirdUserBind thirdUserBind);

    @Select("select id, user_id, user_type, openid from t_third_user_bind where user_type=#{userType} and openid=#{openid} and status=1")
    ThirdUserBind selectByOpenid(@Param("openid") String openid, @Param("userType") String userType);
}
