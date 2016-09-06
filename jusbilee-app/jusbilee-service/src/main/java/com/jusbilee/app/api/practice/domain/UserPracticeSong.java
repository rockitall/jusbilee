/**
 * zhandc 2016年9月2日
 */
package com.jusbilee.app.api.practice.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author zhandc 2016年9月2日
 *
 */
public class UserPracticeSong implements Serializable{

	
	@JsonIgnore
	private int totalPracticeScore;
	private int totalPracticeCount;
	private int bestAvgScore;
	private int avgScore;

	private String songName;
	private String description;
	private String iconUrl;
	private String opernScreenshotUrl;
	private String opernUrl;
	private String wavPlayUrl;
	private String midiPlayUrl;
	
	private int unlockGoldCoin;
	private int practiceSongId;
	
	private String isNeedLock;

	public int getTotalPracticeScore() {
		return totalPracticeScore;
	}

	public void setTotalPracticeScore(int totalPracticeScore) {
		this.totalPracticeScore = totalPracticeScore;
	}

	public int getTotalPracticeCount() {
		return totalPracticeCount;
	}

	public void setTotalPracticeCount(int totalPracticeCount) {
		this.totalPracticeCount = totalPracticeCount;
	}

	public int getBestAvgScore() {
		return bestAvgScore;
	}

	public void setBestAvgScore(int bestAvgScore) {
		this.bestAvgScore = bestAvgScore;
	}

	public int getAvgScore() {
		if (totalPracticeScore <= 0 || totalPracticeCount <= 0) {
            return 0;
        }
        return totalPracticeScore / totalPracticeCount;
	}

	public void setAvgScore(int avgScore) {
		this.avgScore = avgScore;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getOpernScreenshotUrl() {
		return opernScreenshotUrl;
	}

	public void setOpernScreenshotUrl(String opernScreenshotUrl) {
		this.opernScreenshotUrl = opernScreenshotUrl;
	}

	public String getOpernUrl() {
		return opernUrl;
	}

	public void setOpernUrl(String opernUrl) {
		this.opernUrl = opernUrl;
	}

	public String getWavPlayUrl() {
		return wavPlayUrl;
	}

	public void setWavPlayUrl(String wavPlayUrl) {
		this.wavPlayUrl = wavPlayUrl;
	}

	public String getMidiPlayUrl() {
		return midiPlayUrl;
	}

	public void setMidiPlayUrl(String midiPlayUrl) {
		this.midiPlayUrl = midiPlayUrl;
	}

	

	public int getUnlockGoldCoin() {
		return unlockGoldCoin;
	}

	public void setUnlockGoldCoin(int unlockGoldCoin) {
		this.unlockGoldCoin = unlockGoldCoin;
	}

	public String getIsNeedLock() {
		return isNeedLock;
	}

	public void setIsNeedLock(String isNeedLock) {
		this.isNeedLock = isNeedLock;
	}

	public int getPracticeSongId() {
		return practiceSongId;
	}

	public void setPracticeSongId(int practiceSongId) {
		this.practiceSongId = practiceSongId;
	}
	
	

}
