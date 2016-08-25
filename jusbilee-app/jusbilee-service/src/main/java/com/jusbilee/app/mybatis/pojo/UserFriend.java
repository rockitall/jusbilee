package com.jusbilee.app.mybatis.pojo;

import java.util.Date;

public class UserFriend {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_friend.id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_friend.user_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_friend.friend_user_id
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Long friendUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_friend.is_deleted
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Byte isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_friend.create_time
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_friend.update_time
     *
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_friend.id
     *
     * @return the value of t_user_friend.id
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_friend.id
     *
     * @param id the value for t_user_friend.id
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_friend.user_id
     *
     * @return the value of t_user_friend.user_id
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_friend.user_id
     *
     * @param userId the value for t_user_friend.user_id
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_friend.friend_user_id
     *
     * @return the value of t_user_friend.friend_user_id
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Long getFriendUserId() {
        return friendUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_friend.friend_user_id
     *
     * @param friendUserId the value for t_user_friend.friend_user_id
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setFriendUserId(Long friendUserId) {
        this.friendUserId = friendUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_friend.is_deleted
     *
     * @return the value of t_user_friend.is_deleted
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_friend.is_deleted
     *
     * @param isDeleted the value for t_user_friend.is_deleted
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_friend.create_time
     *
     * @return the value of t_user_friend.create_time
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_friend.create_time
     *
     * @param createTime the value for t_user_friend.create_time
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_friend.update_time
     *
     * @return the value of t_user_friend.update_time
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_friend.update_time
     *
     * @param updateTime the value for t_user_friend.update_time
     * @mbg.generated Thu Aug 25 23:36:33 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}