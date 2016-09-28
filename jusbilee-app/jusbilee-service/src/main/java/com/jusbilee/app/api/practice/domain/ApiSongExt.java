package com.jusbilee.app.api.practice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jusbilee.app.api.song.domain.ApiSong;
import com.rockit.core.Constants;

/**
 * Created by Allen on 2016/9/28.
 */
public class ApiSongExt extends ApiSong {
    private Integer unlockGoldCoin;
    private Byte passStageUnlock;
    private ApiUserPracticeSummary summary;

    public boolean getPassStageUnlock() {
        return passStageUnlock == Constants.BOOL.YES;
    }

    public boolean isNeedUnlock() {
        return !(unlockGoldCoin == null || unlockGoldCoin <= 0 || passStageUnlock == null || passStageUnlock == Constants.BOOL.NO);
    }

    public boolean isUnlocked() {
        return isNeedUnlock() && summary != null;
    }

    public ApiUserPracticeSummary getSummary() {
        return summary;
    }

    public void setSummary(ApiUserPracticeSummary summary) {
        this.summary = summary;
    }

    public Integer getUnlockGoldCoin() {
        return unlockGoldCoin;
    }

    public void setUnlockGoldCoin(Integer unlockGoldCoin) {
        this.unlockGoldCoin = unlockGoldCoin;
    }

    public void setPassStageUnlock(Byte passStageUnlock) {
        this.passStageUnlock = passStageUnlock;
    }
}
