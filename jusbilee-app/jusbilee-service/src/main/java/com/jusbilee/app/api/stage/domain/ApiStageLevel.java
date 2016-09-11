package com.jusbilee.app.api.stage.domain;

import java.io.Serializable;

/**
 * Created by Allen on 2016/8/24.
 */
public class ApiStageLevel implements Serializable {
    private Integer levelId;
    private String levelName;

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }
}
