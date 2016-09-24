/**
 * zhandc 2016年9月24日
 */
package com.jusbilee.app.api.seasonRace.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jusbilee.app.api.seasonRace.domain.UserInfo;
import com.jusbilee.app.api.seasonRace.domain.UserSeasonRaceRank;
import com.jusbilee.app.api.seasonRace.domain.UserSeasonRaceSummaryDomain;
import com.jusbilee.app.api.seasonRace.service.ApiSeasonRaceService;
import com.rockit.core.pojo.Pagination;

/**
 * @author zhandc 2016年9月24日
 *
 */

@Service
public class UserSeasonRaceManager {

	@Autowired
	private ApiSeasonRaceService apiSeasonRaceService;

	public UserSeasonRaceSummaryDomain getUserSeasonRaceSummary(long userId) {
		Integer seasonId = apiSeasonRaceService.getSeasonId();
		if (seasonId == null)
			return null;
		return apiSeasonRaceService.getUserSeasonRaceSummary(userId, seasonId);
	}

	public List<UserSeasonRaceRank> getSeasonRank(long userId, Pagination pagination) {
		Integer seasonId = apiSeasonRaceService.getSeasonId();
		if (seasonId == null)
			return Collections.emptyList();
		List<UserSeasonRaceRank> rankList = apiSeasonRaceService.getRateRankAll(seasonId, pagination);

		List<Long> userIdList = new ArrayList<>();
		rankList.stream().forEach(rank -> {
			userIdList.add(rank.getUserId());
		});

		Map<Long, UserInfo> userMap = apiSeasonRaceService.getUserInfo(userIdList);
		Map<Long, Long> friendsId = apiSeasonRaceService.getFriendsId(userId);

		List<UserSeasonRaceRank> resultList = new ArrayList<UserSeasonRaceRank>();
		rankList.stream().forEach(rank -> {
			UserInfo user = userMap.get(rank.getUserId());
			rank.setUserName(user.getUserName());
			rank.setLevel(user.getLevel());
			rank.setFread(friendsId.containsKey(rank.getUserId()));
			resultList.add(rank);
		});
		formatRank(resultList, pagination);
		return resultList;
	}
	
	public List<UserSeasonRaceRank> getFriendsSeasonRank(long userId, Pagination pagination){
		Integer seasonId = apiSeasonRaceService.getSeasonId();
		if (seasonId == null)
			return Collections.emptyList();
		List<UserSeasonRaceRank> friendsRankList = apiSeasonRaceService.getRateRankByUserId(seasonId, userId, pagination);
		formatRank(friendsRankList, pagination);
		return friendsRankList;
	}
	
	private void formatRank(List<UserSeasonRaceRank> list, Pagination pagination){
		long i = pagination.getOffset() + 1;
		for( int j=0; j < list.size(); i++,j++ ){
			list.get(j).setRank(i);
		}
	}
}
