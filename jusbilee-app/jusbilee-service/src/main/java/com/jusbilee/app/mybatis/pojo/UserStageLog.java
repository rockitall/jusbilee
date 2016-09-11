package com.jusbilee.app.mybatis.pojo;

import java.util.Date;

public class UserStageLog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_log.id
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_log.user_id
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_log.song_id
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Integer songId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_log.stage_song_id
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Integer stageSongId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_log.stage_level_id
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Integer stageLevelId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_log.is_assist
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Byte isAssist;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_log.assist_user_id
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Long assistUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_log.score
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Integer score;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_log.is_passed
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Byte isPassed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_log.create_time
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_log.id
     *
     * @return the value of t_user_stage_log.id
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_log.id
     *
     * @param id the value for t_user_stage_log.id
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_log.user_id
     *
     * @return the value of t_user_stage_log.user_id
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_log.user_id
     *
     * @param userId the value for t_user_stage_log.user_id
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_log.song_id
     *
     * @return the value of t_user_stage_log.song_id
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Integer getSongId() {
        return songId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_log.song_id
     *
     * @param songId the value for t_user_stage_log.song_id
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_log.stage_song_id
     *
     * @return the value of t_user_stage_log.stage_song_id
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Integer getStageSongId() {
        return stageSongId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_log.stage_song_id
     *
     * @param stageSongId the value for t_user_stage_log.stage_song_id
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setStageSongId(Integer stageSongId) {
        this.stageSongId = stageSongId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_log.stage_level_id
     *
     * @return the value of t_user_stage_log.stage_level_id
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Integer getStageLevelId() {
        return stageLevelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_log.stage_level_id
     *
     * @param stageLevelId the value for t_user_stage_log.stage_level_id
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setStageLevelId(Integer stageLevelId) {
        this.stageLevelId = stageLevelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_log.is_assist
     *
     * @return the value of t_user_stage_log.is_assist
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Byte getIsAssist() {
        return isAssist;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_log.is_assist
     *
     * @param isAssist the value for t_user_stage_log.is_assist
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setIsAssist(Byte isAssist) {
        this.isAssist = isAssist;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_log.assist_user_id
     *
     * @return the value of t_user_stage_log.assist_user_id
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Long getAssistUserId() {
        return assistUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_log.assist_user_id
     *
     * @param assistUserId the value for t_user_stage_log.assist_user_id
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setAssistUserId(Long assistUserId) {
        this.assistUserId = assistUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_log.score
     *
     * @return the value of t_user_stage_log.score
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Integer getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_log.score
     *
     * @param score the value for t_user_stage_log.score
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_log.is_passed
     *
     * @return the value of t_user_stage_log.is_passed
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Byte getIsPassed() {
        return isPassed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_log.is_passed
     *
     * @param isPassed the value for t_user_stage_log.is_passed
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setIsPassed(Byte isPassed) {
        this.isPassed = isPassed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_log.create_time
     *
     * @return the value of t_user_stage_log.create_time
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_log.create_time
     *
     * @param createTime the value for t_user_stage_log.create_time
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}