package com.jusbilee.app.admin.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Allen on 2016/9/3.
 */
public class AdminSongListItem implements Serializable {
    private Integer id;
    private String name;
    private String iconUrl;
    private String screenshotUrl;
    private String opernUrl;
    private String wavUrl;
    private String midiUrl;
    private Integer practiceSongId;
    private Integer stageSongId;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getScreenshotUrl() {
        return screenshotUrl;
    }

    public void setScreenshotUrl(String screenshotUrl) {
        this.screenshotUrl = screenshotUrl;
    }

    public String getOpernUrl() {
        return opernUrl;
    }

    public void setOpernUrl(String opernUrl) {
        this.opernUrl = opernUrl;
    }

    public String getWavUrl() {
        return wavUrl;
    }

    public void setWavUrl(String wavUrl) {
        this.wavUrl = wavUrl;
    }

    public String getMidiUrl() {
        return midiUrl;
    }

    public void setMidiUrl(String midiUrl) {
        this.midiUrl = midiUrl;
    }

    public Integer getPracticeSongId() {
        return practiceSongId;
    }

    public void setPracticeSongId(Integer practiceSongId) {
        this.practiceSongId = practiceSongId;
    }

    public Integer getStageSongId() {
        return stageSongId;
    }

    public void setStageSongId(Integer stageSongId) {
        this.stageSongId = stageSongId;
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
