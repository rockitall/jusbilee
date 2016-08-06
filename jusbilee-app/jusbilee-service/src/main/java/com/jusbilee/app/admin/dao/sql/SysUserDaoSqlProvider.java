package com.jusbilee.app.admin.dao.sql;

import org.apache.ibatis.jdbc.SQL;

import com.jusbilee.app.admin.domain.SysUser;

/**
 * Created by zhandc on 2016/8/5.
 */
public class SysUserDaoSqlProvider {
	
	public String insertAdmin(SysUser sysUser){
		//todo
		//密码格式还没确定
		 return new SQL() {{
	            INSERT_INTO("t_sys_user");
	            VALUES("username", "username");
	            if (sysUser.getNickname() != null) {
	                VALUES("nickname", "#{nickname}");
	            }
	            if (sysUser.getMobile() != null) {
	                VALUES("mobile", "#{mobile}");
	            }
	            if (sysUser.getPhone() != null) {
	                VALUES("phone", "#{phone}");
	            }
	            if (sysUser.getEmail() != null) {
	                VALUES("email", "#{email}");
	            }
	            if (sysUser.getAddress() != null) {
	                VALUES("address", "#{address}");
	            }
	            if (sysUser.getQq() != null) {
	                VALUES("qq", "#{qq}");
	            }
	            VALUES("create_time", "now()");
	        }}.toString();
	}
	

}
