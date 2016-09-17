package com.jusbilee.app.admin.dao.sql;

import com.jusbilee.app.admin.criteria.AdminSongSubLevelQueryCriteria;
import com.rockit.core.pojo.Pagination;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Allen on 2016/9/15.
 */
public class SongSubLevelDaoSqlProvider {
    public String countSql(@Param("c") AdminSongSubLevelQueryCriteria criteria) {
        SQL sql = new SQL();
        sql.SELECT("count(1)");
        sql.FROM("t_song_sub_level t0");
        whereClause(sql, criteria);
        return sql.toString();
    }

    public String querySql(@Param("c") AdminSongSubLevelQueryCriteria criteria, Pagination pagination) {
        SQL sql = new SQL();
        sql.SELECT("t0.id as id");
        sql.SELECT("t0.level_id as levelId");
        sql.SELECT("t0.sub_level_name as subLevelName");
        sql.SELECT("t1.name as levelName");
        sql.SELECT("t0.score as score");
        sql.SELECT("t0.create_time as createTime");
        sql.SELECT("t0.update_time as updateTime");
        sql.FROM("t_song_sub_level t0");
        sql.LEFT_OUTER_JOIN("t_song_level t1 on t0.level_id=t1.id");
        whereClause(sql, criteria);
        sql.ORDER_BY("t0.score asc");
        StringBuilder buf = new StringBuilder(64);
        sql.usingAppender(buf);
        buf.append(" limit ").append(pagination.getOffset()).append(',').append(pagination.getLimit());
        return buf.toString();
    }

    private void whereClause(SQL sql, AdminSongSubLevelQueryCriteria criteria) {
        sql.WHERE("t0.is_deleted=0");
        if (criteria.getLevelId() != null) {
            sql.AND().WHERE("t0.level_id=#{c.levelId}");
        }
    }
}
