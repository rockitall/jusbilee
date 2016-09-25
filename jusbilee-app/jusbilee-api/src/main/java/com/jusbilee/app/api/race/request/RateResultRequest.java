/**
 * zhandc 2016年9月25日
 */
package com.jusbilee.app.api.race.request;

import javax.validation.constraints.NotNull;

/**
 * @author zhandc 2016年9月25日
 *
 */
public class RateResultRequest {
	
	@NotNull(message = "winId不能为空")
	private Long winId;
	
	@NotNull(message = "lostId不能为空")
	private Long lostId;

	@NotNull(message = "songId不能为空")
	private Integer songId;

	public Long getWinId() {
		return winId;
	}

	public void setWinId(Long winId) {
		this.winId = winId;
	}

	public Long getLostId() {
		return lostId;
	}

	public void setLostId(Long lostId) {
		this.lostId = lostId;
	}

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}
	
	
}
