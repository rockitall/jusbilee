package com.jusbilee.app.admin.request;

import com.rockit.core.constraints.annotation.DateTime;

import javax.validation.constraints.NotNull;

/**
 * Created by Allen on 2016/9/3.
 */
public class PracticeSongRequest {
    @NotNull
    private Integer songId;
    @NotNull
    private Integer songStyleId;
    @DateTime
    private String startTime;
    @DateTime
    private String endTime;
    @NotNull
    private Integer unlockGoldCoin;

    private boolean online;
    private boolean passStageUnlock;

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getSongStyleId() {
        return songStyleId;
    }

    public void setSongStyleId(Integer songStyleId) {
        this.songStyleId = songStyleId;
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

    public Integer getUnlockGoldCoin() {
        return unlockGoldCoin;
    }

    public void setUnlockGoldCoin(Integer unlockGoldCoin) {
        this.unlockGoldCoin = unlockGoldCoin;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isPassStageUnlock() {
        return passStageUnlock;
    }

    public void setPassStageUnlock(boolean passStageUnlock) {
        this.passStageUnlock = passStageUnlock;
    }
}
