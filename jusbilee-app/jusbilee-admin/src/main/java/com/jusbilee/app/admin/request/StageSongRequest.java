package com.jusbilee.app.admin.request;

import com.rockit.core.constraints.annotation.DateTime;

import javax.validation.constraints.NotNull;

/**
 * Created by Allen on 2016/9/3.
 */
public class StageSongRequest {
    @NotNull
    private Integer songId;
    @NotNull
    private Integer stageLevelId;
    @DateTime
    private String startTime;
    @DateTime
    private String endTime;
    @NotNull
    private Integer passScore;
    @NotNull
    private Integer sortOrder;

    private boolean online;

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getStageLevelId() {
        return stageLevelId;
    }

    public void setStageLevelId(Integer stageLevelId) {
        this.stageLevelId = stageLevelId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getPassScore() {
        return passScore;
    }

    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
}
