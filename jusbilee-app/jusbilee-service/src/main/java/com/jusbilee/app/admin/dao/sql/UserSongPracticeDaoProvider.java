/**
 * zhandc 2016年8月15日
 */
package com.jusbilee.app.admin.dao.sql;

import org.apache.ibatis.jdbc.SQL;

import com.jusbilee.app.admin.domain.UserSongPractice;

/**
 * @author zhandc 2016年8月15日
 *
 */
public class UserSongPracticeDaoProvider {
	
	public String insert(UserSongPractice userSongPractice) {
		return new SQL() {
			{
				INSERT_INTO("t_user_song_practice");
				VALUES("user_id", "#{userId}");
				VALUES("song_id", "songId");
				VALUES("time", "time");
				VALUES("avg_score", "avgScore");
				VALUES("excellent_time", "excellentTime");
			}
		}.toString();
	}
	
	public String queryList(long userId, Integer songStyle){
		StringBuilder sb = new StringBuilder(256);
		sb.append("select s.song_name as songName, u.time, u.avg_score as avgScore,u.excellent_time as excellentTime, s.song_style as songType ");
		sb.append("from t_user_song_practice u ");
		sb.append("LEFT JOIN t_song_message s ");
		sb.append("on u.song_id=s.song_id ");
		if(songStyle != null){
			sb.append("and s.song_style = #{songStyle} ");
		}
		sb.append("where u.user_id = #{userId} ");
		sb.append("order by songName");
		return sb.toString();
	}

}
