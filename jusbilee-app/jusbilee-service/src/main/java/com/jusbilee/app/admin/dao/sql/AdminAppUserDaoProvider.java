/**
 * zhandc 2016年8月7日
 */
package com.jusbilee.app.admin.dao.sql;

import com.jusbilee.app.admin.criteria.AdminAppUserCriteria;

/**
 * @author zhandc 2016年8月7日
 */
public class AdminAppUserDaoProvider {

    public String statisticsCount(AdminAppUserCriteria criteria) {
        StringBuilder sb = new StringBuilder(512);
        sb.append("select count(1) from t_app_user where status = '0' ");
        if ("d".equals(criteria.getCycleType())) {
            sb.append(" and create_time >= CONCAT(#{date}, ' 00:00:00')");
            sb.append(" and create_time <= CONCAT(#{date}, ' 23:59:59')");
        }

        if ("w".equals(criteria.getCycleType())) {
            sb.append(" and create_time >= CONCAT(#{startDate}, ' 00:00:00')");
            sb.append(" and create_time <= CONCAT(#{endDate}, ' 23:59:59')");
        }

        return sb.toString();
    }

    public String statisticsList(AdminAppUserCriteria criteria) {
        StringBuilder sb = new StringBuilder(512);
        sb.append("select id, nickname, sex  from t_app_user where status = '0' ");
        if ("d".equals(criteria.getCycleType())) {
            sb.append(" and create_time >= CONCAT(#{date}, ' 00:00:00')");
            sb.append(" and create_time <= CONCAT(#{date}, ' 23:59:59')");
        }

        if ("w".equals(criteria.getCycleType())) {
            sb.append(" and create_time >= CONCAT(#{startDate}, ' 00:00:00')");
            sb.append(" and create_time <= CONCAT(#{endDate}, ' 23:59:59')");
        }

        sb.append("order by nickname");
        sb.append("limit #{rp} offset #{offset}");
        return sb.toString();
    }

}

