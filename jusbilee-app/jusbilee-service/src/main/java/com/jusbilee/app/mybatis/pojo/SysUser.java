package com.jusbilee.app.mybatis.pojo;

import java.util.Date;

public class SysUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.id
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.username
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.nickname
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    private String nickname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.password
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.mobile
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    private String mobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.phone
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.email
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.address
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.qq
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    private String qq;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.status
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.is_locked
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    private Byte isLocked;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.create_time
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.update_time
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.id
     *
     * @return the value of t_sys_user.id
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.id
     *
     * @param id the value for t_sys_user.id
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.username
     *
     * @return the value of t_sys_user.username
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.username
     *
     * @param username the value for t_sys_user.username
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.nickname
     *
     * @return the value of t_sys_user.nickname
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.nickname
     *
     * @param nickname the value for t_sys_user.nickname
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.password
     *
     * @return the value of t_sys_user.password
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.password
     *
     * @param password the value for t_sys_user.password
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.mobile
     *
     * @return the value of t_sys_user.mobile
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.mobile
     *
     * @param mobile the value for t_sys_user.mobile
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.phone
     *
     * @return the value of t_sys_user.phone
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.phone
     *
     * @param phone the value for t_sys_user.phone
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.email
     *
     * @return the value of t_sys_user.email
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.email
     *
     * @param email the value for t_sys_user.email
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.address
     *
     * @return the value of t_sys_user.address
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.address
     *
     * @param address the value for t_sys_user.address
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.qq
     *
     * @return the value of t_sys_user.qq
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public String getQq() {
        return qq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.qq
     *
     * @param qq the value for t_sys_user.qq
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.status
     *
     * @return the value of t_sys_user.status
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.status
     *
     * @param status the value for t_sys_user.status
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.is_locked
     *
     * @return the value of t_sys_user.is_locked
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public Byte getIsLocked() {
        return isLocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.is_locked
     *
     * @param isLocked the value for t_sys_user.is_locked
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public void setIsLocked(Byte isLocked) {
        this.isLocked = isLocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.create_time
     *
     * @return the value of t_sys_user.create_time
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.create_time
     *
     * @param createTime the value for t_sys_user.create_time
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.update_time
     *
     * @return the value of t_sys_user.update_time
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.update_time
     *
     * @param updateTime the value for t_sys_user.update_time
     *
     * @mbg.generated Sat Sep 03 20:07:47 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}