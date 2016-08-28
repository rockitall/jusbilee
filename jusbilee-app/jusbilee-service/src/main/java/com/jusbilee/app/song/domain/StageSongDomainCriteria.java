/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.song.domain;

import com.rockit.core.pojo.Pager;

/**
 * @author zhandc 2016年8月28日
 *
 */
public class StageSongDomainCriteria extends Pager<StageSongDomain>{

	private String songName;
	private Integer stageId;
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
	 * @return the stageId
	 */
	public Integer getStageId() {
		return stageId;
	}
	/**
	 * @param stageId the stageId to set
	 */
	public void setStageId(Integer stageId) {
		this.stageId = stageId;
	}
	
	
}
