package com.jusbilee.app.api.stage.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jusbilee.app.api.song.domain.ApiSong;
import com.jusbilee.app.api.stage.domain.ApiStageSong;
import com.jusbilee.app.api.stage.domain.ApiUserStageSummary;
import com.rockit.core.Constants.BOOL;

/**
 * Created by Allen on 2016/9/10.
 */
public class StageSongFacade {
    @JsonIgnore
    private ApiSong info;
    @JsonIgnore
    private ApiStageSong ext;

    private ApiUserStageSummary summary;

    public Integer getPassScore() {
        return ext.getPassScore();
    }

    public ApiUserStageSummary getSummary() {
        return summary;
    }

    public Integer getSongId() {
        return info.getSongId();
    }

    public Boolean isPassed() {
        return summary != null && BOOL.YES == summary.getPassed();
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

    public void setInfo(ApiSong info) {
        this.info = info;
    }

    public void setExt(ApiStageSong ext) {
        this.ext = ext;
    }

    public void setSummary(ApiUserStageSummary summary) {
        this.summary = summary;
    }
}
