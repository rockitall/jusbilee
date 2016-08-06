/**
 * zhandc 2016年8月6日
 */
package com.jusbilee.app.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jusbilee.app.admin.dao.SysUserDao;
import com.jusbilee.app.admin.domain.SysUser;
import com.jusbilee.app.common.exception.UserAlreadyExistsException;

/**
 * @author zhandc 2016年8月6日
 *
 */

@Service
public class SysUserServices {

	@Autowired
	private SysUserDao sysUserDao;

	public void insertSysUser(SysUser sysUser) throws UserAlreadyExistsException {
		this.checkUsernameExists(sysUser.getUsername());
		sysUserDao.insert(sysUser);
	}
	
	public void updateSysUser(SysUser sysUser) throws UserAlreadyExistsException {
		this.checkUsernameExists(sysUser);
		sysUserDao.updateSysUser(sysUser);
	}
	
	public SysUser selectById(long userId) {
		return sysUserDao.selectById(userId);
	}
	
	public void updateIslocked(long userId, Byte isLocked) {
		 sysUserDao.updateIslocked(userId, isLocked);
	}
	
	public void deleteSysUser(long userId) {
		sysUserDao.deleteSysUser(userId, (byte) 1);
	}
	
	private void checkUsernameExists(SysUser sysUser) throws UserAlreadyExistsException {
		SysUser user = sysUserDao.selectByUsername(sysUser.getUsername());
		if (sysUser.getUserId().equals(user.getUserId())) {
			throw new UserAlreadyExistsException();
		}
	}

	private void checkUsernameExists(String username) throws UserAlreadyExistsException {
		SysUser user = sysUserDao.selectByUsername(username);
		if (user != null) {
			throw new UserAlreadyExistsException();
		}
	}

}
