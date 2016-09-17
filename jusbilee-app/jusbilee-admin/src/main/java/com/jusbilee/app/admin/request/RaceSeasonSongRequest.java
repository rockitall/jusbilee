package com.jusbilee.app.admin.request;

import javax.validation.constraints.NotNull;

/**
 * Created by Allen on 2016/9/16.
 */
public class RaceSeasonSongRequest {
    @NotNull
    private Integer subLevelId;
    @NotNull
    private Integer[] songIdList;
    @NotNull
    private Integer seasonId;

    public Integer getSubLevelId() {
        return subLevelId;
    }

    public void setSubLevelId(Integer subLevelId) {
        this.subLevelId = subLevelId;
    }

    public Integer[] getSongIdList() {
        return songIdList;
    }

    public void setSongIdList(Integer[] songIdList) {
        this.songIdList = songIdList;
    }

    public Integer getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }
}
