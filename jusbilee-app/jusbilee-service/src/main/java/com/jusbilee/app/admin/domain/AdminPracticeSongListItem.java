/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.admin.domain;

import java.io.Serializable;
import java.util.Date;

public class AdminPracticeSongListItem implements Serializable {
    private Long id;
    private Integer songId;
    private String name;
    private Integer songStyleId;
    private String songStyleName;
    private Integer unlockGoldCoin;
    private Date startTime;
    private Date endTime;
    private Byte passStageUnlock;
    private Byte status;
    private Date createTime;
    private Date updateTime;

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUnlockGoldCoin() {
        return unlockGoldCoin;
    }

    public void setUnlockGoldCoin(Integer unlockGoldCoin) {
        this.unlockGoldCoin = unlockGoldCoin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getPassStageUnlock() {
        return passStageUnlock;
    }

    public void setPassStageUnlock(Byte passStageUnlock) {
        this.passStageUnlock = passStageUnlock;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getSongStyleId() {
        return songStyleId;
    }

    public void setSongStyleId(Integer songStyleId) {
        this.songStyleId = songStyleId;
    }

    public String getSongStyleName() {
        return songStyleName;
    }

    public void setSongStyleName(String songStyleName) {
        this.songStyleName = songStyleName;
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
