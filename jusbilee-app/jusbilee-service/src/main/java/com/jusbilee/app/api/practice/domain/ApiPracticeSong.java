package com.jusbilee.app.api.practice.domain;

import com.rockit.core.Constants;

import java.io.Serializable;

/**
 * Created by Allen on 2016/9/10.
 */
public class ApiPracticeSong implements Serializable {
    private Integer songId;
    private Integer styleId;
    private Integer practiceSongId;
    private Integer unlockGoldCoin;
    private Byte passStageUnlock;

    public boolean isNeedUnlock() {
        return !(unlockGoldCoin == null || unlockGoldCoin <= 0 || passStageUnlock == null || passStageUnlock == Constants.BOOL.NO);
    }

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public Integer getPracticeSongId() {
        return practiceSongId;
    }

    public void setPracticeSongId(Integer practiceSongId) {
        this.practiceSongId = practiceSongId;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getUnlockGoldCoin() {
        return unlockGoldCoin;
    }

    public void setUnlockGoldCoin(Integer unlockGoldCoin) {
        this.unlockGoldCoin = unlockGoldCoin;
    }

    public Byte getPassStageUnlock() {
        return passStageUnlock;
    }

    public void setPassStageUnlock(Byte passStageUnlock) {
        this.passStageUnlock = passStageUnlock;
    }
}
