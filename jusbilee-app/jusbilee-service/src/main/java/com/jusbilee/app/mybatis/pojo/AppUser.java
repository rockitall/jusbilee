package com.jusbilee.app.mybatis.pojo;

import java.util.Date;

public class AppUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_user.id
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_user.nickname
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_user.description
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_user.sex
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_user.avatar
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private String avatar;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_user.birthday
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private String birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_user.province
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private String province;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_user.city
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private String city;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_user.points
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Integer points;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_user.friend_count
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Integer friendCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_user.is_locked
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Byte isLocked;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_user.status
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_user.create_time
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_app_user.update_time
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_app_user.id
     *
     * @return the value of t_app_user.id
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_app_user.id
     *
     * @param id the value for t_app_user.id
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_app_user.nickname
     *
     * @return the value of t_app_user.nickname
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_app_user.nickname
     *
     * @param nickname the value for t_app_user.nickname
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_app_user.description
     *
     * @return the value of t_app_user.description
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_app_user.description
     *
     * @param description the value for t_app_user.description
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_app_user.sex
     *
     * @return the value of t_app_user.sex
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_app_user.sex
     *
     * @param sex the value for t_app_user.sex
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_app_user.avatar
     *
     * @return the value of t_app_user.avatar
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_app_user.avatar
     *
     * @param avatar the value for t_app_user.avatar
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_app_user.birthday
     *
     * @return the value of t_app_user.birthday
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_app_user.birthday
     *
     * @param birthday the value for t_app_user.birthday
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_app_user.province
     *
     * @return the value of t_app_user.province
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_app_user.province
     *
     * @param province the value for t_app_user.province
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_app_user.city
     *
     * @return the value of t_app_user.city
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_app_user.city
     *
     * @param city the value for t_app_user.city
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_app_user.points
     *
     * @return the value of t_app_user.points
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_app_user.points
     *
     * @param points the value for t_app_user.points
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_app_user.friend_count
     *
     * @return the value of t_app_user.friend_count
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Integer getFriendCount() {
        return friendCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_app_user.friend_count
     *
     * @param friendCount the value for t_app_user.friend_count
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setFriendCount(Integer friendCount) {
        this.friendCount = friendCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_app_user.is_locked
     *
     * @return the value of t_app_user.is_locked
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Byte getIsLocked() {
        return isLocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_app_user.is_locked
     *
     * @param isLocked the value for t_app_user.is_locked
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setIsLocked(Byte isLocked) {
        this.isLocked = isLocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_app_user.status
     *
     * @return the value of t_app_user.status
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_app_user.status
     *
     * @param status the value for t_app_user.status
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_app_user.create_time
     *
     * @return the value of t_app_user.create_time
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_app_user.create_time
     *
     * @param createTime the value for t_app_user.create_time
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_app_user.update_time
     *
     * @return the value of t_app_user.update_time
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_app_user.update_time
     *
     * @param updateTime the value for t_app_user.update_time
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}