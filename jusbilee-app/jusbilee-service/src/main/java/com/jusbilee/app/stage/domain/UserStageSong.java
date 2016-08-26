package com.jusbilee.app.stage.domain;

import java.io.Serializable;

/**
 * Created by Allen on 2016/8/24.
 */
public class UserStageSong implements Serializable {
    private Integer stageSongId;
    private Integer songId;
    private String name;
    private String description;
    private String iconUrl;
    private String opernScreenshotUrl;
    private String opernUrl;
    private String wavPlayUrl;
    private String midiPlayUrl;
    private Integer passScore;
    private Integer isPassed;
    private Integer score;
    private Integer actCount;

    public Integer getStageSongId() {
        return stageSongId;
    }

    public void setStageSongId(Integer stageSongId) {
        this.stageSongId = stageSongId;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getOpernScreenshotUrl() {
        return opernScreenshotUrl;
    }

    public void setOpernScreenshotUrl(String opernScreenshotUrl) {
        this.opernScreenshotUrl = opernScreenshotUrl;
    }

    public String getOpernUrl() {
        return opernUrl;
    }

    public void setOpernUrl(String opernUrl) {
        this.opernUrl = opernUrl;
    }

    public String getWavPlayUrl() {
        return wavPlayUrl;
    }

    public void setWavPlayUrl(String wavPlayUrl) {
        this.wavPlayUrl = wavPlayUrl;
    }

    public String getMidiPlayUrl() {
        return midiPlayUrl;
    }

    public void setMidiPlayUrl(String midiPlayUrl) {
        this.midiPlayUrl = midiPlayUrl;
    }

    public Integer getPassScore() {
        return passScore;
    }

    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }

    public Integer getIsPassed() {
        return isPassed;
    }

    public void setIsPassed(Integer isPassed) {
        this.isPassed = isPassed;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getActCount() {
        return actCount;
    }

    public void setActCount(Integer actCount) {
        this.actCount = actCount;
    }
}
