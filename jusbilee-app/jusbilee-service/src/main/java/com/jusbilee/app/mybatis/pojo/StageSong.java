package com.jusbilee.app.mybatis.pojo;

import java.util.Date;

public class StageSong {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_stage_song.id
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_stage_song.song_id
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    private Integer songId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_stage_song.stage_level_id
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    private Integer stageLevelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_stage_song.pass_score
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    private Integer passScore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_stage_song.status
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_stage_song.create_time
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_stage_song.update_time
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_stage_song.id
     *
     * @return the value of t_stage_song.id
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_stage_song.id
     *
     * @param id the value for t_stage_song.id
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_stage_song.song_id
     *
     * @return the value of t_stage_song.song_id
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    public Integer getSongId() {
        return songId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_stage_song.song_id
     *
     * @param songId the value for t_stage_song.song_id
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_stage_song.stage_level_id
     *
     * @return the value of t_stage_song.stage_level_id
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    public Integer getStageLevelId() {
        return stageLevelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_stage_song.stage_level_id
     *
     * @param stageLevelId the value for t_stage_song.stage_level_id
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    public void setStageLevelId(Integer stageLevelId) {
        this.stageLevelId = stageLevelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_stage_song.pass_score
     *
     * @return the value of t_stage_song.pass_score
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    public Integer getPassScore() {
        return passScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_stage_song.pass_score
     *
     * @param passScore the value for t_stage_song.pass_score
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_stage_song.status
     *
     * @return the value of t_stage_song.status
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_stage_song.status
     *
     * @param status the value for t_stage_song.status
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_stage_song.create_time
     *
     * @return the value of t_stage_song.create_time
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_stage_song.create_time
     *
     * @param createTime the value for t_stage_song.create_time
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_stage_song.update_time
     *
     * @return the value of t_stage_song.update_time
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_stage_song.update_time
     *
     * @param updateTime the value for t_stage_song.update_time
     *
     * @mbg.generated Sun Aug 28 22:27:38 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}