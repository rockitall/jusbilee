package com.jusbilee.app.mybatis.pojo;

import java.util.Date;

public class Song {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song.id
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song.name
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song.description
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song.icon_url
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    private String iconUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song.opern_screenshot_url
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    private String opernScreenshotUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song.opern_url
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    private String opernUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song.wav_play_url
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    private String wavPlayUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song.midi_play_url
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    private String midiPlayUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song.is_deleted
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    private Byte isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song.create_time
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song.update_time
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song.id
     *
     * @return the value of t_song.id
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song.id
     *
     * @param id the value for t_song.id
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song.name
     *
     * @return the value of t_song.name
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song.name
     *
     * @param name the value for t_song.name
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song.description
     *
     * @return the value of t_song.description
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song.description
     *
     * @param description the value for t_song.description
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song.icon_url
     *
     * @return the value of t_song.icon_url
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song.icon_url
     *
     * @param iconUrl the value for t_song.icon_url
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song.opern_screenshot_url
     *
     * @return the value of t_song.opern_screenshot_url
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public String getOpernScreenshotUrl() {
        return opernScreenshotUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song.opern_screenshot_url
     *
     * @param opernScreenshotUrl the value for t_song.opern_screenshot_url
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public void setOpernScreenshotUrl(String opernScreenshotUrl) {
        this.opernScreenshotUrl = opernScreenshotUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song.opern_url
     *
     * @return the value of t_song.opern_url
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public String getOpernUrl() {
        return opernUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song.opern_url
     *
     * @param opernUrl the value for t_song.opern_url
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public void setOpernUrl(String opernUrl) {
        this.opernUrl = opernUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song.wav_play_url
     *
     * @return the value of t_song.wav_play_url
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public String getWavPlayUrl() {
        return wavPlayUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song.wav_play_url
     *
     * @param wavPlayUrl the value for t_song.wav_play_url
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public void setWavPlayUrl(String wavPlayUrl) {
        this.wavPlayUrl = wavPlayUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song.midi_play_url
     *
     * @return the value of t_song.midi_play_url
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public String getMidiPlayUrl() {
        return midiPlayUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song.midi_play_url
     *
     * @param midiPlayUrl the value for t_song.midi_play_url
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public void setMidiPlayUrl(String midiPlayUrl) {
        this.midiPlayUrl = midiPlayUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song.is_deleted
     *
     * @return the value of t_song.is_deleted
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song.is_deleted
     *
     * @param isDeleted the value for t_song.is_deleted
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song.create_time
     *
     * @return the value of t_song.create_time
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song.create_time
     *
     * @param createTime the value for t_song.create_time
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song.update_time
     *
     * @return the value of t_song.update_time
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song.update_time
     *
     * @param updateTime the value for t_song.update_time
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}