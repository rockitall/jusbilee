package com.jusbilee.app.admin.domain;

import com.jusbilee.app.utils.OnlineUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Allen on 2016/9/15.
 */
public class AdminRaceSeasonListItem implements Serializable {
    private String id;
    private String seasonName;
    private Date startTime;
    private Date endTime;
    private Date createTime;
    private Date updateTime;
    private Integer songCount;

    public Integer getSongCount() {
        return songCount;
    }

    public int getOnline() {
        return OnlineUtils.onlineStatus(startTime, endTime);
    }

    public void setSongCount(Integer songCount) {
        this.songCount = songCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
