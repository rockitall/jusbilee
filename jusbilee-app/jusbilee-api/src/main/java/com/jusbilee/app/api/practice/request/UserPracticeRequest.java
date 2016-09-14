/**
 * zhandc 2016年9月2日
 */
package com.jusbilee.app.api.practice.request;

import javax.validation.constraints.NotNull;

public class UserPracticeRequest {
    @NotNull(message = "songId不能为空")
    private Integer songId;

    @NotNull(message = "practiceTime不能为空")
    private Integer practiceTime;

    @NotNull(message = "practiceScore不能为空")
    private Integer practiceScore;

    @NotNull(message = "fullScoreBestTime不能为空")
    private Integer fullScoreBestTime;

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
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

    public Integer getFullScoreBestTime() {
        return fullScoreBestTime;
    }

    public void setFullScoreBestTime(Integer fullScoreBestTime) {
        this.fullScoreBestTime = fullScoreBestTime;
    }
}
