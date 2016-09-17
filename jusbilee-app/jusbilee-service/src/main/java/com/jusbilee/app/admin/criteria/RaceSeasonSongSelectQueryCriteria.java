package com.jusbilee.app.admin.criteria;

/**
 * Created by Allen on 2016/9/16.
 */
public class RaceSeasonSongSelectQueryCriteria {
    private Integer seasonId;
    private Integer levelId;
    private String songName;
    private String startTimeBegin;
    private String startTimeEnd;

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

    public String getStartTimeBegin() {
        return startTimeBegin;
    }

    public void setStartTimeBegin(String startTimeBegin) {
        this.startTimeBegin = startTimeBegin;
    }

    public String getStartTimeEnd() {
        return startTimeEnd;
    }

    public void setStartTimeEnd(String startTimeEnd) {
        this.startTimeEnd = startTimeEnd;
    }
}
