package com.jusbilee.app.mybatis.pojo;

import java.util.Date;

public class Passport {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_passport.id
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_passport.user_id
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_passport.username
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_passport.password
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_passport.salt
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private String salt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_passport.create_time
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_passport.update_time
     *
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_passport.id
     *
     * @return the value of t_passport.id
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_passport.id
     *
     * @param id the value for t_passport.id
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_passport.user_id
     *
     * @return the value of t_passport.user_id
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_passport.user_id
     *
     * @param userId the value for t_passport.user_id
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_passport.username
     *
     * @return the value of t_passport.username
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_passport.username
     *
     * @param username the value for t_passport.username
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_passport.password
     *
     * @return the value of t_passport.password
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_passport.password
     *
     * @param password the value for t_passport.password
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_passport.salt
     *
     * @return the value of t_passport.salt
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_passport.salt
     *
     * @param salt the value for t_passport.salt
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_passport.create_time
     *
     * @return the value of t_passport.create_time
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_passport.create_time
     *
     * @param createTime the value for t_passport.create_time
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_passport.update_time
     *
     * @return the value of t_passport.update_time
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_passport.update_time
     *
     * @param updateTime the value for t_passport.update_time
     * @mbg.generated Sat Sep 10 23:20:28 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}