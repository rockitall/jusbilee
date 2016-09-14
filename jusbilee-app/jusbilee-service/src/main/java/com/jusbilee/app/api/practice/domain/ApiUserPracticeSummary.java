package com.jusbilee.app.api.practice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class ApiUserPracticeSummary implements Serializable {
    @JsonIgnore
    private Long userId;
    @JsonIgnore
    private Integer songId;
    @JsonIgnore
    private Integer practiceSongId;

    private Integer totalPracticeTime;
    @JsonIgnore
    private Integer totalPracticeScore;
    @JsonIgnore
    private Integer totalPracticeCount;
    private Integer bestScore;
    private Integer fullScoreBestTime;

    public Integer getAvgScore() {
        return totalPracticeCount != 0 ? totalPracticeScore / totalPracticeCount : 0;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getPracticeSongId() {
        return practiceSongId;
    }

    public void setPracticeSongId(Integer practiceSongId) {
        this.practiceSongId = practiceSongId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTotalPracticeTime() {
        return totalPracticeTime;
    }

    public void setTotalPracticeTime(Integer totalPracticeTime) {
        this.totalPracticeTime = totalPracticeTime;
    }

    public Integer getTotalPracticeScore() {
        return totalPracticeScore;
    }

    public void setTotalPracticeScore(Integer totalPracticeScore) {
        this.totalPracticeScore = totalPracticeScore;
    }

    public Integer getTotalPracticeCount() {
        return totalPracticeCount;
    }

    public void setTotalPracticeCount(Integer totalPracticeCount) {
        this.totalPracticeCount = totalPracticeCount;
    }

    public Integer getBestScore() {
        return bestScore;
    }

    public void setBestScore(Integer bestScore) {
        this.bestScore = bestScore;
    }

    public Integer getFullScoreBestTime() {
        return fullScoreBestTime;
    }

    public void setFullScoreBestTime(Integer fullScoreBestTime) {
        this.fullScoreBestTime = fullScoreBestTime;
    }
}
