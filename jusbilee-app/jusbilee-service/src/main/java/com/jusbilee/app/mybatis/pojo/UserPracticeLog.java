package com.jusbilee.app.mybatis.pojo;

import java.util.Date;

public class UserPracticeLog {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_practice_log.id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_practice_log.user_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_practice_log.song_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Integer songId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_practice_log.practice_song_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Integer practiceSongId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_practice_log.style_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Integer styleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_practice_log.practice_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Integer practiceTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_practice_log.practice_score
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Integer practiceScore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_practice_log.full_score_best_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Integer fullScoreBestTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_practice_log.create_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_practice_log.id
     *
     * @return the value of t_user_practice_log.id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_practice_log.id
     *
     * @param id the value for t_user_practice_log.id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_practice_log.user_id
     *
     * @return the value of t_user_practice_log.user_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_practice_log.user_id
     *
     * @param userId the value for t_user_practice_log.user_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_practice_log.song_id
     *
     * @return the value of t_user_practice_log.song_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Integer getSongId() {
        return songId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_practice_log.song_id
     *
     * @param songId the value for t_user_practice_log.song_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_practice_log.practice_song_id
     *
     * @return the value of t_user_practice_log.practice_song_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Integer getPracticeSongId() {
        return practiceSongId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_practice_log.practice_song_id
     *
     * @param practiceSongId the value for t_user_practice_log.practice_song_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setPracticeSongId(Integer practiceSongId) {
        this.practiceSongId = practiceSongId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_practice_log.style_id
     *
     * @return the value of t_user_practice_log.style_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Integer getStyleId() {
        return styleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_practice_log.style_id
     *
     * @param styleId the value for t_user_practice_log.style_id
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_practice_log.practice_time
     *
     * @return the value of t_user_practice_log.practice_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Integer getPracticeTime() {
        return practiceTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_practice_log.practice_time
     *
     * @param practiceTime the value for t_user_practice_log.practice_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setPracticeTime(Integer practiceTime) {
        this.practiceTime = practiceTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_practice_log.practice_score
     *
     * @return the value of t_user_practice_log.practice_score
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Integer getPracticeScore() {
        return practiceScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_practice_log.practice_score
     *
     * @param practiceScore the value for t_user_practice_log.practice_score
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setPracticeScore(Integer practiceScore) {
        this.practiceScore = practiceScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_practice_log.full_score_best_time
     *
     * @return the value of t_user_practice_log.full_score_best_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Integer getFullScoreBestTime() {
        return fullScoreBestTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_practice_log.full_score_best_time
     *
     * @param fullScoreBestTime the value for t_user_practice_log.full_score_best_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setFullScoreBestTime(Integer fullScoreBestTime) {
        this.fullScoreBestTime = fullScoreBestTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_practice_log.create_time
     *
     * @return the value of t_user_practice_log.create_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_practice_log.create_time
     *
     * @param createTime the value for t_user_practice_log.create_time
     *
     * @mbg.generated Wed Sep 14 07:56:40 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}