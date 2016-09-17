package com.jusbilee.app.admin.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Allen on 2016/9/15.
 */
public class AdminSongSubLevelListItem implements Serializable {
    private Integer id;
    private String subLevelName;
    private Integer levelId;
    private String levelName;
    private Integer score;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubLevelName() {
        return subLevelName;
    }

    public void setSubLevelName(String subLevelName) {
        this.subLevelName = subLevelName;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
