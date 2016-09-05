package com.jusbilee.app.mybatis.pojo;

import java.util.Date;

public class SongStyle {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song_style.id
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song_style.name
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song_style.sort_order
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    private Integer sortOrder;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song_style.is_deleted
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    private Byte isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song_style.create_time
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_song_style.update_time
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song_style.id
     *
     * @return the value of t_song_style.id
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song_style.id
     *
     * @param id the value for t_song_style.id
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song_style.name
     *
     * @return the value of t_song_style.name
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song_style.name
     *
     * @param name the value for t_song_style.name
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song_style.sort_order
     *
     * @return the value of t_song_style.sort_order
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song_style.sort_order
     *
     * @param sortOrder the value for t_song_style.sort_order
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song_style.is_deleted
     *
     * @return the value of t_song_style.is_deleted
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song_style.is_deleted
     *
     * @param isDeleted the value for t_song_style.is_deleted
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song_style.create_time
     *
     * @return the value of t_song_style.create_time
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song_style.create_time
     *
     * @param createTime the value for t_song_style.create_time
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_song_style.update_time
     *
     * @return the value of t_song_style.update_time
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_song_style.update_time
     *
     * @param updateTime the value for t_song_style.update_time
     *
     * @mbg.generated Mon Sep 05 21:07:47 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}