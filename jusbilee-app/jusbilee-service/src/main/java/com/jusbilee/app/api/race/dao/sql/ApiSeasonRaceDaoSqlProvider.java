/**
 * zhandc 2016年9月23日
 */
package com.jusbilee.app.api.race.dao.sql;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rockit.core.pojo.Pagination;

/**
 * @author zhandc 2016年9月23日
 *
 */
public class ApiSeasonRaceDaoSqlProvider {

	public String getRateRankAll(@Param("seasonId") Integer seasonId, Pagination pagination) {

		StringBuilder sb = new StringBuilder(256);
		sb.append(" select user_id as userId, score as score ");
		sb.append(" from t_user_season_race_summary ");
		sb.append(" where season_id = #{seasonId}");
		sb.append(" order by score desc");
		sb.append(" limit ").append(pagination.getOffset()).append(",").append(pagination.getLimit());
		return sb.toString();
	}

	public String getUserInfo(@Param("userIdList") List<Long> userIdList) {
		StringBuilder sb = new StringBuilder(128);
		sb.append(" select id as userId, nickname as userName, level as level, avatar as avatar ");
		sb.append(" from t_app_user ");
		sb.append(" where id in ( ");
		for (Long id : userIdList) {
			sb.append(id).append(',');
		}
		sb.setCharAt(sb.length() - 1, ')');
		return sb.toString();
	}

	public String getRateRankByUserId(@Param("seasonId") Integer seasonId, @Param("userId") Long userId,
			Pagination pagination) {
		StringBuilder sb = new StringBuilder(512);
		sb.append(" select u.userId, u.userName,u.avatar,u.level, s.score");
		sb.append(" from (select u.nickname as userName,u.avatar as avatar, u.level as level ,f.friend_user_id as userId ");
		sb.append(" from  t_user_friend f ,t_app_user u where f.friend_user_id = u.id ");
		sb.append(" and f.user_id = #{userId} and f.is_deleted=0 UNION select u.nickname,u. LEVEL,u.id from t_app_user u where id=#{userId}) u");
		sb.append(" LEFT JOIN t_user_season_race_summary s on u.userId = s.user_id and s.season_id =#{seasonId}");
		sb.append(" order by score desc");
		sb.append(" limit ").append(pagination.getOffset()).append(",").append(pagination.getLimit());
		return sb.toString();
	}

}
