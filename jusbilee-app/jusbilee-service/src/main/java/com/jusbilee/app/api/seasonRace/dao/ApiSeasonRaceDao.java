/**
 * zhandc 2016年9月22日
 */
package com.jusbilee.app.api.seasonRace.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.jusbilee.app.api.seasonRace.dao.sql.ApiSeasonRaceDaoSqlProvider;
import com.jusbilee.app.api.seasonRace.domain.UserInfo;
import com.jusbilee.app.api.seasonRace.domain.UserSeasonRaceRank;
import com.jusbilee.app.api.seasonRace.domain.UserSeasonRaceSummaryDomain;
import com.rockit.core.pojo.Pagination;

/**
 * @author zhandc 2016年9月22日
 *
 */

@Mapper
public interface ApiSeasonRaceDao {
	
	@Select(" select id from t_race_season where create_time <= #{date} and update_time >=#{date}")
	public List<Integer> getSeasonId(String date);

	@Select(" select best_score as bestScore, win as winCount,win_steak as winStreak from t_user_season_race_summary "
			+ " where user_id= #{userId} and season_id = #{seasonId}")
	public UserSeasonRaceSummaryDomain getUserSeasonRaceSummary(@Param("userId") Long userId,
			@Param("seasonId") Integer seasonId);
	
	@SelectProvider(type = ApiSeasonRaceDaoSqlProvider.class, method = "getRateRankAll")
    List<UserSeasonRaceRank> getRateRankAll(@Param("seasonId") Integer seasonId, Pagination pagination);
	
	@SelectProvider(type = ApiSeasonRaceDaoSqlProvider.class, method = "getUserInfo")
	List<UserInfo> getUserInfo(@Param("userIdList") List<Long> userIdList);
	
	@Select("select friend_user_id as userId from  t_user_friend f where  f.user_id=#{userId} and f.is_deleted=0")
    List<Long> getAllFriends(@Param("userId") Long userId);
	
	@SelectProvider(type = ApiSeasonRaceDaoSqlProvider.class, method = "getRateRankByUserId")
    List<UserSeasonRaceRank> getRateRankByUserId(@Param("seasonId") Integer seasonId,@Param("userId") Long userId, Pagination pagination);
	
}
