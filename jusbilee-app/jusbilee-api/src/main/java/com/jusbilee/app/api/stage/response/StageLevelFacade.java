package com.jusbilee.app.api.stage.response;

import com.jusbilee.app.api.stage.domain.ApiSongLevel;
import com.jusbilee.app.api.stage.domain.ApiLevelStageSongCount;

/**
 * Created by Allen on 2016/9/10.
 */
public class StageLevelFacade {
    private ApiSongLevel level;
    private ApiLevelStageSongCount levelTotalCount;
    private ApiLevelStageSongCount userPassedCount;

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

    public void setLevel(ApiSongLevel level) {
        this.level = level;
    }

    public void setLevelTotalCount(ApiLevelStageSongCount levelTotalCount) {
        this.levelTotalCount = levelTotalCount;
    }

    public void setUserPassedCount(ApiLevelStageSongCount userPassedCount) {
        this.userPassedCount = userPassedCount;
    }
}
