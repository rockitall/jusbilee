/**
 * zhandc 2016年8月16日
 */
package com.jusbilee.app.admin.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jusbilee.app.admin.dao.UserArchiveDao;
import com.jusbilee.app.admin.domain.UserArchive;
import com.jusbilee.app.admin.domain.UserArchiveCriteria;

/**
 * @author zhandc 2016年8月16日
 *
 */

@Service
public class UserArchiveService {
	
	@Autowired
	private UserArchiveDao userArchiveDao;
	
	public void addUserArchive(UserArchive userArchive){
		userArchiveDao.archiveInsert(userArchive);
	}
	
	public void updateUserArchive(UserArchive userArchive){
		userArchiveDao.archiveUpdate(userArchive);
	}
	
	public UserArchive selectById(long userId){
		return userArchiveDao.selectbyId(userId);
	}
	
	public UserArchive selectUserArchive(long userId){
		return userArchiveDao.selectUserArchive(userId);
	}
	
	/**
	 * 更改是否锁定状态
	 * @param userId
	 * @param isLock
	 */
	public void upDateLock(long userId, int isLock){
		UserArchive userArchive = new UserArchive();
		userArchive.setUserId(userId);
		userArchive.setIsLock(isLock);
		userArchiveDao.archiveUpdate(userArchive);
	}
	
	/**
	 * 更改是否在线问题
	 * @param userId
	 * @param isLogin
	 */
	public void updateIsLogin(long userId, int isLogin){
		UserArchive userArchive = new UserArchive();
		userArchive.setUserId(userId);
		userArchive.setIsOnLineNow(isLogin);
		userArchiveDao.archiveUpdate(userArchive);
	}
	
	/**
	 * 每次登出的时候,记录最后的登录时间
	 * @param userId
	 */
	public void lsatLogin(long userId){
		UserArchive userArchive = new UserArchive();
		userArchive.setUserId(userId);
		userArchive.setLastLogin(new Date());
		userArchiveDao.archiveUpdate(userArchive);
	}
	
	public List<UserArchive> getFriends(long userId){
		return userArchiveDao.userFriends(userId);
	}
	
	public void query(UserArchiveCriteria criteria) {
		int total = userArchiveDao.countUserFriends(criteria);
		if (total > 0) {
			List<UserArchive> list = userArchiveDao.queryUserFriends(criteria);
			criteria.setTotal(total);
			criteria.setRows(list);
		}
	}

}
