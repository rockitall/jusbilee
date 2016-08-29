package com.jusbilee.app.module.stage.dao;

import com.jusbilee.app.module.stage.domain.UserStageLevel;
import com.jusbilee.app.module.stage.domain.UserStageSong;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Allen on 2016/8/24.
 */
public interface UserStageDao {
    @Select("select t0.id as stageLevelId,t0.name,t0.song_count as total, ifnull(t1.user_count, 0) as passed " +
            " from t_stage_level t0 left join (select  stage_level_id, count(1) as user_count from  " +
            "t_user_stage_act_log where is_deleted=0 and is_passed=1 and user_id =#{userId} GROUP BY stage_level_id) " +
            "t1 on t0.id=t1.stage_level_id where t0.is_deleted=0 order by weight asc, name asc")
    List<UserStageLevel> getUserStageLevelList(@Param("userId") Long userId);

    @Select("select t0.id as stageSongId, t0.song_id as songId,t2.name, t2.description, t2.icon_url as iconUrl," +
            "t2.opern_screenshot_url as opernScreenshotUrl, t2.opern_url as opernUrl, t2.wav_play_url as wavPlayUrl, " +
            "t2.midi_play_url as midiPlayUrl, t0.pass_score as passScore, ifnull(t1.is_passed, 0) as isPassed, " +
            "ifnull(t1.act_count, 0) as actCount, ifnull(t1.score, 0) as score from t_stage_song t0 left join t_user_stage_act_log t1 " +
            "on t1.is_deleted=0 and t0.id = t1.stage_song_id and t1.user_id=#{userId} left join t_song t2 on t2.is_deleted=0 and t0.song_id = t2.id  " +
            "where t0.status=0 and t0.stage_level_id = #{stageLevelId}")
    List<UserStageSong> getUserStageSongList(@Param("userId") Long userId, @Param("stageLevelId") Integer stageLevelId);
}
