package com.jusbilee.app.api.stage.response;

import com.jusbilee.app.api.stage.domain.ApiStageLevel;
import com.jusbilee.app.api.stage.domain.ApiStageLevelSongCount;

/**
 * Created by Allen on 2016/9/10.
 */
public class StageLevelFacade {
    private ApiStageLevel level;
    private ApiStageLevelSongCount levelTotalCount;
    private ApiStageLevelSongCount userPassedCount;

    public Integer getTotal() {
        return levelTotalCount != null ? levelTotalCount.getSongCount() : 0;
    }

    public Integer getPassed() {
        return userPassedCount != null ? userPassedCount.getSongCount() : 0;
    }

    public String getLevelName() {
        return level.getLevelName();
    }

    public Integer getLevelId() {
        return level.getLevelId();
    }

    public void setLevel(ApiStageLevel level) {
        this.level = level;
    }

    public void setLevelTotalCount(ApiStageLevelSongCount levelTotalCount) {
        this.levelTotalCount = levelTotalCount;
    }

    public void setUserPassedCount(ApiStageLevelSongCount userPassedCount) {
        this.userPassedCount = userPassedCount;
    }
}
