package com.jusbilee.app.api.practice.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jusbilee.app.api.practice.domain.ApiUserPracticeSummary;
import com.jusbilee.app.api.song.domain.ApiSong;

/**
 * Created by Allen on 2016/9/10.
 */
public class PracticeLogSongFacade {
    @JsonIgnore
    private ApiSong info;
    private ApiUserPracticeSummary summary;

    public void setSummary(ApiUserPracticeSummary summary) {
        this.summary = summary;
    }

    public void setInfo(ApiSong info) {
        this.info = info;
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

    public ApiUserPracticeSummary getSummary() {
        return summary;
    }
}
