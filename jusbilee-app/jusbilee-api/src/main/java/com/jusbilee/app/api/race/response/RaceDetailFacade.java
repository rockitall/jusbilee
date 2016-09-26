/**
 * zhandc 2016年9月24日
 */
package com.jusbilee.app.api.race.response;

import com.jusbilee.app.api.seasonRace.domain.UserInfo;
import com.jusbilee.app.api.song.domain.ApiSong;

/**
 * @author zhandc 2016年9月24日
 *
 */
public class RaceDetailFacade {

	private ApiSong songInfo;
	private UserInfo userInfo;

	public ApiSong getSongInfo() {
		return songInfo;
	}

	public void setSongInfo(ApiSong songInfo) {
		this.songInfo = songInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
