/**
 * zhandc 2016年8月17日
 */
package com.jusbilee.app.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.jusbilee.app.admin.dao.sql.SongLevelDaoProvider;
import com.jusbilee.app.admin.domain.SongLevel;
import com.jusbilee.app.admin.domain.SongLevelCriteria;

/**
 * @author zhandc 2016年8月17日
 *
 */

@Mapper
public interface SongLevelDao {
	
	@Insert("insert into t_song_level(level_name,create_time) values(#{levelName}, now())")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "levelId", keyColumn = "id", resultType = Long.class, before = false)
	void songLevelInsert(SongLevel songLevel);
	
	@Delete("delete from t_song_level where id = #{levelId}")
    void songLevelDelete(@Param("levelId") long levelId);
	
	@Update("update t_song_level set level_name = #{levelName}, update_time = now() where id = #{levelId}")
	void songLevelUpdate(SongLevel songLevel);
	
	@SelectProvider(type = SongLevelDaoProvider.class, method = "count")
	int count(SongLevelCriteria criteria);
	
	@SelectProvider(type = SongLevelDaoProvider.class, method = "queryList")
	List<SongLevel> queryList(SongLevelCriteria criteria);
	
	@Select("select id as levelId, level_name as levelName, create_time as createTime from t_song_level where id= #{levelId}")
	SongLevel selectById(@Param("levelId")  long levelId);
	
}

