/**
 * zhandc 2016年9月24日
 */
package com.jusbilee.app.api.seasonRace.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jusbilee.app.api.song.domain.ApiSong;

/**
 * @author zhandc 2016年9月24日
 *
 */

@Mapper
public interface ApiSeasonRaceGameDao {

	@Select("select max(id) from  t_song_sub_level  where is_deleted =0 and score <= #{score}")
	public int getSubLevel( @Param("score") Integer score);
	
	@Select(" select song_id from t_race_season_song where season_id = #{seasonId} and is_deleted =0 and sub_level_id <= #{subLevel}")
	public List<Integer> getSongIdList(@Param("seasonId") Integer seasonId, @Param("subLevel") Integer subLevel);
	
	@Select(" select id as songId, name as songName, description as description,icon_url as iconUrl,opern_screenshot_url as opernScreenshotUrl,"
			+ " opern_url as opernUrl, wav_play_url as wavPlayUrl,midi_play_url as midiPlayUrl from t_song where id=#{songId}")
	public ApiSong getSonginfo(@Param("songId") Integer songId);
}
