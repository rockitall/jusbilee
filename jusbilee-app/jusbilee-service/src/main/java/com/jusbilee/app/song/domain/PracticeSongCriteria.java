/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.song.domain;

import com.rockit.core.pojo.Pager;

/**
 * @author zhandc 2016年8月28日
 *
 */
public class PracticeSongCriteria extends Pager<PracticeSong>{
	
	private Integer styleId;
	private String songName;
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
