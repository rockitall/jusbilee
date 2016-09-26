/**
 * zhandc 2016年9月23日
 */
package com.jusbilee.app.api.seasonRace.domain;

/**
 * @author zhandc 2016年9月23日
 *
 */
public class UserInfo {
	
	private Long userId;
	private String userName;
	private Integer level;
	private String avatar;
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
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
 
	
}
