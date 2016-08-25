package com.jusbilee.app.mybatis.pojo;

import java.util.Date;

public class UserStageActLog {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_act_log.id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_act_log.user_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_act_log.stage_song_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Integer stageSongId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_act_log.stage_level_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Integer stageLevelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_act_log.is_assist
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Byte isAssist;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_act_log.assist_user_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Long assistUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_act_log.score
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Integer score;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_act_log.is_passed
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Byte isPassed;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_act_log.act_count
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Integer actCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_act_log.is_deleted
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Byte isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_act_log.create_time
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_stage_act_log.update_time
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_act_log.id
     *
     * @return the value of t_user_stage_act_log.id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_act_log.id
     *
     * @param id the value for t_user_stage_act_log.id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_act_log.user_id
     *
     * @return the value of t_user_stage_act_log.user_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_act_log.user_id
     *
     * @param userId the value for t_user_stage_act_log.user_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_act_log.stage_song_id
     *
     * @return the value of t_user_stage_act_log.stage_song_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Integer getStageSongId() {
        return stageSongId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_act_log.stage_song_id
     *
     * @param stageSongId the value for t_user_stage_act_log.stage_song_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setStageSongId(Integer stageSongId) {
        this.stageSongId = stageSongId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_act_log.stage_level_id
     *
     * @return the value of t_user_stage_act_log.stage_level_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Integer getStageLevelId() {
        return stageLevelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_act_log.stage_level_id
     *
     * @param stageLevelId the value for t_user_stage_act_log.stage_level_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setStageLevelId(Integer stageLevelId) {
        this.stageLevelId = stageLevelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_act_log.is_assist
     *
     * @return the value of t_user_stage_act_log.is_assist
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Byte getIsAssist() {
        return isAssist;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_act_log.is_assist
     *
     * @param isAssist the value for t_user_stage_act_log.is_assist
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setIsAssist(Byte isAssist) {
        this.isAssist = isAssist;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_act_log.assist_user_id
     *
     * @return the value of t_user_stage_act_log.assist_user_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Long getAssistUserId() {
        return assistUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_act_log.assist_user_id
     *
     * @param assistUserId the value for t_user_stage_act_log.assist_user_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setAssistUserId(Long assistUserId) {
        this.assistUserId = assistUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_act_log.score
     *
     * @return the value of t_user_stage_act_log.score
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Integer getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_act_log.score
     *
     * @param score the value for t_user_stage_act_log.score
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_act_log.is_passed
     *
     * @return the value of t_user_stage_act_log.is_passed
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Byte getIsPassed() {
        return isPassed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_act_log.is_passed
     *
     * @param isPassed the value for t_user_stage_act_log.is_passed
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setIsPassed(Byte isPassed) {
        this.isPassed = isPassed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_act_log.act_count
     *
     * @return the value of t_user_stage_act_log.act_count
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Integer getActCount() {
        return actCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_act_log.act_count
     *
     * @param actCount the value for t_user_stage_act_log.act_count
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setActCount(Integer actCount) {
        this.actCount = actCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_act_log.is_deleted
     *
     * @return the value of t_user_stage_act_log.is_deleted
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_act_log.is_deleted
     *
     * @param isDeleted the value for t_user_stage_act_log.is_deleted
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_act_log.create_time
     *
     * @return the value of t_user_stage_act_log.create_time
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_act_log.create_time
     *
     * @param createTime the value for t_user_stage_act_log.create_time
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_stage_act_log.update_time
     *
     * @return the value of t_user_stage_act_log.update_time
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_stage_act_log.update_time
     *
     * @param updateTime the value for t_user_stage_act_log.update_time
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}