/**
 * zhandc 2016年8月17日
 */
package com.jusbilee.app.admin.domain;

import com.rockit.core.pojo.Pager;

/**
 * @author zhandc 2016年8月17日
 *
 */
public class SongLevelCriteria extends Pager<SongLevel>{
	
	private String levelName;

	/**
	 * @return the levelName
	 */
	public String getLevelName() {
		return levelName;
	}

	/**
	 * @param levelName the levelName to set
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	
	

}
