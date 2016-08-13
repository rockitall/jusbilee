package com.jusbilee.app.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.jusbilee.app.admin.dao.sql.SysUserDaoSqlProvider;
import com.jusbilee.app.admin.domain.SysUser;
import com.jusbilee.app.admin.domain.SysUserCriteria;

/**
 * Created by Allen on 2016/8/2. 1.0.1 添加增伤查改方法 by zhandc
 * 
 */
@Mapper
public interface SysUserDao {

	@Select("select username,nickname,password,mobile,phone,email,address,qq,is_locked as isLocked from t_sys_user where username=#{username}")
	SysUser selectByUsername(@Param("username") String username);

	@InsertProvider(type = SysUserDaoSqlProvider.class, method = "insertAdmin")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", resultType = Long.class, before = false)
	void insert(SysUser sysUser);

	@Select("select username, nickname, mobile, phone, email, address, qq,is_locked as isLocked  from  t_sys_user where id = #{userId}")
	SysUser selectById(@Param("userId") Long userId);

	@Update("update t_sys_user set username=#{username}, nickname=#{nickname}, mobile=#{mobile}, phone=#{phone}, email=#{email}, qq=#{qq}, update_time = now() where user_id=#{userId}")
	void updateSysUser(SysUser sysUser);

	@Update("update t_sys_user set is_locked=#{isLocked} where id=#{userId}")
	void updateIslocked(@Param("userId") long userId, @Param("isLocked") Byte isLocked);

	@Update("update t_sys_user set status =#{status} where id=#{userId}")
	void deleteSysUser(@Param("userId") long userId, @Param("status") Byte status);
	
	@SelectProvider(type = SysUserDaoSqlProvider.class, method = "queryList")
	List<SysUser> queryList(SysUserCriteria criteria);
	
	@SelectProvider(type = SysUserDaoSqlProvider.class, method = "count")
	int count(SysUserCriteria criteria);

}
