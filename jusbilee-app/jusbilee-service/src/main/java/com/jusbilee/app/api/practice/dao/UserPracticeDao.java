/**
 * zhandc 2016年8月31日
 */
package com.jusbilee.app.api.practice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.jusbilee.app.api.practice.dao.sql.UserPracticeDaoSqlProvider;
import com.jusbilee.app.api.practice.domain.PracticeSongStyle;
import com.jusbilee.app.api.practice.domain.UserPracticeActLogDomain;
import com.jusbilee.app.api.practice.domain.UserPracticeSong;
import com.rockit.core.pojo.Pagination;

/**
 * @author zhandc 2016年8月31日
 *
 */

@Mapper
public interface UserPracticeDao {
	
	/*@Select("select p.total_practice_time as totalPracticeTime, p.total_practice_count as totalPracticeCount, "
			+ "p.total_practice_score as totalPracticeScore, p.best_avg_score as bestAvgScore, p.full_score_best_time"
			+ " as fullScoreBestTime, s.name as songName from t_user_practice_act_log p LEFT JOIN t_practice_song ps ON p.practice_song_id = ps.id "
			+ " LEFT JOIN t_song s on ps.song_id = s.id where p.user_id = #{userId} and p.style_id = #{styleId}")*/
	
	@SelectProvider(type = UserPracticeDaoSqlProvider.class, method = "getUserPracticeList")
	List<UserPracticeActLogDomain> getUserPracticeList(@Param("userId") Long userId, @Param("styleId") Integer styleId,Pagination pagination);
	
	/*@Select("select ps.id as practiceSongId, ps.unlock_gold_coin as lockGoldCoin, s.name as songName, s.description as description, "
			+ " s.icon_url as iconUrl, s.opern_screenshot_url as opern_screenshot_url, s.opern_url as opernUrl, "
			+ " s.wav_play_url as wavPlayUrl, s.midi_play_url as midiPlayUrl,pu.is_need_lock as isNeedLock, "
			+ " pa.total_practice_count as totalPracticeCount, pa.total_practice_score as totalPracticeScore,"
			+ " pa.best_avg_score as bestAvgScore from t_practice_song ps "
			+ " left join t_song s on ps.song_id = s.id"
			+ " left join t_user_practice_unlock_log pu on ps.id=pu.practice_song_id and pu.user_id = #{userId} "
			+ " left join t_user_practice_act_log pa on ps.id=pa.practice_song_id and pa.user_id = #{userId} "
			+ " where ps.status=0 and ps.style_id = #{styleId}")*/
	
	@SelectProvider(type = UserPracticeDaoSqlProvider.class, method = "getUserStageSongList")
	List<UserPracticeSong> getUserStageSongList(@Param("userId") Long userId, @Param("styleId") Integer styleId,Pagination pagination);
	
	@Select("select p.style_id as styleId, s.name as styleName from t_practice_song p LEFT JOIN t_song_style s"
			+ " on p.style_id = s.id GROUP BY styleId")
	List<PracticeSongStyle> getSongStyle();
	
	
}
