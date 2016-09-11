package com.jusbilee.app.api.practice.dao.sql;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Allen on 2016/9/10.
 */
@Mapper
public class ApiPracticeSongDaoSqlProvider {
    public static final String STYLE_ONLINE_PRACTICE_SONG_SQL = "select"
            + " id as practiceSongId,"
            + " style_id as styleId,"
            + " song_id as songId,"
            + " unlock_gold_coin as unlockGoldCoin,"
            + " pass_stage_unlock as passStageUnlock "
            + " from t_practice_song"
            + " where status=0 and"
            + " current_timestamp between start_time and end_time and"
            + " style_id=#{styleId}"
            + " order by create_time desc,id asc"
            + " limit ${p.offset},${p.limit}";
}
