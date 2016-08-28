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

import com.jusbilee.app.song.dao.sql.StageSongDaoSqlProvider;
import com.jusbilee.app.song.domain.StageSongDomain;
import com.jusbilee.app.song.domain.StageSongDomainCriteria;

/**
 * @author zhandc 2016年8月28日
 *
 */

@Mapper
public interface StageSongDao {
	
	@SelectProvider(type = StageSongDaoSqlProvider.class, method = "getList")
	List<StageSongDomain> getList(StageSongDomainCriteria criteria);
	
	@Insert("insert into t_stage_song(song_id,stage_level_id,pass_score,create_time) values(#{songId}, #{stageLevelId}, #{passScore},now())")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", resultType = Long.class, before = false)
	void insert(StageSongDomain stageSongDomain);
	
	@Update(" update t_stage_song set is_deleted = 1 ,update_time = now() where id = #{id}")
	void delete(@Param("id") int id);
	
	
	@Update(" update t_stage_song set song_id = #{songId}, stage_level_id= #{stageLevelId}, pass_score = #{passScore},update_time = now() where id = #{id}")
	void update(StageSongDomain stageSongDomain);

}
