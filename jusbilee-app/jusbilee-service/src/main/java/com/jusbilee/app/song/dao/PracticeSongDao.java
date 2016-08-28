/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.song.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.jusbilee.app.admin.domain.SongStyle;
import com.jusbilee.app.song.dao.sql.PracticeSongDaoSqlProvider;
import com.jusbilee.app.song.domain.PracticeSong;
import com.jusbilee.app.song.domain.PracticeSongCriteria;

/**
 * @author zhandc 2016年8月28日
 *
 */

@Mapper
public interface PracticeSongDao {

	@SelectProvider(type = PracticeSongDaoSqlProvider.class, method = "getList")
	List<PracticeSong> getList(PracticeSongCriteria criteria);
	
	@Insert("insert into t_practice_song(song_id,style_id,lock_gold_coin,create_time) values(#{songId}, #{styleId}, #{lockGoldCoin},now())")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", resultType = Long.class, before = false)
	void insert(PracticeSong practiceSong);
	
	@Update(" update t_practice_song set is_deleted = 1 ,update_time = now() where id = #{id}")
	void delete(@Param("id") long id);
	
	
	@Update(" update t_practice_song set song_id = #{songId}, style_id= #{styleId}, lock_gold_coin = #{lockGoldCoin},update_time = now() where id = #{id}")
	void update(PracticeSong practiceSong);
	
	
}
