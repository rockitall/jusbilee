package com.jusbilee.app.admin.domain;

import java.util.Date;

/**
 * Created by Allen on 2016/9/16.
 */
public class AdminRaceSeasonSongListItem {
    private Integer id;
    private Integer songId;
    private Integer levelId;
    private Integer subLevelId;
    private String levelName;
    private String subLevelName;
    private String songName;
    private String iconUrl;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSubLevelId() {
        return subLevelId;
    }

    public void setSubLevelId(Integer subLevelId) {
        this.subLevelId = subLevelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getSubLevelName() {
        return subLevelName;
    }

    public void setSubLevelName(String subLevelName) {
        this.subLevelName = subLevelName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
