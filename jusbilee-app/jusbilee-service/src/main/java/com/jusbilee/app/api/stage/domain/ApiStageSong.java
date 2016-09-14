package com.jusbilee.app.api.stage.domain;

import java.io.Serializable;

/**
 * Created by Allen on 2016/8/24.
 */
public class ApiStageSong implements Serializable {
    private Integer stageSongId;
    private Integer songId;
    private Integer levelId;
    private Integer passScore;

    public Integer getStageSongId() {
        return stageSongId;
    }

    public void setStageSongId(Integer stageSongId) {
        this.stageSongId = stageSongId;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getPassScore() {
        return passScore;
    }

    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }
}
