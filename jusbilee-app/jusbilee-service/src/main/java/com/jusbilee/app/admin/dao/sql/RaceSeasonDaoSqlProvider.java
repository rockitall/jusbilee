package com.jusbilee.app.admin.dao.sql;

import com.jusbilee.app.admin.criteria.RaceSeasonQueryCriteria;
import com.rockit.core.pojo.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Allen on 2016/9/15.
 */
public class RaceSeasonDaoSqlProvider {

    public String querySql(@Param("c") RaceSeasonQueryCriteria criteria, Pagination pagination) {
        SQL sql = new SQL();
        sql.SELECT("t0.id as id");
        sql.SELECT("t0.season_name as seasonName");
        sql.SELECT("t0.start_time as startTime");
        sql.SELECT("t0.end_time as endTime");
        sql.SELECT("case when t1.songCount is null then 0 else t1.songCount end as songCount");
        sql.SELECT("t0.create_time as createTime");
        sql.SELECT("t0.update_time as updateTime");
        sql.FROM("t_race_season t0");
        sql.LEFT_OUTER_JOIN("(select season_id, count(1) as songCount from t_race_season_song where is_deleted=0 group by season_id) t1 on t0.id=t1.season_id");
        whereClause(sql, criteria);
        sql.ORDER_BY("t0.start_time asc");

        StringBuilder buf = new StringBuilder(128);
        sql.usingAppender(buf);
        buf.append(" limit ").append(pagination.getOffset()).append(',').append(pagination.getLimit());
        return buf.toString();
    }

    public String countSql(@Param("c") RaceSeasonQueryCriteria criteria) {
        SQL sql = new SQL();
        sql.SELECT("count(1)");
        sql.FROM("t_race_season t0");
        whereClause(sql, criteria);
        return sql.toString();
    }

    private void whereClause(SQL sql, RaceSeasonQueryCriteria criteria) {
        sql.WHERE("t0.is_deleted=0");
        if (StringUtils.isNoneBlank(criteria.getSeasonName())) {
            sql.AND().WHERE("t0.season_name like concat('%',#{c.seasonName},'%')");
        }
    }
}
