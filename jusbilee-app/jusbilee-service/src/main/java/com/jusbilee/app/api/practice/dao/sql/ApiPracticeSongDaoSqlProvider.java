package com.jusbilee.app.api.practice.dao.sql;

import com.jusbilee.app.api.practice.param.ApiPracticeSongCriteria;
import com.rockit.core.pojo.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

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

    public String queryPracticeSongSql(@Param("c") ApiPracticeSongCriteria criteria, Pagination pagination) {
        SQL sql = new SQL();
        sql.SELECT("t0.id as songId");
        sql.SELECT("t0.name as songName");
        sql.SELECT("t0.description as description");
        sql.SELECT("t0.style_id as styleId");
        sql.SELECT("t0.icon_url as iconUrl");
        sql.SELECT("t0.wav_play_url as wavPlayUrl");
        sql.SELECT("t0.midi_play_url as midiPlayUrl");
        sql.SELECT("t1.pass_stage_unlock as passStageUnlock");
        sql.SELECT("t1.unlock_gold_coin as unlockGoldCoin");
        sql.FROM("t_song t0");
        sql.LEFT_OUTER_JOIN("t_practice_song t1 on t0.id = t1.song_id and t1.status=0");
        sql.WHERE("t0.is_deleted=0");
        if (criteria.getStyleId() != null) {
            sql.WHERE("t0.style_id=#{c.styleId}");
        }
        sql.WHERE("now() between t1.start_time and t1.end_time");
        sql.WHERE("t0.name like concat('%',#{c.keyword},'%')");
        StringBuilder buf = new StringBuilder(128);
        sql.usingAppender(buf);
        buf.append(" limit ").append(pagination.getOffset()).append(',').append(pagination.getLimit());

        return buf.toString();
    }
}
