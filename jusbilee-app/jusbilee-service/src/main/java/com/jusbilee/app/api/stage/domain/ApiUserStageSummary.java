package com.jusbilee.app.api.stage.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * Created by Allen on 2016/9/10.
 */
public class ApiUserStageSummary implements Serializable {
    @JsonIgnore
    private Integer songId;
    @JsonIgnore
    private Byte passed;
    private Integer score;
    private Integer stageCount;


    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Byte getPassed() {
        return passed;
    }

    public void setPassed(Byte passed) {
        this.passed = passed;
    }

    public Integer getStageCount() {
        return stageCount;
    }

    public void setStageCount(Integer stageCount) {
        this.stageCount = stageCount;
    }
}
