/**
 * zhandc 2016年8月9日
 */
package com.jusbilee.app.admin.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhandc 2016年8月9日
 *
 */
public class Censorship {
	
	private long censorshipId;
	private String name; //关卡名字
	private String description; //描述
	private Date createTime; 
	private Date updateTime; 
	
	private long songId;
	private String songName;
	private int songStyle;
	
	private final SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * @return the censorshipId
	 */
	public long getCensorshipId() {
		return censorshipId;
	}

	/**
	 * @param censorshipId the censorshipId to set
	 */
	public void setCensorshipId(long censorshipId) {
		this.censorshipId = censorshipId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return this.createTime==null? "" : fmt.format(createTime);
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	/**
	 * @return the updateTime
	 */
	public String getUpdateTime() {
		return this.updateTime == null ? " " : fmt.format(updateTime);
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the songId
	 */
	public long getSongId() {
		return songId;
	}

	/**
	 * @param songId the songId to set
	 */
	public void setSongId(long songId) {
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
	 * @return the songStyle
	 */
	public int getSongStyle() {
		return songStyle;
	}

	/**
	 * @param songStyle the songStyle to set
	 */
	public void setSongStyle(int songStyle) {
		this.songStyle = songStyle;
	}

	
	
}
