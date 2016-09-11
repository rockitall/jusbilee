package com.jusbilee.app.api.stage.dao.sql;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * Created by Allen on 2016/8/24.
 */
public class UserStageSummaryDaoSqlProvider {
    public static final String GET_USER_STAGE_PASSED_COUNT_SQL = "select "
            + " stage_level_id as levelId,"
            + " count(1) as songCount"
            + " from t_user_stage_summary"
            + " where is_passed=1 and"
            + " user_id=#{userId}"
            + " group by stage_level_id";

    public String getUserStageSummaryListBySongIdListSql(@Param("userId") Long userId, List<Integer> songIdList) {
        SQL sql = new SQL();
        sql.SELECT("song_id as songId");
        sql.SELECT("score as score");
        sql.SELECT("is_passed as passed");
        sql.SELECT("stage_count as stageCount");
        sql.FROM("t_user_stage_summary");
        sql.WHERE("user_id =#{userId}");
        StringBuilder buf = new StringBuilder(256);
        sql.usingAppender(buf);
        buf.append(" and song_id in (");
        songIdList.stream().forEach(v -> buf.append(v).append(','));
        buf.setCharAt(buf.length() - 1, ')');
        return buf.toString();
    }
}
