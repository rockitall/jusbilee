/**
 * zhandc 2016年8月15日
 */
package com.jusbilee.app.song.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jusbilee.app.admin.dao.UserSongPracticeDao;
import com.jusbilee.app.admin.domain.UserSongPractice;

/**
 * @author zhandc 2016年8月15日
 *
 */

@Service
public class UserSongPracticeService {

	@Autowired
	private UserSongPracticeDao userSongPracticeDao;

	public void insertOrUpdate(UserSongPractice usp) {
		UserSongPractice _usp = userSongPracticeDao.selectById(usp.getUserId(),
				usp.getSongId());
		if(_usp == null){
			userSongPracticeDao.insert(usp);
		}else{
			usp.setAvgScore((int)(usp.getAvgScore() + _usp.getAvgScore())/2);
			usp.setExcellentTime(usp.getExcellentTime() > _usp.getExcellentTime() ? usp.getExcellentTime(): _usp.getExcellentTime());
			usp.setTime(usp.getTime() + -usp.getTime());
			userSongPracticeDao.insert(usp);
		}
	}
	
	public List<UserSongPractice> queryList(long userId, Integer songType){
		return userSongPracticeDao.queryList(userId, songType);
	}

}
