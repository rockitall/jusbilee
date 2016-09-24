/**
 * zhandc 2016年9月23日
 */
package com.jusbilee.app.api.seasonRace.domain;

/**
 * @author zhandc 2016年9月23日
 *
 */
public class UserSeasonRaceRank {
	
	private Long userId;
	private String userName;
	private Integer score;
	private Integer level;
	private Long rank;
	private boolean isFread = true;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Long getRank() {
		return rank;
	}
	public void setRank(Long rank) {
		this.rank = rank;
	}
	public boolean isFread() {
		return isFread;
	}
	public void setFread(boolean isFread) {
		this.isFread = isFread;
	}
	
	

}
