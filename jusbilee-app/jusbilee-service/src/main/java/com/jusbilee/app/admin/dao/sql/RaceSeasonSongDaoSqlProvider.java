package com.jusbilee.app.admin.dao.sql;

import com.jusbilee.app.admin.criteria.RaceSeasonSongQueryCriteria;
import com.jusbilee.app.admin.criteria.RaceSeasonSongSelectQueryCriteria;
import com.rockit.core.pojo.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Allen on 2016/9/16.
 */
public class RaceSeasonSongDaoSqlProvider {

    public String querySql(@Param("c") RaceSeasonSongQueryCriteria criteria, Pagination pagination) {
        SQL sql = new SQL();
        sql.SELECT("t0.id");
        sql.SELECT("t0.song_id as songId");
        sql.SELECT("t0.season_id as seasonId");
        sql.SELECT("t0.level_id as levelId");
        sql.SELECT("t0.create_time as createTime");
        sql.SELECT("t0.sub_level_id as subLevelId");
        sql.SELECT("t1.name as songName");
        sql.SELECT("t1.icon_url as iconUrl");
        sql.SELECT("t2.name as levelName");
        sql.SELECT("t3.sub_level_name as subLevelName");
        sql.FROM("t_race_season_song t0");
        sql.LEFT_OUTER_JOIN("t_song t1 on t0.song_id = t1.id");
        sql.LEFT_OUTER_JOIN("t_song_level t2 on t0.level_id = t2.id");
        sql.LEFT_OUTER_JOIN("t_song_sub_level t3 on t0.sub_level_id = t3.id");
        whereClause(sql, criteria);
        sql.ORDER_BY("t3.score asc, t0.id  asc");
        StringBuilder buf = new StringBuilder(128);
        sql.usingAppender(buf);
        buf.append(" limit ").append(pagination.getOffset()).append(',').append(pagination.getLimit());
        return buf.toString();
    }

    public String countSql(@Param("c") RaceSeasonSongQueryCriteria criteria) {
        SQL sql = new SQL();
        sql.SELECT("count(1)");
        sql.FROM("t_race_season_song t0");
        if (StringUtils.isNotBlank(criteria.getSongName())) {
            sql.LEFT_OUTER_JOIN("t_song t1 on t0.song_id = t1.id");
        }
        whereClause(sql, criteria);
        return sql.toString();
    }

    private void whereClause(SQL sql, RaceSeasonSongQueryCriteria criteria) {
        sql.WHERE("t0.is_deleted=0").AND().WHERE("t0.season_id=#{c.seasonId}");

        if (criteria.getLevelId() != null) {
            sql.AND().WHERE("t0.level_id=#{c.levelId}");
        }
        if (StringUtils.isNotBlank(criteria.getSongName())) {
            sql.AND().WHERE("t1.name like $('%',#{c.songName},'%')");
        }
    }


    public String countSelectSql(@Param("c") RaceSeasonSongSelectQueryCriteria criteria) {
        SQL sql = new SQL();
        sql.SELECT("count(1)");
        sql.FROM("t_song t0");
        selectWhereClause(sql, criteria);
        return sql.toString();
    }

    public String querySelectSql(@Param("c") RaceSeasonSongSelectQueryCriteria criteria, Pagination pagination) {
        SQL sql = new SQL();
        sql.SELECT("t0.id");
        sql.SELECT("t0.name as songName");
        sql.SELECT("t0.icon_url as iconUrl");
        sql.SELECT("t0.create_time as createTime");
        sql.SELECT("t0.update_time as updateTime");
        sql.SELECT("t1.name as levelName");
        sql.SELECT("t2.name as styleName");
        sql.FROM("t_song t0");
        sql.LEFT_OUTER_JOIN("t_song_level t1 on t0.level_id=t1.id");
        sql.LEFT_OUTER_JOIN("t_song_style t2 on t0.style_id=t2.id");
        selectWhereClause(sql, criteria);
        sql.ORDER_BY("t0.create_time desc");
        StringBuilder buf = new StringBuilder(128);
        sql.usingAppender(buf);
        buf.append(" limit ").append(pagination.getOffset()).append(',').append(pagination.getLimit());
        System.out.printf(buf.toString());
        return buf.toString();
    }

    private void selectWhereClause(SQL sql, RaceSeasonSongSelectQueryCriteria criteria) {
        sql.WHERE("t0.is_deleted=0");
        sql.AND().WHERE("not exists(select 1 from t_race_season_song t1 where t1.is_deleted=0 and t0.id=t1.song_id and t1.season_id=#{c.seasonId})");
        sql.AND().WHERE("t0.level_id=#{c.levelId}");
        if (StringUtils.isNotBlank(criteria.getSongName())) {
            sql.AND().WHERE("t0.name like concat('%',#{c.songName},'%')");
        }

        if (StringUtils.isNotBlank(criteria.getStartTimeBegin())) {
            sql.AND().WHERE("t0.create_time >= str_to_date(#{c.startTimeBegin},'%Y/%m/%d')");
        }
        if (StringUtils.isNotBlank(criteria.getStartTimeEnd())) {
            sql.AND().WHERE("t0.create_time <= str_to_date(#{c.startTimeEnd},'%Y/%m/%d')");
        }
    }

}
