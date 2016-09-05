package com.jusbilee.app.admin.dao.sql;

import com.jusbilee.app.admin.criteria.AdminUserQueryCriteria;
import com.rockit.core.pojo.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by zhandc on 2016/8/5.
 */
public class AdminUserDaoSqlProvider {

    public String querySql(@Param("c") AdminUserQueryCriteria criteria, Pagination pagination) {
        SQL sql = new SQL();
        sql.SELECT("t0.id");
        sql.SELECT("t0.username");
        sql.SELECT("t0.nickname");
        sql.SELECT("t0.mobile");
        sql.SELECT("t0.email");
        sql.SELECT("t0.is_locked as isLocked");
        sql.SELECT("t0.is_admin  as isAdmin");
        sql.SELECT("t0.create_time as createTime");
        sql.SELECT("t0.update_time as updateTime");
        sql.FROM("t_admin_user t0");

        //where
        whereClause(sql, criteria);

        //order by
        sql.ORDER_BY("t0.create_time desc, t0.id asc");

        //limit
        StringBuilder buf = new StringBuilder(128);
        sql.usingAppender(buf);
        buf.append(" limit ").append(pagination.getOffset()).append(",").append(pagination.getLimit());

        return buf.toString();
    }

    public String countSql(@Param("c") AdminUserQueryCriteria criteria) {
        SQL sql = new SQL();
        sql.SELECT("count(1)");
        sql.FROM("t_admin_user t0");
        whereClause(sql, criteria);
        return sql.toString();
    }


    private void whereClause(SQL sql, AdminUserQueryCriteria criteria) {
        sql.WHERE("t0.is_deleted=0");
        if (StringUtils.isNotBlank(criteria.getUsername())) {
            sql.AND().WHERE("t0.username like concat('%',#{c.username},'%')");
        }
        if (StringUtils.isNotBlank(criteria.getNickname())) {
            sql.AND().WHERE("t0.nickname like concat('%',#{c.nickname},'%')");
        }
        if (criteria.getIsLocked() != null) {
            sql.AND().WHERE("t0.is_locked=#{c.isLocked}");
        }
    }
}
