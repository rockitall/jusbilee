/**
 * zhandc 2016年8月15日
 */
package com.jusbilee.app.admin.domain;

/**
 * @author zhandc 2016年8月15日
 *
 */
public class UserSongPractice {
	
	private Long userId;
	private Long songId;
	private String songName;
	private Integer songType;
	private Integer time;
	private Integer avgScore;
	private Integer excellentTime;
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
	 * @return the songId
	 */
	public Long getSongId() {
		return songId;
	}
	/**
	 * @param songId the songId to set
	 */
	public void setSongId(Long songId) {
		this.songId = songId;
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
	 * @return the songType
	 */
	public Integer getSongType() {
		return songType;
	}
	/**
	 * @param songType the songType to set
	 */
	public void setSongType(Integer songType) {
		this.songType = songType;
	}
	/**
	 * @return the time
	 */
	public Integer getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Integer time) {
		this.time = time;
	}
	/**
	 * @return the avgScore
	 */
	public Integer getAvgScore() {
		return avgScore;
	}
	/**
	 * @param avgScore the avgScore to set
	 */
	public void setAvgScore(Integer avgScore) {
		this.avgScore = avgScore;
	}
	/**
	 * @return the excellentTime
	 */
	public Integer getExcellentTime() {
		return excellentTime;
	}
	/**
	 * @param excellentTime the excellentTime to set
	 */
	public void setExcellentTime(Integer excellentTime) {
		this.excellentTime = excellentTime;
	}
	
	

}
