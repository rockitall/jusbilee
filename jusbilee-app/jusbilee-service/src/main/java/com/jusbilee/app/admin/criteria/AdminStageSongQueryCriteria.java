/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.admin.criteria;

public class AdminStageSongQueryCriteria {
    private String name;
    private Boolean online;
    private Integer stageLevelId;
    private String onlineStartTime;
    private String onlineEndTime;
    private Integer passScoreStart;
    private Integer passScoreEnd;
    private Integer sortOrder;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public String getOnlineEndTime() {
        return onlineEndTime;
    }

    public void setOnlineEndTime(String onlineEndTime) {
        this.onlineEndTime = onlineEndTime;
    }

    public String getOnlineStartTime() {
        return onlineStartTime;
    }

    public void setOnlineStartTime(String onlineStartTime) {
        this.onlineStartTime = onlineStartTime;
    }

    public Integer getPassScoreEnd() {
        return passScoreEnd;
    }

    public void setPassScoreEnd(Integer passScoreEnd) {
        this.passScoreEnd = passScoreEnd;
    }

    public Integer getPassScoreStart() {
        return passScoreStart;
    }

    public void setPassScoreStart(Integer passScoreStart) {
        this.passScoreStart = passScoreStart;
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
}
