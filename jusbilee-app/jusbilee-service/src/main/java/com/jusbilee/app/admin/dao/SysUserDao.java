package com.jusbilee.app.admin.dao;

import com.jusbilee.app.admin.dao.sql.SysUserDaoSqlProvider;
import com.jusbilee.app.admin.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * Created by Allen on 2016/8/2.
 */
@Mapper
public interface SysUserDao {
    @Select("select username,nickname,password,mobile,phone,email,address,qq,is_locked as isLocked from t_sys_user where username=#{username}")
    SysUser selectByUsername(@Param("username") String username);

    @SelectProvider(type = SysUserDaoSqlProvider.class, method = "selectByCriteria")
    SysUser selectByCriteria(SysUser user);
}
