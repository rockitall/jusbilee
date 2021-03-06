package com.jusbilee.app.mybatis.pojo;

import java.util.Date;

public class RaceSeasonSong {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_race_season_song.id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_race_season_song.season_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Integer seasonId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_race_season_song.song_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Integer songId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_race_season_song.level_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Integer levelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_race_season_song.sub_level_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Integer subLevelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_race_season_song.is_deleted
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Byte isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_race_season_song.create_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_race_season_song.update_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_race_season_song.id
     *
     * @return the value of t_race_season_song.id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_race_season_song.id
     *
     * @param id the value for t_race_season_song.id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_race_season_song.season_id
     *
     * @return the value of t_race_season_song.season_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Integer getSeasonId() {
        return seasonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_race_season_song.season_id
     *
     * @param seasonId the value for t_race_season_song.season_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_race_season_song.song_id
     *
     * @return the value of t_race_season_song.song_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Integer getSongId() {
        return songId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_race_season_song.song_id
     *
     * @param songId the value for t_race_season_song.song_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_race_season_song.level_id
     *
     * @return the value of t_race_season_song.level_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Integer getLevelId() {
        return levelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_race_season_song.level_id
     *
     * @param levelId the value for t_race_season_song.level_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_race_season_song.sub_level_id
     *
     * @return the value of t_race_season_song.sub_level_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Integer getSubLevelId() {
        return subLevelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_race_season_song.sub_level_id
     *
     * @param subLevelId the value for t_race_season_song.sub_level_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setSubLevelId(Integer subLevelId) {
        this.subLevelId = subLevelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_race_season_song.is_deleted
     *
     * @return the value of t_race_season_song.is_deleted
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_race_season_song.is_deleted
     *
     * @param isDeleted the value for t_race_season_song.is_deleted
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_race_season_song.create_time
     *
     * @return the value of t_race_season_song.create_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_race_season_song.create_time
     *
     * @param createTime the value for t_race_season_song.create_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_race_season_song.update_time
     *
     * @return the value of t_race_season_song.update_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_race_season_song.update_time
     *
     * @param updateTime the value for t_race_season_song.update_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}