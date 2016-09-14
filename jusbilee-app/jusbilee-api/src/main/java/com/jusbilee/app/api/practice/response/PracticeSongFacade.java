package com.jusbilee.app.api.practice.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jusbilee.app.api.practice.domain.ApiPracticeSong;
import com.jusbilee.app.api.practice.domain.ApiUserPracticeSummary;
import com.jusbilee.app.api.song.domain.ApiSong;
import com.rockit.core.Constants;

/**
 * Created by Allen on 2016/9/10.
 */
public class PracticeSongFacade {
    @JsonIgnore
    private ApiSong info;
    @JsonIgnore
    private ApiPracticeSong ext;
    private ApiUserPracticeSummary summary;

    public void setInfo(ApiSong info) {
        this.info = info;
    }

    public void setExt(ApiPracticeSong ext) {
        this.ext = ext;
    }

    public void setSummary(ApiUserPracticeSummary summary) {
        this.summary = summary;
    }

    public Integer getStyleId() {
        return ext.getStyleId();
    }

    public boolean isUnlocked() {
        return this.ext.isNeedUnlock() && summary != null;
    }

    public Integer getSongId() {
        return info.getSongId();
    }

    public String getSongName() {
        return info.getSongName();
    }

    public String getDescription() {
        return info.getDescription();
    }

    public String getIconUrl() {
        return info.getIconUrl();
    }

    public String getWavPlayUrl() {
        return info.getWavPlayUrl();
    }

    public String getMidiPlayUrl() {
        return info.getMidiPlayUrl();
    }

    public boolean isNeedUnlock() {
        return ext.isNeedUnlock();
    }

    public Integer getUnlockGoldCoin() {
        return ext.getUnlockGoldCoin();
    }

    public boolean isPassStageUnlock() {
        return ext.getPassStageUnlock() == Constants.BOOL.YES;
    }

    public ApiUserPracticeSummary getSummary() {
        return summary;
    }
}
