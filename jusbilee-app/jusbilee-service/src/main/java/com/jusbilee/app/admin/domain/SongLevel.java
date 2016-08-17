/**
 * zhandc 2016年8月17日
 */
package com.jusbilee.app.admin.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhandc 2016年8月17日
 *
 */
public class SongLevel {
	
	private Long levelId;
	private String levelName;
	private Date createTime;
	
	private SimpleDateFormat dfm =  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	/**
	 * @return the levelId
	 */
	public Long getLevelId() {
		return levelId;
	}

	/**
	 * @param levelId the levelId to set
	 */
	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}

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

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return this.createTime == null ? "" : dfm.format(createTime);
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
