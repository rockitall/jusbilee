/**
 * zhandc 2016年8月16日
 */
package com.jusbilee.app.admin.domain;

import com.rockit.core.pojo.Pager;

/**
 * @author zhandc 2016年8月16日
 *
 */
public class SongMessageCriteria extends Pager<SongMessage>{
	
	private Integer songStyleId;//歌曲风格
	private Integer checkStatus;//审核状态
	private Integer levelId;//歌曲难度级别
	private Long userId;//用户id
	private String songName;
	/**
	 * @return the songStyleId
	 */
	public Integer getSongStyleId() {
		return songStyleId;
	}
	/**
	 * @param songStyleId the songStyleId to set
	 */
	public void setSongStyleId(Integer songStyleId) {
		this.songStyleId = songStyleId;
	}
	/**
	 * @return the checkStatus
	 */
	public Integer getCheckStatus() {
		return checkStatus;
	}
	/**
	 * @param checkStatus the checkStatus to set
	 */
	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}
	/**
	 * @return the levelId
	 */
	public Integer getLevelId() {
		return levelId;
	}
	/**
	 * @param levelId the levelId to set
	 */
	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}
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
	/**
	 * @return the songName
	 */
	public String getSongName() {
		return songName;
	}
	/**
	 * @param songName the songName to set
	 */
	public void setSongName(String songName) {
		this.songName = songName;
	}
	
	
	

}
