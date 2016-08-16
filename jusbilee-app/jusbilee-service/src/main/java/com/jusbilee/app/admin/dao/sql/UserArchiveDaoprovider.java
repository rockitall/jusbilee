/**
 * zhandc 2016年8月15日
 */
package com.jusbilee.app.admin.dao.sql;

import org.apache.ibatis.jdbc.SQL;

import com.jusbilee.app.admin.domain.UserArchive;

/**
 * @author zhandc 2016年8月15日
 *
 */
public class UserArchiveDaoprovider {
	
	public String archiveInsert(UserArchive userArchive) {
		return new SQL() {
			{
				INSERT_INTO("t_app_user_archive");
				VALUES("user_id", "#{userId}");
				if (userArchive.getGoldCoin() != null) {
					VALUES("gold_coin", "#{goldCoin}");
				}
				if (userArchive.getScore() != null) {
					VALUES("score", "#{score}");
				}
				
				if (userArchive.getScore() != null) {
					VALUES("score", "#{score}");
				}
				
				if (userArchive.getLevel() != null) {
					VALUES("level", "#{level}");
				}
				if (userArchive.getIsUpload() != null) {
					VALUES("is_upload", "#{isUpload}");
				}
				
				VALUES("is_onLine_now", "1");
				VALUES("create_time", "now()");
			}
		}.toString();
	}
	
	public String archiveUpdate(UserArchive userArchive) {
		
		StringBuilder sb = new StringBuilder(256);
		sb.append("update t_app_user_archive ");
		sb.append(" set update_time = now() ");
		
		if (userArchive.getGoldCoin() != null) {
			sb.append(" , gold_coin = #{goldCoin}");
		}
		if (userArchive.getScore() != null) {
			sb.append(" , score = #{score}");
		}
		
		if (userArchive.getLevel() != null) {
			sb.append(" , level = #{level}");
		}
		
		if (userArchive.getIsUpload() != null) {
			sb.append(" , is_upload = #{isUpload}");
		}
		if (userArchive.getIsOnLineNow() != null) {
			sb.append(" , is_onLine_now = #{isOnLineNow}");
		}
		if (userArchive.getIsLock() != null) {
			sb.append(" , is_locked = #{isLock}");
		}
		if (!"".equals(userArchive.getLastLogin())) {
			sb.append(" , last_login = now()");
		}
		sb.append(" where user_id = #{userId} ");
		return sb.toString();
	}
	
	public String selectUserArchive(){
		
	//	Map<String, Object> params
//		Long userId = (Long)params.get("userId"); 
		StringBuilder sb = new StringBuilder(1024);
		
		sb.append("select a.user_id AS userId, a.gold_coin AS goldCoin, a.score, a. LEVEL,a.is_upload AS isUpload,a.is_locked AS isLocked,a.last_login AS lastLogin, ");
		sb.append("p.avgScore, p.totalTime, ");
		sb.append("r.winRate ");
		sb.append(" from t_app_user_archive a ");
		sb.append(" LEFT JOIN ( SELECT p.user_id, avg(p.avg_score) as avgScore, SUM(p.time) as totalTime ");
		sb.append(" from t_user_song_practice p ");
		sb.append(" where p.user_id = #{userId} group by user_id ) p ");
		sb.append(" on a.user_id = p.user_id ");
		sb.append(" left join ( select r.user_id, r.success_time/(r.fail_time+r.success_time) as winRate");
		sb.append(" from t_user_competition_record r ");
		sb.append(" where r.user_id = #{userId} )r ");
		sb.append(" on r.user_id = p.user_id ");
		sb.append(" where a.user_id = #{userId} ");
		return sb.toString();
	}
	
	public String selectbyId(){
		StringBuilder sb = new StringBuilder(512);
		sb.append("select a.user_id AS userId, a.gold_coin AS goldCoin, a.score, a. LEVEL ");
		sb.append(",a.is_upload AS isUpload,a.is_locked AS isLocked,a.last_login AS lastLogin ");
		sb.append(" from t_app_user_archive a ");
		sb.append(" where a.user_id = #{userId} ");
		return sb.toString();
	}
	
	public String userFriends(){
		StringBuilder sb = new StringBuilder(512);
		sb.append(" select f.user_id, a.user_id as userId, a.score, a.level , a.is_onLine_now as isOnLineNow ");
		sb.append(" from t_user_friend f ");
		sb.append(" LEFT JOIN t_app_user_archive a ");
		sb.append(" on f.friend_user_id = a.user_id ");
		sb.append(" where f.user_id = #{userId}");
		sb.append(" order by score desc ");
		return sb.toString();
	}
	
	public String countUserFriends(){
		StringBuilder sb = new StringBuilder(128);
		sb.append("select count(1) from t_user_friend f where f.user_id = #{userId}");
		return sb.toString();
	}
	
	public String queryUserFriends(){
		StringBuilder sb = new StringBuilder(512);
		sb.append(" select f.user_id, a.user_id as userId, a.score, a.level , a.is_onLine_now as isOnLineNow ");
		sb.append(" from t_user_friend f ");
		sb.append(" LEFT JOIN t_app_user_archive a ");
		sb.append(" on f.friend_user_id = a.user_id ");
		sb.append(" where f.user_id = #{userId}");
		sb.append(" order by score desc ");
		sb.append("limit #{rp} offset #{offset}");
		return sb.toString();
	}

}
