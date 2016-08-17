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

import com.jusbilee.app.admin.dao.sql.SongStyleDaoProvider;
import com.jusbilee.app.admin.domain.SongStyle;
import com.jusbilee.app.admin.domain.SongStyleCriteria;

/**
 * @author zhandc 2016年8月17日
 *
 */

@Mapper
public interface SongStyleDao {

	@Insert("insert into t_song_style(style_name,create_time) values(#{styleName}, now())")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "styleId", keyColumn = "id", resultType = Long.class, before = false)
	void songStyleInsert(SongStyle songStyle);
	
	@Delete(" delete from t_song_style where id = #{styleId}")
	void songStyleDelete(@Param("styleId") long styleId);
	
	@Update(" update t_song_style set style_name = #{styleName} ,update_time = now() where id = #{styleId}")
	void songStyleUpdate(SongStyle songStyle);
	
	@SelectProvider(type = SongStyleDaoProvider.class, method = "count")
	int count(SongStyleCriteria criteria);
	
	@SelectProvider(type = SongStyleDaoProvider.class, method = "queryList")
	List<SongStyle> queryList(SongStyleCriteria criteria);
	
	@Select("select id as styleId, style_name as styleName, create_time as createTime from t_song_style where id= #{styleId}")
	SongStyle selectById(@Param("styleId")  long styleId);
}
