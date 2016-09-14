package com.jusbilee.app.admin.dao.sql;

import com.jusbilee.app.admin.criteria.AdminSongQueryCriteria;
import com.rockit.core.pojo.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Allen on 2016/9/3.
 */
public class AdminSongDaoSqlProvider {
    public String querySql(@Param("c") AdminSongQueryCriteria criteria, Pagination pagination) {
        SQL sql = new SQL();
        sql.SELECT("t0.id as id");
        sql.SELECT("t0.name");
        sql.SELECT("t0.description");
        sql.SELECT("t0.icon_url as iconUrl");
        sql.SELECT("t0.opern_screenshot_url as screenshotUrl");
        sql.SELECT("t0.opern_url as opernUrl");
        sql.SELECT("t0.wav_play_url as wavUrl");
        sql.SELECT("t0.midi_play_url as midiUrl");
        sql.SELECT("t1.id as practiceSongId");
        sql.SELECT("t2.id as stageSongId");
        sql.SELECT("t0.create_time as createTime");
        sql.SELECT("t0.update_time as updateTime");
        sql.SELECT("t3.id as levelId");
        sql.SELECT("t3.name as levelName");
        sql.SELECT("t4.id as styleId");
        sql.SELECT("t4.name as styleName");
        sql.FROM("t_song as t0");
        sql.LEFT_OUTER_JOIN("t_practice_song as t1 on t0.id=t1.song_id and t1.status<>1");
        sql.LEFT_OUTER_JOIN("t_stage_song    as t2 on t0.id=t2.song_id and t2.status<>1");
        sql.LEFT_OUTER_JOIN("t_song_level    as t3 on t0.level_id=t3.id");
        sql.LEFT_OUTER_JOIN("t_song_style    as t4 on t0.style_id=t4.id");

        //where
        whereClause(sql, criteria);

        //order by
        sql.ORDER_BY("t0.create_time desc");

        //limit
        StringBuilder buf = new StringBuilder(128);
        sql.usingAppender(buf);
        buf.append(" limit ").append(pagination.getOffset()).append(",").append(pagination.getLimit());

        return buf.toString();
    }

    public String countSql(@Param("c") AdminSongQueryCriteria criteria, Pagination pagination) {
        SQL sql = new SQL();
        sql.SELECT("count(1)");
        sql.FROM("t_song as t0");
        if (criteria.getPracticeModel() != null) {
            sql.LEFT_OUTER_JOIN("t_practice_song as t1 on t0.id=t1.song_id and t1.status<>1");
        }
        if (criteria.getStageModel() != null) {
            sql.LEFT_OUTER_JOIN("t_stage_song    as t2 on t0.id=t2.song_id and t2.status<>1");
        }
        whereClause(sql, criteria);
        return sql.toString();
    }

    private void whereClause(SQL sql, AdminSongQueryCriteria criteria) {
        sql.WHERE("t0.is_deleted=0");
        if (StringUtils.isNotBlank(criteria.getName())) {
            sql.AND().WHERE("t0.name like concat('%',#{c.name},'%')");
        }
        if (criteria.getPracticeModel() != null) {
            if (criteria.getPracticeModel()) {
                sql.AND().WHERE("t1.id is not null");
            } else {
                sql.AND().WHERE("t1.id is null");
            }
        }
        if (criteria.getStageModel() != null) {
            if (criteria.getStageModel()) {
                sql.AND().WHERE("t2.id is not null");
            } else {
                sql.AND().WHERE("t2.id is null");
            }
        }
        if (criteria.getLevelId() != null) {
            sql.AND().WHERE("t0.level_id=#{c.levelId}");
        }
        if (criteria.getStyleId() != null) {
            sql.AND().WHERE("t0.style_id=#{c.styleId}");
        }
        if (StringUtils.isNotBlank(criteria.getStartTime())) {
            sql.AND().WHERE("t0.create_time >= str_to_date(#{c.startTime},'%Y/%m/%d')");
        }
        if (StringUtils.isNotBlank(criteria.getEndTime())) {
            sql.AND().WHERE("t0.create_time <= str_to_date(#{c.endTime},'%Y/%m/%d')");
        }
    }
}
