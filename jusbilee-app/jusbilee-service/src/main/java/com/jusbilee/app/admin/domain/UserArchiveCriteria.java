/**
 * zhandc 2016年8月16日
 */
package com.jusbilee.app.admin.domain;

import com.rockit.core.pojo.Pager;

/**
 * @author zhandc 2016年8月16日
 *
 */
public class UserArchiveCriteria extends Pager<UserArchive>{
	
	private Long userId;

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	

}
