package com.jusbilee.app.mybatis.pojo;

import java.util.Date;

public class UserGoldCoinLog {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_gold_coin_log.id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_gold_coin_log.user_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_gold_coin_log.type
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Byte type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_gold_coin_log.gold_coin
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Integer goldCoin;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_gold_coin_log.event_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Integer eventId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_gold_coin_log.event_name
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private String eventName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_gold_coin_log.event_target_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Long eventTargetId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_gold_coin_log.is_deleted
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Byte isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_gold_coin_log.create_time
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_gold_coin_log.update_time
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_gold_coin_log.id
     *
     * @return the value of t_user_gold_coin_log.id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_gold_coin_log.id
     *
     * @param id the value for t_user_gold_coin_log.id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_gold_coin_log.user_id
     *
     * @return the value of t_user_gold_coin_log.user_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_gold_coin_log.user_id
     *
     * @param userId the value for t_user_gold_coin_log.user_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_gold_coin_log.type
     *
     * @return the value of t_user_gold_coin_log.type
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Byte getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_gold_coin_log.type
     *
     * @param type the value for t_user_gold_coin_log.type
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_gold_coin_log.gold_coin
     *
     * @return the value of t_user_gold_coin_log.gold_coin
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Integer getGoldCoin() {
        return goldCoin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_gold_coin_log.gold_coin
     *
     * @param goldCoin the value for t_user_gold_coin_log.gold_coin
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setGoldCoin(Integer goldCoin) {
        this.goldCoin = goldCoin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_gold_coin_log.event_id
     *
     * @return the value of t_user_gold_coin_log.event_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Integer getEventId() {
        return eventId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_gold_coin_log.event_id
     *
     * @param eventId the value for t_user_gold_coin_log.event_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_gold_coin_log.event_name
     *
     * @return the value of t_user_gold_coin_log.event_name
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_gold_coin_log.event_name
     *
     * @param eventName the value for t_user_gold_coin_log.event_name
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_gold_coin_log.event_target_id
     *
     * @return the value of t_user_gold_coin_log.event_target_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Long getEventTargetId() {
        return eventTargetId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_gold_coin_log.event_target_id
     *
     * @param eventTargetId the value for t_user_gold_coin_log.event_target_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setEventTargetId(Long eventTargetId) {
        this.eventTargetId = eventTargetId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_gold_coin_log.is_deleted
     *
     * @return the value of t_user_gold_coin_log.is_deleted
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_gold_coin_log.is_deleted
     *
     * @param isDeleted the value for t_user_gold_coin_log.is_deleted
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_gold_coin_log.create_time
     *
     * @return the value of t_user_gold_coin_log.create_time
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_gold_coin_log.create_time
     *
     * @param createTime the value for t_user_gold_coin_log.create_time
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_gold_coin_log.update_time
     *
     * @return the value of t_user_gold_coin_log.update_time
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_gold_coin_log.update_time
     *
     * @param updateTime the value for t_user_gold_coin_log.update_time
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}