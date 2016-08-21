/**
 * zhandc 2016年8月6日
 */
package com.jusbilee.app.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jusbilee.app.admin.dao.SysUserDao;
import com.jusbilee.app.admin.domain.SysUser;
import com.jusbilee.app.admin.domain.SysUserCriteria;
import com.rockit.core.exception.UserAlreadyExistsException;

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
	
   public void query(SysUserCriteria criteria){
	   int total = sysUserDao.count(criteria);
	   if(total > 0 ){
		   List<SysUser> list = sysUserDao.queryList(criteria);
		   criteria.setTotal(total);
		   criteria.setRows(list);
	   }
	   
   }
   
	private void checkUsernameExists(SysUser sysUser) throws UserAlreadyExistsException {
		SysUser user = sysUserDao.selectByUsername(sysUser.getUsername());
		if (!sysUser.getUserId().equals(user.getUserId())) {
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
