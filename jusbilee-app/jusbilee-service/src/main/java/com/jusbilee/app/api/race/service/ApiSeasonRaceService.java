/**
 * zhandc 2016年9月23日
 */
package com.jusbilee.app.api.race.service;

import com.jusbilee.app.api.race.dao.ApiSeasonRaceDao;
import com.jusbilee.app.api.race.domain.UserInfo;
import com.jusbilee.app.api.race.domain.UserSeasonRaceRank;
import com.jusbilee.app.api.race.domain.UserSeasonRaceSummaryDomain;
import com.rockit.core.pojo.Pagination;
import com.rockit.core.utils.IdentityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhandc 2016年9月23日
 *
 */

@Service
public class ApiSeasonRaceService {

	@Autowired
	private ApiSeasonRaceDao apiSeasonRaceDao;
	
	public Integer  getSeasonId(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		List<Integer> list = apiSeasonRaceDao.getSeasonId(sdf.format(new Date()));
		return list.isEmpty() ? 0 : list.get(0);
	}
	
	public UserSeasonRaceSummaryDomain getUserSeasonRaceSummary( long userId ,int seasonId){
		return apiSeasonRaceDao.getUserSeasonRaceSummary(userId, seasonId);
	}
	
	public  List<UserSeasonRaceRank> getRateRankAll(int seasonId, Pagination pagination){
		return apiSeasonRaceDao.getRateRankAll(seasonId, pagination);
	}
	
	public  Map<Long, UserInfo> getUserInfo( List<Long> userIdList){
		List<UserInfo> list = apiSeasonRaceDao.getUserInfo(userIdList);
		return IdentityUtils.asMap(list, v -> v.getUserId());
	}
	
	public UserInfo getUserInfoById(long userId){
		return apiSeasonRaceDao.getUserInfoById(userId);
	}
	
	public  Map<Long, Long> getFriendsId(long userId){
		List<Long> list = apiSeasonRaceDao.getAllFriends(userId);
		return IdentityUtils.asMap(list, v -> v.longValue());
	}
	
	public  List<UserSeasonRaceRank> getRateRankByUserId(int seasonId, long userId, Pagination pagination){
		return apiSeasonRaceDao.getRateRankByUserId(seasonId, userId, pagination);
	}
}
