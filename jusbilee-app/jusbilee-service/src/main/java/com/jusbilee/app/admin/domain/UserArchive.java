/**
 * zhandc 2016年8月13日
 */
package com.jusbilee.app.admin.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhandc 2016年8月13日
 *
 */
public class UserArchive {

	private Long userId;
	private Long goldCoin;
	private Long score;
	private Integer level;
	private Integer isUpload; //是否为可上传曲谱用户
	private double vagScore;
	private double winRate;
	private long totalTime;
	private Date lastLogin;
	private Long friendId;
	private Integer isLock;
	private Integer isOnLineNow;
	
	private SimpleDateFormat dfm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
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
	 * @return the goldCoin
	 */
	public Long getGoldCoin() {
		return goldCoin;
	}
	/**
	 * @param goldCoin the goldCoin to set
	 */
	public void setGoldCoin(Long goldCoin) {
		this.goldCoin = goldCoin;
	}
	/**
	 * @return the score
	 */
	public Long getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(Long score) {
		this.score = score;
	}
	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * @return the isUpload
	 */
	public Integer getIsUpload() {
		return isUpload;
	}
	/**
	 * @param isUpload the isUpload to set
	 */
	public void setIsUpload(Integer isUpload) {
		this.isUpload = isUpload;
	}
	/**
	 * @return the vagScore
	 */
	public double getVagScore() {
		return vagScore;
	}
	/**
	 * @param vagScore the vagScore to set
	 */
	public void setVagScore(double vagScore) {
		this.vagScore = vagScore;
	}
	/**
	 * @return the winRate
	 */
	public double getWinRate() {
		return winRate;
	}
	/**
	 * @param winRate the winRate to set
	 */
	public void setWinRate(double winRate) {
		this.winRate = winRate;
	}
	/**
	 * @return the lastLogin
	 */
	public String getLastLogin() {
		return this.lastLogin == null ? "" : dfm.format(lastLogin);
	}
	/**
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	/**
	 * @return the friendId
	 */
	public Long getFriendId() {
		return friendId;
	}
	/**
	 * @param friendId the friendId to set
	 */
	public void setFriendId(Long friendId) {
		this.friendId = friendId;
	}
	/**
	 * @return the isLock
	 */
	public Integer getIsLock() {
		return isLock;
	}
	/**
	 * @param isLock the isLock to set
	 */
	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}
	/**
	 * @return the isOnLineNow
	 */
	public Integer getIsOnLineNow() {
		return isOnLineNow;
	}
	/**
	 * @param isOnLineNow the isOnLineNow to set
	 */
	public void setIsOnLineNow(Integer isOnLineNow) {
		this.isOnLineNow = isOnLineNow;
	}
	/**
	 * @return the totalTime
	 */
	public long getTotalTime() {
		return totalTime;
	}
	/**
	 * @param totalTime the totalTime to set
	 */
	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}
	
	
	
}
