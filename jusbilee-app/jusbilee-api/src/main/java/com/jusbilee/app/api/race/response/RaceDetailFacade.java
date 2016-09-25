/**
 * zhandc 2016年9月24日
 */
package com.jusbilee.app.api.race.response;

import com.jusbilee.app.api.song.domain.ApiSong;

/**
 * @author zhandc 2016年9月24日
 *
 */
public class RaceDetailFacade {
	
	 private ApiSong info;
	 private Long opponentId;
	public ApiSong getInfo() {
		return info;
	}
	public void setInfo(ApiSong info) {
		this.info = info;
	}
	public Long getOpponentId() {
		return opponentId;
	}
	public void setOpponentId(Long opponentId) {
		this.opponentId = opponentId;
	}
	 
	 

}
