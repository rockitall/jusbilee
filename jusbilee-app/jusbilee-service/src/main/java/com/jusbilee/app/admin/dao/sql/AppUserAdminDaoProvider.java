/**
 * zhandc 2016年8月7日
 */
package com.jusbilee.app.admin.dao.sql;

import com.jusbilee.app.admin.domain.AppUserCriteria;

/**
 * @author zhandc 2016年8月7日
 *
 */
public class AppUserAdminDaoProvider {

	public String statisticsCount(AppUserCriteria criteria) {
		StringBuilder sb = new StringBuilder(512);
		sb.append("select count(1) from t_app_user where status = '0' ");
		if ("d".equals(criteria.getCycleType())) {
			sb.append(" and create_time >= CONCAT(#{date}, ' 00:00:00')");
			sb.append(" and create_time <= CONCAT(#{date}, ' 23:59:59')");
		}
		
		if("w".equals(criteria.getCycleType())) {
			sb.append(" and create_time >= CONCAT(#{startDate}, ' 00:00:00')");
			sb.append(" and create_time <= CONCAT(#{endDate}, ' 23:59:59')");
		}
		
		return sb.toString();
	}
	
	public String statisticsList(AppUserCriteria criteria) {
		StringBuilder sb = new StringBuilder(512);
		sb.append("select id, nickname, sex  from t_app_user where status = '0' ");
		if ("d".equals(criteria.getCycleType())) {
			sb.append(" and create_time >= CONCAT(#{date}, ' 00:00:00')");
			sb.append(" and create_time <= CONCAT(#{date}, ' 23:59:59')");
		}
		
		if("w".equals(criteria.getCycleType())) {
			sb.append(" and create_time >= CONCAT(#{startDate}, ' 00:00:00')");
			sb.append(" and create_time <= CONCAT(#{endDate}, ' 23:59:59')");
		}
		
		sb.append("order by nickname");
		
		return sb.toString();
	}

}

