/**
 * zhandc 2016年8月15日
 */
package com.jusbilee.app.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.jusbilee.app.admin.dao.sql.UserSongPracticeDaoProvider;
import com.jusbilee.app.admin.domain.UserSongPractice;

/**
 * @author zhandc 2016年8月15日
 *
 */

@Mapper
public interface UserSongPracticeDao {

	@InsertProvider(type = UserSongPracticeDaoProvider.class, method = "insert")
	void insert(UserSongPractice userSongPractice);

	@Update("update t_user_song_practice set time=#{time}, avg_score=#{avgScore} , excellent_time = #{excellentTime} "
			+ "where user_id=#{userId} and song_id = #{songId}")
	void update(UserSongPractice userSongPractice);
	
	@Select("select time , avg_score as avgScore, excellent_time as excellentTime  from  t_user_song_practice whereuser_id=#{userId} and song_id = #{songId}")
	UserSongPractice selectById(long userId, long songId);

	@SelectProvider(type = UserSongPracticeDaoProvider.class, method = "queryList")
	List<UserSongPractice> queryList(long userId, Integer songType);
}
