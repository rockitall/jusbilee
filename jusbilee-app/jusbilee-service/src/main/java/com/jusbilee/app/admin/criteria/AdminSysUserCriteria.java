/**
 * zhandc 2016年8月6日
 */
package com.jusbilee.app.admin.criteria;


import com.jusbilee.app.admin.domain.AdminSysUser;
import com.rockit.core.pojo.Pager;

/**
 * @author zhandc 2016年8月6日
 *
 */
public class AdminSysUserCriteria extends Pager<AdminSysUser> {
	
	private String userName;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
