/**
 * zhandc 2016年9月24日
 */
package com.jusbilee.app.api.seasonRace.manager;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jusbilee.app.api.seasonRace.request.RateResultRequest;
import com.jusbilee.app.api.seasonRace.response.RaceDetailFacade;
import com.jusbilee.app.api.seasonRace.service.ApiSeasonRaceGameService;
import com.jusbilee.app.api.seasonRace.service.ApiSeasonRaceService;
import com.jusbilee.app.api.song.domain.ApiSong;
import com.jusbilee.app.mybatis.pojo.RaceSeasonSong;
import com.jusbilee.app.mybatis.pojo.UserSeasonRaceLog;
import com.jusbilee.app.mybatis.pojo.UserSeasonRacePool;
import com.jusbilee.app.mybatis.pojo.UserSeasonRaceSummary;

/**
 * @author zhandc 2016年9月24日
 *
 */

@Service
public class ApiSeasonRaceGameManager {

	@Autowired
	private ApiSeasonRaceGameService apiSeasonRaceGameService;

	@Autowired
	private ApiSeasonRaceService apiSeasonRaceService;

	@Transactional
	public RaceDetailFacade getRaceDetail(long userId) {
		// 赛季id
		int seasonId = apiSeasonRaceService.getSeasonId();
		// 用户排位赛档案
		UserSeasonRaceSummary summary = apiSeasonRaceGameService.getUserSeasonRaceSummary(userId, seasonId);
		if (summary == null) {
			apiSeasonRaceGameService.initUserSeasonRaceSummary(userId, seasonId);
			summary = apiSeasonRaceGameService.getUserSeasonRaceSummary(userId, seasonId);
		}
		// 用户段位
		int subLevel = apiSeasonRaceGameService.getSubLevel(summary.getScore());

		UserSeasonRacePool racePool = apiSeasonRaceGameService.getUserSeasonRacePool(subLevel);

		RaceDetailFacade facade = new RaceDetailFacade();

		if (racePool != null) {
			apiSeasonRaceGameService.updateUserSeasonRacePool(racePool, userId);
			ApiSong apiSong = apiSeasonRaceGameService.getSonginfo(racePool.getSeasonSongId());

			facade.setInfo(apiSong);
			facade.setOpponentId(racePool.getUserId());
			return facade;
		} else {
			int songId = apiSeasonRaceGameService.getSongId(seasonId, subLevel);
			ApiSong apiSong = apiSeasonRaceGameService.getSonginfo(songId);
			apiSeasonRaceGameService.addUserSeasonRacePool(userId, subLevel, songId);
			UserSeasonRacePool race = null;
			int time = 0;
			while (time < 60) {
				time = time + 1;
				race = apiSeasonRaceGameService.getUserSeasonRacePool(userId);
				if (race.getIsMatch() == 1) {
					apiSeasonRaceGameService.deleteUserSeasonRacePool(race);
					facade.setInfo(apiSong);
					facade.setOpponentId(race.getOpponentId());
					return facade;
				} else {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			// 返回机器人
			apiSeasonRaceGameService.deleteUserSeasonRacePool(race);
			facade.setInfo(apiSong);
			facade.setOpponentId((long) 0);
			return facade;

		}

	}

	@Transactional
	public void RateResultLog(RateResultRequest result){
		int seasonId = apiSeasonRaceService.getSeasonId();
		int winScore = 0;
		int lostScore = 0;
		//记录成功者
		if(result.getWinId() != 0){
		    winScore = getWinScore( result);
			UserSeasonRaceSummary winner = apiSeasonRaceGameService.getUserSeasonRaceSummary(result.getWinId(),
					seasonId);
			winner.setScore(winner.getScore() + winScore);
			winner.setBestScore(winner.getBestScore() > winScore ?  winner.getBestScore(): winScore);
			winner.setWin(winner.getWin() + 1);
			winner.setWinStreak(winner.getWinStreak() + 1);
			apiSeasonRaceGameService.updateUserSeasonRaceSummary(winner);
		}
		
		//记录失败者
		if(result.getLostId() != 0){
			lostScore = getLostScore(result);
			UserSeasonRaceSummary loser = apiSeasonRaceGameService.getUserSeasonRaceSummary(result.getLostId(),
					seasonId);
			loser.setScore(loser.getScore() + lostScore > 0 ? loser.getScore() + lostScore : 0);
			loser.setLoss(loser.getLoss() + 1);
			loser.setWinStreak(0);
			apiSeasonRaceGameService.updateUserSeasonRaceSummary(loser);
		}
		
		//记录比赛日志
		RaceSeasonSong RaceSong = apiSeasonRaceGameService.getRaceSeasonSong(seasonId, result.getSongId());
		UserSeasonRaceLog log = new UserSeasonRaceLog();
		log.setSeasonId(seasonId);
		log.setWinnerUserId(result.getWinId());
		log.setWinnerScore(winScore);
		log.setLoserUserId(result.getLostId());
		log.setLoserScore(lostScore);
		log.setSeasonSongId(RaceSong.getId());
		log.setSongId(result.getSongId());
		log.setSongLevelId(RaceSong.getLevelId());
		log.setSongSubLevelId(RaceSong.getSubLevelId());
		log.setCreateTime(new Date());
		
		apiSeasonRaceGameService.insertUserSeasonRaceLog(log);
	}

	private int getWinScore(RateResultRequest result) {
		// 赛季id
		int seasonId = apiSeasonRaceService.getSeasonId();
		// 用户排位赛档案

		if (result.getLostId() == 0) {
			UserSeasonRaceSummary winner = apiSeasonRaceGameService.getUserSeasonRaceSummary(result.getWinId(),
					seasonId);
			int winStreak = winner.getWinStreak() + 1 > 10 ? 10 : winner.getWinStreak() + 1;

			return 50 + winStreak * 15;
		} else {
			UserSeasonRaceSummary winner = apiSeasonRaceGameService.getUserSeasonRaceSummary(result.getWinId(),
					seasonId);
			UserSeasonRaceSummary loser = apiSeasonRaceGameService.getUserSeasonRaceSummary(result.getLostId(),
					seasonId);
			int winStreak = winner.getWinStreak() + 1 > 10 ? 10 : winner.getWinStreak() + 1;
			
			// 用户段位
			int winSubLevel = apiSeasonRaceGameService.getSubLevel(winner.getScore());
			int lostSubLevel = apiSeasonRaceGameService.getSubLevel(loser.getScore());
			
			int subDiffer = lostSubLevel - winSubLevel -1 > 0? lostSubLevel - winSubLevel -1 : 0;
			
			return 50 + winStreak * 15 + subDiffer * 5;
		}
	}
	
	private int getLostScore(RateResultRequest result) {
		int seasonId = apiSeasonRaceService.getSeasonId();
		if(result.getWinId() == 0){
			return -50;
		}else{
			UserSeasonRaceSummary winner = apiSeasonRaceGameService.getUserSeasonRaceSummary(result.getWinId(),
					seasonId);
			UserSeasonRaceSummary loser = apiSeasonRaceGameService.getUserSeasonRaceSummary(result.getLostId(),
					seasonId);
			
			// 用户段位
			int winSubLevel = apiSeasonRaceGameService.getSubLevel(winner.getScore());
			int lostSubLevel = apiSeasonRaceGameService.getSubLevel(loser.getScore());
			
			int subDiffer = lostSubLevel - winSubLevel -1 > 0? lostSubLevel - winSubLevel -1 : 0;
			
			return -50 - subDiffer * 5;
		}
	}

}
