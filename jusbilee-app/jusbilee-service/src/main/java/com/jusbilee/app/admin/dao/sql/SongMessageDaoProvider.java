/**
 * zhandc 2016年8月16日
 */
package com.jusbilee.app.admin.dao.sql;

import org.apache.ibatis.jdbc.SQL;

import com.jusbilee.app.admin.domain.SongMessage;
import com.jusbilee.app.admin.domain.SongMessageCriteria;

/**
 * @author zhandc 2016年8月16日
 *
 */
public class SongMessageDaoProvider {
	
	public String songMessageInsert(SongMessage songMessage) {
		return new SQL() {
			{
				INSERT_INTO("t_song_message");
				
				if (songMessage.getUserId() != null) {
					VALUES("user_id", "#{userId}");
				}
				VALUES("song_name", "#{songName}");
				if (songMessage.getLevelId() != null) {
					VALUES("level_id", "#{levelId}");
				}
				
				
				if (songMessage.getStyleId() != null) {
					VALUES("style_id", "#{styleId}");
				}
				
				if (songMessage.getSongDescription() != null) {
					VALUES("song_description", "#{songDescription}");
				}
				
				if (songMessage.getSongIcon() != null) {
					VALUES("song_icon", "#{songIcon}");
				}
				
				if (songMessage.getSongScore() != null) {
					VALUES("song_score", "#{songScore}");
				}
				
				if (songMessage.getSongMidiFile() != null) {
					VALUES("song_midi_file", "#{songMidiFile}");
				}
				
				if (songMessage.getSongWavFile() != null) {
					VALUES("song_wav_file", "#{songWavFile}");
				}
				
				VALUES("create_time", "now()");
			}
		}.toString();
	}
	
	public String songMessageUpdate(SongMessage songMessage){
		StringBuilder sb = new StringBuilder(512);
		
		sb.append("update t_song_message ");
		sb.append(" set update_time = now() ");
		if(songMessage.getSongName() != null){
			sb.append(" , song_name = #{songName}");
		}
		
		if(songMessage.getLevelId() != null){
			sb.append(" , level_id = #{levelId}");
		}
		
		if(songMessage.getCheckStatus() != null){
			sb.append(" , check_status = #{checkStatus}");
		}
		
		if(songMessage.getCheckLog() != null){
			sb.append(" , check_log = #{checkLog}");
		}
		
		if(songMessage.getStyleId() != null){
			sb.append(" , style_id = #{styleId}");
		}
		
		if(songMessage.getSongStatus() != null){
			sb.append(" , song_status = #{songStatus}");
		}
		
		if(songMessage.getSongDescription() != null){
			sb.append(" , song_description = #{songDescription}");
		}
		
		if(songMessage.getSongIcon() != null){
			sb.append(" , song_icon = #{songIcon}");
		}
		
		if(songMessage.getSongScore() != null){
			sb.append(" , song_score = #{songScore}");
		}
		
		if(songMessage.getSongMidiFile() != null){
			sb.append(" , song_midi_file = #{songMidiFile}");
		}
		
		if(songMessage.getSongWavFile() != null){
			sb.append(" , song_wav_file = #{songWavFile} ");
		}
		
		sb.append(" where song_id = #{songId}");
		return sb.toString();
	} 
	
	public String songMessageCount(SongMessageCriteria criteria){
		StringBuilder sb = new StringBuilder(512);
		sb.append(" select count(1) from t_song_message where 1=1 ");
		if(criteria.getSongStyleId() != null){
			sb.append(" and style_id = #{songStyleId} ");
		}
		
		if(criteria.getLevelId() != null){
			sb.append(" and level_id = #{levelId} ");
		}
		
		if(criteria.getCheckStatus() != null){
			sb.append(" and check_status = #{checkStatus} ");
		}
		
		if(criteria.getUserId() != null){
			sb.append(" and user_id = #{userId} ");
		}
		
		if(criteria.getSongName() != null){
			sb.append(" and instr(song_name, #{songName}) > 0 ");
		}
		
		return sb.toString();
	}
	
	public String songMessageQueryList(SongMessageCriteria criteria){
		StringBuilder sb = new StringBuilder(1024);
		sb.append(" select m.song_id as songId, m.song_name as songName,m.song_description as songDescription ");
		sb.append(" ,s.style_name as styleName, l.level_name as levelName ");
		sb.append(" from t_song_message m ");
		sb.append(" LEFT JOIN t_song_style s ");
		sb.append(" on m.style_id = s.id ");
		sb.append(" LEFT JOIN t_song_level l ");
		sb.append(" on m.level_id = l.id ");
		sb.append(" where 1=1 ");
		
		if(criteria.getSongStyleId() != null){
			sb.append(" and m.style_id = #{songStyleId} ");
		}
		
		if(criteria.getLevelId() != null){
			sb.append(" and m.level_id = #{levelId} ");
		}
		
		if(criteria.getCheckStatus() != null){
			sb.append(" and m.check_status = #{checkStatus} ");
		}
		
		if(criteria.getUserId() != null){
			sb.append(" and m.user_id = #{userId} ");
		}
		
		if(criteria.getSongName() != null){
			sb.append(" and instr(m.song_name, #{songName}) > 0 ");
		}
		
		sb.append(" order by song_name ");
		sb.append(" limit #{rp} offset #{offset}");
		return sb.toString();
	}

}
