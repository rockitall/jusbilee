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
public class UserPracticeActLogDomain implements Serializable{
	
	 @JsonIgnore
	private int totalPracticeTime;
	 @JsonIgnore
	private int totalPracticeCount;
	 @JsonIgnore
	private int totalPracticeScore;
	 @JsonIgnore
	private int fullScoreBestTime;
	 
	private String songName;
	private int bestAvgScore;	
	private int avgScore;
	private String practiceTime;
	private String bestTime;

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
	 * @return the totalPracticeTime
	 */
	public int getTotalPracticeTime() {
		return totalPracticeTime;
	}

	/**
	 * @param totalPracticeTime the totalPracticeTime to set
	 */
	public void setTotalPracticeTime(int totalPracticeTime) {
		this.totalPracticeTime = totalPracticeTime;
	}

	/**
	 * @return the fullScoreBestTime
	 */
	public int getFullScoreBestTime() {
		return fullScoreBestTime;
	}

	/**
	 * @param fullScoreBestTime the fullScoreBestTime to set
	 */
	public void setFullScoreBestTime(int fullScoreBestTime) {
		this.fullScoreBestTime = fullScoreBestTime;
	}

	/**
	 * @return the totalPracticeCount
	 */
	public int getTotalPracticeCount() {
		return totalPracticeCount;
	}

	/**
	 * @param totalPracticeCount the totalPracticeCount to set
	 */
	public void setTotalPracticeCount(int totalPracticeCount) {
		this.totalPracticeCount = totalPracticeCount;
	}

	

	/**
	 * @return the practiceTime
	 */
	public String getPracticeTime() {
		if (totalPracticeTime <= 0) {
            return "0分钟";
        }
        String text = "";
        int h = (totalPracticeTime / 3600);
        if (h > 0) {
            text += (h + "小时");
        }

        int f = (totalPracticeTime - h * 3600) / 60;
        text += (f + "分钟");
        return text;
	}

	/**
	 * @param practiceTime the practiceTime to set
	 */
	public void setPracticeTime(String practiceTime) {
		this.practiceTime = practiceTime;
	}

	/**
	 * @return the bestAvgScore
	 */
	public int getBestAvgScore() {
		return bestAvgScore;
	}

	/**
	 * @param bestAvgScore the bestAvgScore to set
	 */
	public void setBestAvgScore(int bestAvgScore) {
		this.bestAvgScore = bestAvgScore;
	}

	/**
	 * @return the avgScore
	 */
	public int getAvgScore() {
		if (totalPracticeScore <= 0 || totalPracticeCount <= 0) {
            return 0;
        }
        return totalPracticeScore / totalPracticeCount;
	}

	/**
	 * @param avgScore the avgScore to set
	 */
	public void setAvgScore(int avgScore) {
		this.avgScore = avgScore;
	}

	/**
	 * @return the totalPracticeScore
	 */
	public int getTotalPracticeScore() {
		return totalPracticeScore;
	}

	/**
	 * @param totalPracticeScore the totalPracticeScore to set
	 */
	public void setTotalPracticeScore(int totalPracticeScore) {
		this.totalPracticeScore = totalPracticeScore;
	}

	/**
	 * @return the bestTime
	 */
	public String getBestTime() {
		if (fullScoreBestTime <= 0) {
            return "0分钟";
        }
        String text = "";
        int h = (fullScoreBestTime / 3600);
        if (h > 0) {
            text += (h + "小时 ");
        }

        int f = (fullScoreBestTime - h * 3600) / 60;
        if( f > 0){
        	 text += (f + "分钟 ");
        }
       
        int m = fullScoreBestTime - h * 3600 - f * 60;
        if(m > 0){
        	 text += (m + "秒");	
        }
       
        return text;
	}

	/**
	 * @param bestTime the bestTime to set
	 */
	public void setBestTime(String bestTime) {
		this.bestTime = bestTime;
	}

	
	
	
}
