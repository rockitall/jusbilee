package com.jusbilee.app.mybatis.pojo;

import java.util.Date;

public class SongSubLevel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song_sub_level.id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song_sub_level.sub_level_name
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private String subLevelName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song_sub_level.level_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Integer levelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song_sub_level.score
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Integer score;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song_sub_level.is_deleted
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Byte isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song_sub_level.create_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song_sub_level.update_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song_sub_level.id
     *
     * @return the value of t_song_sub_level.id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song_sub_level.id
     *
     * @param id the value for t_song_sub_level.id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song_sub_level.sub_level_name
     *
     * @return the value of t_song_sub_level.sub_level_name
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public String getSubLevelName() {
        return subLevelName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song_sub_level.sub_level_name
     *
     * @param subLevelName the value for t_song_sub_level.sub_level_name
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setSubLevelName(String subLevelName) {
        this.subLevelName = subLevelName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song_sub_level.level_id
     *
     * @return the value of t_song_sub_level.level_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Integer getLevelId() {
        return levelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song_sub_level.level_id
     *
     * @param levelId the value for t_song_sub_level.level_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song_sub_level.score
     *
     * @return the value of t_song_sub_level.score
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Integer getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song_sub_level.score
     *
     * @param score the value for t_song_sub_level.score
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song_sub_level.is_deleted
     *
     * @return the value of t_song_sub_level.is_deleted
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song_sub_level.is_deleted
     *
     * @param isDeleted the value for t_song_sub_level.is_deleted
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song_sub_level.create_time
     *
     * @return the value of t_song_sub_level.create_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song_sub_level.create_time
     *
     * @param createTime the value for t_song_sub_level.create_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song_sub_level.update_time
     *
     * @return the value of t_song_sub_level.update_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song_sub_level.update_time
     *
     * @param updateTime the value for t_song_sub_level.update_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}