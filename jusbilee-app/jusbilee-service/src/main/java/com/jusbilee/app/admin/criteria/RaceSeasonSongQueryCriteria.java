package com.jusbilee.app.admin.criteria;

/**
 * Created by Allen on 2016/9/15.
 */
public class RaceSeasonSongQueryCriteria {
    private Integer levelId;
    private String songName;
    private Integer seasonId;

    public Integer getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}
