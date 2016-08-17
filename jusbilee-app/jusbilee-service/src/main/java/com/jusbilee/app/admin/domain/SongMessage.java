/**
 * zhandc 2016年8月16日
 */
package com.jusbilee.app.admin.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhandc 2016年8月16日
 *
 */
public class SongMessage {

	private Long songId;
	private Long userId;
	private String songName;
	private Integer levelId;
	private String levelName;
	private Integer checkStatus;
	private String checkLog;
	private String styleName;
	private String styleId;
	private Integer songStatus;
	private String songDescription;
	private String songIcon;
	private String songScore;
	private String songMidiFile;
	private String songWavFile;
	private Date createTime;
	
	private SimpleDateFormat dfm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

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
	 * @return the checkLog
	 */
	public String getCheckLog() {
		return checkLog;
	}

	/**
	 * @param checkLog the checkLog to set
	 */
	public void setCheckLog(String checkLog) {
		this.checkLog = checkLog;
	}

	
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
	 * @return the songStatus
	 */
	public Integer getSongStatus() {
		return songStatus;
	}

	/**
	 * @param songStatus the songStatus to set
	 */
	public void setSongStatus(Integer songStatus) {
		this.songStatus = songStatus;
	}

	/**
	 * @return the songDescription
	 */
	public String getSongDescription() {
		return songDescription;
	}

	/**
	 * @param songDescription the songDescription to set
	 */
	public void setSongDescription(String songDescription) {
		this.songDescription = songDescription;
	}

	/**
	 * @return the songIcon
	 */
	public String getSongIcon() {
		return songIcon;
	}

	/**
	 * @param songIcon the songIcon to set
	 */
	public void setSongIcon(String songIcon) {
		this.songIcon = songIcon;
	}

	/**
	 * @return the songScore
	 */
	public String getSongScore() {
		return songScore;
	}

	/**
	 * @param songScore the songScore to set
	 */
	public void setSongScore(String songScore) {
		this.songScore = songScore;
	}

	/**
	 * @return the songMidiFile
	 */
	public String getSongMidiFile() {
		return songMidiFile;
	}

	/**
	 * @param songMidiFile the songMidiFile to set
	 */
	public void setSongMidiFile(String songMidiFile) {
		this.songMidiFile = songMidiFile;
	}

	/**
	 * @return the songWavFile
	 */
	public String getSongWavFile() {
		return songWavFile;
	}

	/**
	 * @param songWavFile the songWavFile to set
	 */
	public void setSongWavFile(String songWavFile) {
		this.songWavFile = songWavFile;
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

	/**
	 * @return the styleId
	 */
	public String getStyleId() {
		return styleId;
	}

	/**
	 * @param styleId the styleId to set
	 */
	public void setStyleId(String styleId) {
		this.styleId = styleId;
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
	
	
}
