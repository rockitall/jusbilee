/**
 * zhandc 2016年9月24日
 */
package com.jusbilee.app.api.seasonRace.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jusbilee.app.api.seasonRace.dao.ApiSeasonRaceGameDao;
import com.jusbilee.app.api.song.domain.ApiSong;
import com.jusbilee.app.mybatis.dao.RaceSeasonSongMapper;
import com.jusbilee.app.mybatis.dao.UserSeasonRaceLogMapper;
import com.jusbilee.app.mybatis.dao.UserSeasonRacePoolMapper;
import com.jusbilee.app.mybatis.dao.UserSeasonRaceSummaryMapper;
import com.jusbilee.app.mybatis.pojo.RaceSeasonSong;
import com.jusbilee.app.mybatis.pojo.RaceSeasonSongCriteria;
import com.jusbilee.app.mybatis.pojo.UserSeasonRaceLog;
import com.jusbilee.app.mybatis.pojo.UserSeasonRacePool;
import com.jusbilee.app.mybatis.pojo.UserSeasonRacePoolCriteria;
import com.jusbilee.app.mybatis.pojo.UserSeasonRaceSummary;
import com.jusbilee.app.mybatis.pojo.UserSeasonRaceSummaryCriteria;

/**
 * @author zhandc 2016年9月24日
 *
 */

@Service
public class ApiSeasonRaceGameService {

	@Autowired
	private ApiSeasonRaceGameDao ApiSeasonRaceGameDao;
	
	@Autowired
	private UserSeasonRaceSummaryMapper userSeasonRaceSummaryMapper;
	
	@Autowired
	private UserSeasonRacePoolMapper userSeasonRacePoolMapper;
	
	@Autowired
	private RaceSeasonSongMapper raceSeasonSongMapper;
	
	@Autowired
	private UserSeasonRaceLogMapper userSeasonRaceLogMapper;
	
	public int getSubLevel( Integer score){
		return ApiSeasonRaceGameDao.getSubLevel( score);
	}
	
	public Integer getSongId(Integer seasonId, Integer subLevel){
	    List<Integer> list = ApiSeasonRaceGameDao.getSongIdList(seasonId, subLevel);
		int i = new Random().nextInt(list.size());
		return list.get(i);
	}
	
	public ApiSong getSonginfo(int songId){
		return ApiSeasonRaceGameDao.getSonginfo(songId);
	}
	
	public void initUserSeasonRaceSummary(long userId, int seasonId){
		UserSeasonRaceSummary summary = new UserSeasonRaceSummary();
		summary.setUserId(userId);
		summary.setSeasonId(seasonId);
		summary.setCreateTime(new Date());
		userSeasonRaceSummaryMapper.insertSelective(summary);
	}
	
	public RaceSeasonSong getRaceSeasonSong(int seasonId, int songId){
		RaceSeasonSongCriteria criteria = new RaceSeasonSongCriteria();
		criteria.createCriteria().andSeasonIdEqualTo(seasonId).andSongIdEqualTo(songId);
		List<RaceSeasonSong> list = raceSeasonSongMapper.selectByExample(criteria);
		return list.isEmpty() ? null : list.get(0);
	}
	
	public void updateUserSeasonRaceSummary(UserSeasonRaceSummary summary){
		userSeasonRaceSummaryMapper.updateByPrimaryKeySelective(summary);
	}
	
	public UserSeasonRaceSummary getUserSeasonRaceSummary(long userId, Integer seasonId){
		UserSeasonRaceSummaryCriteria criteria = new UserSeasonRaceSummaryCriteria();
		criteria.createCriteria().andUserIdEqualTo(userId).andSeasonIdEqualTo(seasonId);
		List<UserSeasonRaceSummary> list = userSeasonRaceSummaryMapper.selectByExample(criteria);
		return list.isEmpty() ? null : list.get(0);
	}
	
	public UserSeasonRacePool getUserSeasonRacePool(int subLevel){
		UserSeasonRacePoolCriteria criteria = new UserSeasonRacePoolCriteria();
		criteria.createCriteria().andSubLevelIdBetween(subLevel -2, subLevel + 2).andIsMatchEqualTo((byte)0);
		List<UserSeasonRacePool> list = userSeasonRacePoolMapper.selectByExample(criteria);
		return list.isEmpty() ? null : list.get(new Random().nextInt(list.size()));
	}
	
	public UserSeasonRacePool getUserSeasonRacePool(Long userId){
		UserSeasonRacePoolCriteria criteria = new UserSeasonRacePoolCriteria();
		criteria.createCriteria().andUserIdEqualTo(userId);
		List<UserSeasonRacePool> list = userSeasonRacePoolMapper.selectByExample(criteria);
		return list.isEmpty() ? null : list.get(0);
	}
	
	public void addUserSeasonRacePool(long userId, int subLevelId, int seasonSongId){
		UserSeasonRacePool racePool = new UserSeasonRacePool();
		racePool.setUserId(userId);
		racePool.setSubLevelId(subLevelId);
		racePool.setSeasonSongId(seasonSongId);
		
		userSeasonRacePoolMapper.insertSelective(racePool);
	}
	
	public void updateUserSeasonRacePool(UserSeasonRacePool racePool, long opponentId){
		racePool.setIsMatch((byte)1);
		racePool.setOpponentId(opponentId);
		userSeasonRacePoolMapper.updateByPrimaryKey(racePool);
	}
	
	public void deleteUserSeasonRacePool(UserSeasonRacePool racePool){
		userSeasonRacePoolMapper.deleteByPrimaryKey(racePool.getId());
	}
	
	public void insertUserSeasonRaceLog(UserSeasonRaceLog log){
		userSeasonRaceLogMapper.insertSelective(log);
	}
	
}
