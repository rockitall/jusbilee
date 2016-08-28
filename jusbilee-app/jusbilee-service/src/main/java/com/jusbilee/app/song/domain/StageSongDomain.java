/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.song.domain;

import java.util.Date;

/**
 * @author zhandc 2016年8月28日
 *
 */
public class StageSongDomain {
	private Long id;
	private Integer songId;
	private String songName;
	private Integer stageLevelId;
	private String stageName;
	private Integer passScore;
	private Date createTime;
	
	
	/**
	 * @return the songId
	 */
	public Integer getSongId() {
		return songId;
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
	/**
	 * @param songId the songId to set
	 */
	public void setSongId(Integer songId) {
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
	 * @return the stageLevelId
	 */
	public Integer getStageLevelId() {
		return stageLevelId;
	}
	/**
	 * @param stageLevelId the stageLevelId to set
	 */
	public void setStageLevelId(Integer stageLevelId) {
		this.stageLevelId = stageLevelId;
	}
	/**
	 * @return the stageName
	 */
	public String getStageName() {
		return stageName;
	}
	/**
	 * @param stageName the stageName to set
	 */
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	/**
	 * @return the passScore
	 */
	public Integer getPassScore() {
		return passScore;
	}
	/**
	 * @param passScore the passScore to set
	 */
	public void setPassScore(Integer passScore) {
		this.passScore = passScore;
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

	
}
