package com.jusbilee.app.api.stage.domain;

import java.io.Serializable;

/**
 * Created by Allen on 2016/9/10.
 */
public class ApiLevelStageSongCount implements Serializable {
    private Integer levelId;
    private Integer songCount;

    public Integer getSongCount() {
        return songCount;
    }

    public void setSongCount(Integer songCount) {
        this.songCount = songCount;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

}
