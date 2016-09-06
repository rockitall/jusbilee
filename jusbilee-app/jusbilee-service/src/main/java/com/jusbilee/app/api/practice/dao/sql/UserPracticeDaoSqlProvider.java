/**
 * zhandc 2016年9月6日
 */
package com.jusbilee.app.api.practice.dao.sql;

import org.apache.ibatis.annotations.Param;

import com.rockit.core.pojo.Pagination;

/**
 * @author zhandc 2016年9月6日
 *
 */
public class UserPracticeDaoSqlProvider {

	public String getUserPracticeList(@Param("userId") Long userId, @Param("styleId") Integer styleId,Pagination pagination){
		StringBuilder sb = new StringBuilder(512);
		sb.append(" select p.total_practice_time as totalPracticeTime, p.total_practice_count as totalPracticeCount, ");
		sb.append(" p.total_practice_score as totalPracticeScore, p.best_avg_score as bestAvgScore, p.full_score_best_time ");
		sb.append(" as fullScoreBestTime, s.name as songName from t_user_practice_act_log p LEFT JOIN t_practice_song ps ON p.practice_song_id = ps.id ");
		sb.append(" LEFT JOIN t_song s on ps.song_id = s.id where p.user_id = #{userId} and p.style_id = #{styleId}");
		sb.append(" order by songName desc ");
		sb.append(" limit ").append(pagination.getOffset()).append(",").append(pagination.getLimit());
		return sb.toString();
	}
	
	public String getUserStageSongList(@Param("userId") Long userId, @Param("styleId") Integer styleId,Pagination pagination){
		StringBuilder sb = new StringBuilder(1024);
		sb.append(" select ps.id as practiceSongId, ps.unlock_gold_coin as unlockGoldCoin, s.name as songName, s.description as description, ");
		sb.append(" s.icon_url as iconUrl, s.opern_screenshot_url as opern_screenshot_url, s.opern_url as opernUrl, ");
		sb.append(" s.wav_play_url as wavPlayUrl, s.midi_play_url as midiPlayUrl,pu.is_need_lock as isNeedLock, ");
		sb.append(" pa.total_practice_count as totalPracticeCount, pa.total_practice_score as totalPracticeScore,");
		sb.append(" pa.best_avg_score as bestAvgScore from t_practice_song ps ");
		sb.append(" left join t_song s on ps.song_id = s.id ");
		sb.append(" left join t_user_practice_unlock_log pu on ps.id=pu.practice_song_id and pu.user_id = #{userId} ");
		sb.append(" left join t_user_practice_act_log pa on ps.id=pa.practice_song_id and pa.user_id = #{userId} ");
		sb.append(" where ps.status=0 and ps.style_id = #{styleId}");
		sb.append(" order by isNeedLock desc, songName");
		sb.append(" limit ").append(pagination.getOffset()).append(",").append(pagination.getLimit());
		return sb.toString();
		
	}
}
