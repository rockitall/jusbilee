/**
 * zhandc 2016年8月9日
 */
package com.jusbilee.app.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.jusbilee.app.admin.dao.sql.CensorshipDaoProvider;
import com.jusbilee.app.admin.domain.Censorship;
import com.jusbilee.app.admin.domain.CensorshipCriteria;

/**
 * @author zhandc 2016年8月9日
 *
 */

@Mapper
public interface CensorshipDao {
	
	@InsertProvider(type = CensorshipDaoProvider.class, method = "censorshipInsert")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "censorshipId", keyColumn = "censorship_id", resultType = Long.class, before = false)
	void censorshipInsert(Censorship censorship);
	
	@Update("update t_censorship set name=#{name}, description=#{description} , update_time = now() where censorship_id=#{censorshipId}")
	void updateCensorship(Censorship censorship);
	
	@Delete("delete from t_censorship where censorship_id=#{censorshipId}")
	void deleteCensorship(long censorshipId);
	
	@Select("select censorship_id as censorshipId, name, description  from  t_censorship where censorship_id = #{censorshipId}")
	Censorship selectById(@Param("censorshipId") long censorshipId);
	
	@Select("select censorship_id as censorshipId, name, description  from  t_censorship where name = #{name}")
	Censorship selectByName(@Param("name") String name);
	
	@SelectProvider(type = CensorshipDaoProvider.class, method = "queryList")
	List<Censorship> queryList(CensorshipCriteria criteria);
	
	@SelectProvider(type = CensorshipDaoProvider.class, method = "count")
	int count(CensorshipCriteria criteria);
	
	@Insert("insert into t_censorship_song(censorship_id, song_id) values(#{censorshipId},#{songId})")
	void insertCensorshipSong(long censorshipId, long songId);
	
	@Delete("delete from t_censorship_song where censorship_id=#{censorshipId}")
	void deleteCSByCensorshipId(long censorshipId);
	
	@SelectProvider(type = CensorshipDaoProvider.class, method = "queryCensorshipSongList")
	List<Censorship> queryCensorshipSongList(CensorshipCriteria criteria);
	
	@SelectProvider(type = CensorshipDaoProvider.class, method = "countCensorshipSong")
	int countCensorshipSong(CensorshipCriteria criteria);

}
