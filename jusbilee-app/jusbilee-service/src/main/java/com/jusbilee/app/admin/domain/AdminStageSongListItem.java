/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.admin.domain;

import com.jusbilee.app.utils.OnlineUtils;

import java.io.Serializable;
import java.util.Date;

public class AdminStageSongListItem implements Serializable {
    private Long id;
    private Integer songId;
    private String name;
    private Integer stageLevelId;
    private String stageLevelName;
    private Byte status;
    private Integer passScore;
    private Integer sortOrder;
    private Date startTime;
    private Date endTime;
    private Date createTime;
    private Date updateTime;

    public int getOnline() {
        if (status == 0) {
            return OnlineUtils.onlineStatus(startTime, endTime);
        }
        return 0;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPassScore() {
        return passScore;
    }

    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getStageLevelId() {
        return stageLevelId;
    }

    public void setStageLevelId(Integer stageLevelId) {
        this.stageLevelId = stageLevelId;
    }

    public String getStageLevelName() {
        return stageLevelName;
    }

    public void setStageLevelName(String stageLevelName) {
        this.stageLevelName = stageLevelName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
