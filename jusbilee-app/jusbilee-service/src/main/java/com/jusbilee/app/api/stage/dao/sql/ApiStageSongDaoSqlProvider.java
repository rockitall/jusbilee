package com.jusbilee.app.api.stage.dao.sql;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Allen on 2016/8/24.
 */
@Mapper
public class ApiStageSongDaoSqlProvider {
    public static final String ALL_STAGE_LEVEL_SONG_COUNT_SQL = "select "
            + " stage_level_id as levelId,"
            + " count(1) as songCount"
            + " from t_stage_song"
            + " where status=0 and"
            + " current_timestamp between start_time and end_time"
            + " group by stage_level_id";

    public static final String STAGE_LEVEL_SONG_SQL = "select"
            + " id as stageSongId,"
            + " stage_level_id as stageLevelId,"
            + " song_id as songId,"
            + " pass_score as passScore"
            + " from t_stage_song"
            + " where status=0 and"
            + " current_timestamp between start_time and end_time and"
            + " stage_level_id=${stageLevelId}"
            + " order by sort_order asc"
            + " limit ${p.offset},${p.limit}";
}
