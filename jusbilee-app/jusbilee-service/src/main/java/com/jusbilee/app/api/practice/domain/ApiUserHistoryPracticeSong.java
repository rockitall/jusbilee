package com.jusbilee.app.api.practice.domain;

import com.jusbilee.app.api.song.domain.ApiSong;

/**
 * Created by Allen on 2016/9/10.
 */
public class ApiUserHistoryPracticeSong extends ApiUserPracticeSummary {
    private ApiSong song;

    public ApiSong getSong() {
        return song;
    }

    public void setSong(ApiSong song) {
        this.song = song;
    }
}
