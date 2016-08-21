/**
 * zhandc 2016年8月16日
 */
package com.jusbilee.app.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.jusbilee.app.admin.dao.sql.SongMessageDaoProvider;
import com.jusbilee.app.admin.domain.SongMessage;
import com.jusbilee.app.admin.domain.SongMessageCriteria;

/**
 * @author zhandc 2016年8月16日
 *
 */

@Mapper
public interface SongMessageDao {
	
	@InsertProvider(type = SongMessageDaoProvider.class, method = "songMessageInsert")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "songId", keyColumn = "song_id", resultType = Long.class, before = false)
	void songMessageInsert(SongMessage songMessage);
	
	@UpdateProvider(type = SongMessageDaoProvider.class, method = "songMessageUpdate")
	void songMessageUpdate(SongMessage songMessage);
	
	@SelectProvider(type = SongMessageDaoProvider.class, method = "songMessageCount")
    int songMessageCount(SongMessageCriteria criteria);
	
	@SelectProvider(type = SongMessageDaoProvider.class, method = "songMessageQueryList")
    List<SongMessage> songMessageQueryList(SongMessageCriteria criteria);
	
	@Select("select song_id as songId, song_name as songName, song_description as songDescription, level_id as levelId ,"
			+ " check_status as checkStatus, check_log as checkLog, style_id as styleId, song_status as songStatus,"
			+ "song_icon as songIcon, song_midi_file as songMidiFile, song_wav_file as songWavFile from t_song_message  where song_id =#{songId}")
	SongMessage selectById(@Param("songId") long songId);
}


