/**
 * zhandc 2016年9月2日
 */
package com.jusbilee.app.api.practice.request;

import javax.validation.constraints.NotNull;

/**
 * @author zhandc 2016年9月2日
 *
 */
public class UserPracticeRequest {
	
	 public static class practiceUnlockData {
	        @NotNull(message = "practiceSongId不能为空")
	        private Integer practiceSongId;

	        @NotNull(message = "goldCoin不能为空")
	        private Integer goldCoin;

			public Integer getPracticeSongId() {
				return practiceSongId;
			}

			public void setPracticeSongId(Integer practiceSongId) {
				this.practiceSongId = practiceSongId;
			}

			public Integer getGoldCoin() {
				return goldCoin;
			}

			public void setGoldCoin(Integer goldCoin) {
				this.goldCoin = goldCoin;
			}
	 } 
	 
	 public static class actLogData {
	        @NotNull(message = "practiceSongId不能为空")
	        private Integer practiceSongId;

	        @NotNull(message = "styleId不能为空")
	        private Integer styleId;

	        @NotNull(message = "practiceTime不能为空")
			private Integer practiceTime;
	        
	        @NotNull(message = "practiceScore不能为空")
	        private Integer practiceScore;
			
	        @NotNull(message = "bestTime不能为空")
	        private Integer bestTime;
	        
	        @NotNull(message = "avgScore不能为空")
	        private Integer avgScore;

			public Integer getPracticeSongId() {
				return practiceSongId;
			}

			public void setPracticeSongId(Integer practiceSongId) {
				this.practiceSongId = practiceSongId;
			}

			public Integer getStyleId() {
				return styleId;
			}

			public void setStyleId(Integer styleId) {
				this.styleId = styleId;
			}

			public Integer getPracticeTime() {
				return practiceTime;
			}

			public void setPracticeTime(Integer practiceTime) {
				this.practiceTime = practiceTime;
			}

			public Integer getPracticeScore() {
				return practiceScore;
			}

			public void setPracticeScore(Integer practiceScore) {
				this.practiceScore = practiceScore;
			}

			public Integer getBestTime() {
				return bestTime;
			}

			public void setBestTime(Integer bestTime) {
				this.bestTime = bestTime;
			}

			public Integer getAvgScore() {
				return avgScore;
			}

			public void setAvgScore(Integer avgScore) {
				this.avgScore = avgScore;
			}
	        
			
	        
	 } 

}
