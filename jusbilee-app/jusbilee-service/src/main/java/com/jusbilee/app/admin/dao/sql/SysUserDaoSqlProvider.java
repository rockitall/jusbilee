package com.jusbilee.app.admin.dao.sql;

import org.apache.ibatis.jdbc.SQL;

import com.jusbilee.app.admin.domain.SysUser;
import com.jusbilee.app.admin.domain.SysUserCriteria;

/**
 * Created by zhandc on 2016/8/5.
 */
public class SysUserDaoSqlProvider {

	public String insertAdmin(SysUser sysUser) {
		// todo
		// 密码格式还没确定
		return new SQL() {
			{
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
			}
		}.toString();
	}

	public String count(SysUserCriteria criteria) {
		StringBuilder sb = new StringBuilder(512);
		sb.append("select count(1) from t_sys_user where status = '0' ");
		if (criteria.getUserName() != null && !("".equals(criteria.getUserName()))) {
			sb.append(" and instr(username, #{userName}) >0");
		}
		return sb.toString();
		/*return new SQL() {
			{
				SELECT("count(1)");
				FROM("t_sys_user t");
				WHERE("t.status = '0'");
				if (criteria.getUserName() != null && !("".equals(criteria.getUserName()))) {
					AND().WHERE("INSTR(username,'#{userName}') >0");
				}

			}
		}.toString();*/
	}
	
	public String queryList(SysUserCriteria criteria) {
		StringBuilder sb = new StringBuilder(512);
		sb.append("SELECT username, nickname, mobile, phone, email, address, qq ");
		sb.append("FROM t_sys_user ");
		sb.append("WHERE status = 0 ");
		if(criteria.getUserName() != null && !("".equals(criteria.getUserName()))){
			sb.append("and INSTR(username, #{userName}) >0 ") ;
		}
		sb.append("order by username ");
		sb.append("limit #{rp} offset #{offset}");
		return sb.toString();
	}

}
