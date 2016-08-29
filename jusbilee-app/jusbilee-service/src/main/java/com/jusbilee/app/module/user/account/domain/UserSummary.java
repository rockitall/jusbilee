package com.jusbilee.app.module.user.account.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * Created by Allen on 2016/8/25.
 */
public class UserSummary implements Serializable {
    @JsonIgnore
    private int totalPracticeTime;
    @JsonIgnore
    private int matchCount;
    @JsonIgnore
    private int matchWinCount;
    @JsonIgnore
    private int totalPracticeScore;
    @JsonIgnore
    private int totalPracticeCount;
    private int totalGoldCoin;
    private int unlockPracticeSongCount;
    private int totalPracticeSongCount;
    private String lastPracticeTime;

    public int getTotalGoldCoin() {
        return totalGoldCoin;
    }

    public int getAvgScore() {
        if (totalPracticeScore <= 0 || totalPracticeCount <= 0) {
            return 0;
        }
        return totalPracticeScore / totalPracticeCount;
    }

    public void setTotalGoldCoin(int totalGoldCoin) {
        this.totalGoldCoin = totalGoldCoin;
    }

    public String getPracticeTime() {
        if (totalPracticeTime <= 0) {
            return "0分钟";
        }
        String text = "";
        int h = (totalPracticeTime / 3600);
        if (h > 0) {
            text += (h + "小时");
        }

        int f = (totalPracticeTime - h * 3600) / 60;
        text += (f + "分钟");
        return text;
    }

    public String getMatchWinRatio() {
        if (matchCount <= 0 || matchWinCount <= 0) {
            return "0%";
        }
        return ((matchWinCount * 100) / matchCount) + "%";
    }

    public int getTotalPracticeSongCount() {
        return totalPracticeSongCount;
    }

    public void setTotalPracticeSongCount(int totalPracticeSongCount) {
        this.totalPracticeSongCount = totalPracticeSongCount;
    }

    public int getTotalPracticeTime() {
        return totalPracticeTime;
    }

    public void setTotalPracticeTime(int totalPracticeTime) {
        this.totalPracticeTime = totalPracticeTime;
    }

    public int getTotalPracticeScore() {
        return totalPracticeScore;
    }

    public void setTotalPracticeScore(int totalPracticeScore) {
        this.totalPracticeScore = totalPracticeScore;
    }

    public int getTotalPracticeCount() {
        return totalPracticeCount;
    }

    public void setTotalPracticeCount(int totalPracticeCount) {
        this.totalPracticeCount = totalPracticeCount;
    }

    public int getUnlockPracticeSongCount() {
        return unlockPracticeSongCount;
    }

    public void setUnlockPracticeSongCount(int unlockPracticeSongCount) {
        this.unlockPracticeSongCount = unlockPracticeSongCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getMatchWinCount() {
        return matchWinCount;
    }

    public void setMatchWinCount(int matchWinCount) {
        this.matchWinCount = matchWinCount;
    }

    public String getLastPracticeTime() {
        return lastPracticeTime;
    }

    public void setLastPracticeTime(String lastPracticeTime) {
        this.lastPracticeTime = lastPracticeTime;
    }
}
