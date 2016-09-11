/**
 * zhandc 2016年9月6日
 */
package com.jusbilee.app.api.practice.dao.sql;

import com.rockit.core.pojo.Pagination;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class ApiUserPracticeDaoSqlProvider {
    public String getBySongIdListSql(@Param("userId") Long userId, List<Integer> songIdList) {
        SQL sql = new SQL();
        sql.SELECT("user_id as userId");
        sql.SELECT("song_id as songId");
        sql.SELECT("practice_song_id as practiceSongId");
        sql.SELECT("total_practice_time as totalPracticeTime");
        sql.SELECT("total_practice_count as totalPracticeCount");
        sql.SELECT("total_practice_score as totalPracticeScore");
        sql.SELECT("best_avg_score as bestAvgScore");
        sql.SELECT("full_score_best_time as fullScoreBestTime");
        sql.FROM("t_user_practice_summary");
        sql.WHERE("user_id=#{userId}");
        StringBuilder buf = new StringBuilder(256);
        sql.usingAppender(buf);
        buf.append(" and song_id in (");
        for (Integer id : songIdList) {
            buf.append(id).append(',');
        }
        buf.setCharAt(buf.length() - 1, ')');
        return buf.toString();
    }

    public String getByStyleIdSql(@Param("userId") Long userId, @Param("styleId") Integer styleId, Pagination pagination) {
        SQL sql = new SQL();
        sql.SELECT("user_id as userId");
        sql.SELECT("song_id as songId");
        sql.SELECT("practice_song_id as practiceSongId");
        sql.SELECT("total_practice_time as totalPracticeTime");
        sql.SELECT("total_practice_count as totalPracticeCount");
        sql.SELECT("total_practice_score as totalPracticeScore");
        sql.SELECT("best_avg_score as bestAvgScore");
        sql.SELECT("full_score_best_time as fullScoreBestTime");
        sql.FROM("t_user_practice_summary");
        sql.WHERE("style_id=#{styleId}");
        sql.WHERE("total_practice_time>0");
        sql.WHERE("user_id=#{userId}");
        StringBuilder buf = new StringBuilder(256);
        sql.usingAppender(buf);
        buf.append(" order by best_avg_score desc");
        buf.append(" limit ").append(pagination.getOffset()).append(",").append(pagination.getLimit());
        return buf.toString();
    }
}
