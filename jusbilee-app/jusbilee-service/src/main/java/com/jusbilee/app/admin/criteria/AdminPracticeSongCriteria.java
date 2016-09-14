/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.admin.criteria;


public class AdminPracticeSongCriteria {
    private String name;
    private Boolean online;
    private Integer styleId;
    private String onlineStartTime;
    private String onlineEndTime;
    private Integer unlockGoldCoinStart;
    private Integer unlockGoldCoinEnd;
    private Boolean passStageUnlock;

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

    public Boolean getPassStageUnlock() {
        return passStageUnlock;
    }

    public void setPassStageUnlock(Boolean passStageUnlock) {
        this.passStageUnlock = passStageUnlock;
    }

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public Integer getUnlockGoldCoinEnd() {
        return unlockGoldCoinEnd;
    }

    public void setUnlockGoldCoinEnd(Integer unlockGoldCoinEnd) {
        this.unlockGoldCoinEnd = unlockGoldCoinEnd;
    }

    public Integer getUnlockGoldCoinStart() {
        return unlockGoldCoinStart;
    }

    public void setUnlockGoldCoinStart(Integer unlockGoldCoinStart) {
        this.unlockGoldCoinStart = unlockGoldCoinStart;
    }
}
