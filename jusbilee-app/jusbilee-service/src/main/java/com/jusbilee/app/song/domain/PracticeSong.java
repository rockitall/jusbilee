/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.song.domain;

import java.util.Date;

/**
 * @author zhandc 2016年8月28日
 *
 */
public class PracticeSong {
	private Long id;
	private Integer songId;
	private Integer styleId;
	private Integer lockGoldCoin;
	private String styleName;
	private String songName;
	private Date createTime;
	/**
	 * @return the id
	 */
	
	/**
	 * @return the songId
	 */
	public Integer getSongId() {
		return songId;
	}
	/**
	 * @param songId the songId to set
	 */
	public void setSongId(Integer songId) {
		this.songId = songId;
	}
	/**
	 * @return the styleId
	 */
	public Integer getStyleId() {
		return styleId;
	}
	/**
	 * @param styleId the styleId to set
	 */
	public void setStyleId(Integer styleId) {
		this.styleId = styleId;
	}
	/**
	 * @return the lock_gold_coin
	 */
	/**
	 * @return the styleName
	 */
	public String getStyleName() {
		return styleName;
	}
	/**
	 * @param styleName the styleName to set
	 */
	public void setStyleName(String styleName) {
		this.styleName = styleName;
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
	/**
	 * @return the lockGoldCoin
	 */
	public Integer getLockGoldCoin() {
		return lockGoldCoin;
	}
	/**
	 * @param lockGoldCoin the lockGoldCoin to set
	 */
	public void setLockGoldCoin(Integer lockGoldCoin) {
		this.lockGoldCoin = lockGoldCoin;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
