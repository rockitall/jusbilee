/**
 * zhandc 2016年9月22日
 */
package com.jusbilee.app.api.race.domain;

/**
 * @author zhandc 2016年9月22日
 *
 */
public class UserSeasonRaceSummaryDomain {

	private Integer bestScore;
	private Integer winCount;
	private Integer winStreak;
	

	public Integer getBestScore() {
		return bestScore;
	}
	public void setBestScore(Integer bestScore) {
		this.bestScore = bestScore;
	}
	public Integer getWinCount() {
		return winCount;
	}
	public void setWinCount(Integer winCount) {
		this.winCount = winCount;
	}
	public Integer getWinStreak() {
		return winStreak;
	}
	public void setWinStreak(Integer winStreak) {
		this.winStreak = winStreak;
	}
	
	
}
