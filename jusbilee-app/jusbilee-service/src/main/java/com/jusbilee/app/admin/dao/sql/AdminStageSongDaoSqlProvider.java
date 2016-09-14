/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.admin.dao.sql;

import com.jusbilee.app.admin.criteria.AdminStageSongQueryCriteria;
import com.rockit.core.pojo.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author zhandc 2016年8月28日
 */
public class AdminStageSongDaoSqlProvider {

    public String querySql(@Param("c") AdminStageSongQueryCriteria criteria, Pagination pagination) {
        SQL sql = new SQL();
        sql.SELECT("t0.id");
        sql.SELECT("t1.id as songId");
        sql.SELECT("t1.name");
        sql.SELECT("t2.id as levelId");
        sql.SELECT("t2.name as levelName");
        sql.SELECT("t0.status");
        sql.SELECT("t0.pass_score as passScore");
        sql.SELECT("t0.sort_order as sortOrder");
        sql.SELECT("t0.start_time as startTime");
        sql.SELECT("t0.end_time as endTime");
        sql.SELECT("t0.create_time as createTime");
        sql.SELECT("t0.update_time as updateTime");
        sql.FROM("t_stage_song t0");
        sql.LEFT_OUTER_JOIN("t_song as t1        on t0.song_id=t1.id");
        sql.LEFT_OUTER_JOIN("t_song_level as t2 on t0.level_id=t2.id");

        //where
        whereClause(sql, criteria);

        //order by
        sql.ORDER_BY("t2.weight asc,t0.sort_order asc, t0.create_time desc,t0.id asc");

        //limit
        StringBuilder buf = new StringBuilder(128);
        sql.usingAppender(buf);
        buf.append(" limit ").append(pagination.getOffset()).append(",").append(pagination.getLimit());

        return buf.toString();
    }

    public String countSql(@Param("c") AdminStageSongQueryCriteria criteria) {
        SQL sql = new SQL();
        sql.SELECT("count(1)");
        sql.FROM("t_stage_song t0");
        if (StringUtils.isNotBlank(criteria.getName())) {
            sql.LEFT_OUTER_JOIN("t_song as t1        on t0.song_id=t1.id");
        }
        if (criteria.getLevelId() != null) {
            sql.LEFT_OUTER_JOIN("t_song_level as t2 on t0.level_id=t2.id");
        }
        //where
        whereClause(sql, criteria);

        return sql.toString();
    }


    private void whereClause(SQL sql, AdminStageSongQueryCriteria criteria) {
        if (criteria.getOnline() != null) {
            if (criteria.getOnline()) {
                sql.WHERE("t0.status = 0");
            } else {
                sql.WHERE("t0.status = 2");
            }
        } else {
            sql.WHERE("t0.status <> 1");
        }
        if (StringUtils.isNotBlank(criteria.getName())) {
            sql.AND().WHERE("t1.name like concat('%',#{c.name},'%')");
        }

        if (StringUtils.isNotBlank(criteria.getOnlineStartTime())) {
            sql.AND().WHERE("t0.start_time <= str_to_date(#{c.onlineStartTime},'%Y/%m/%d')");
        }
        if (StringUtils.isNotBlank(criteria.getOnlineEndTime())) {
            sql.AND().WHERE("t0.end_time >= str_to_date(#{c.onlineEndTime},'%Y/%m/%d')");
        }
        if (criteria.getPassScoreStart() != null) {
            sql.AND().WHERE("t0.pass_score >= #{c.passScoreStart}");
        }
        if (criteria.getPassScoreEnd() != null) {
            sql.AND().WHERE("t0.pass_score <= #{c.passScoreEnd}");
        }
        if (criteria.getLevelId() != null) {
            sql.AND().WHERE("t0.level_id = #{c.levelId}");
        }
        if (criteria.getSortOrder() != null) {
            sql.AND().WHERE("t0.sort_order = #{c.sortOrder}");
        }
    }
}
