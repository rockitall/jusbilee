package com.jusbilee.app.mybatis.pojo;

import java.util.Date;

public class PracticeSong {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_practice_song.id
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_practice_song.song_id
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    private Integer songId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_practice_song.style_id
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    private Integer styleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_practice_song.lock_gold_coin
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    private Integer lockGoldCoin;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_practice_song.is_deleted
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    private Byte isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_practice_song.create_time
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_practice_song.update_time
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_practice_song.id
     *
     * @return the value of t_practice_song.id
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_practice_song.id
     *
     * @param id the value for t_practice_song.id
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_practice_song.song_id
     *
     * @return the value of t_practice_song.song_id
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    public Integer getSongId() {
        return songId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_practice_song.song_id
     *
     * @param songId the value for t_practice_song.song_id
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_practice_song.style_id
     *
     * @return the value of t_practice_song.style_id
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    public Integer getStyleId() {
        return styleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_practice_song.style_id
     *
     * @param styleId the value for t_practice_song.style_id
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_practice_song.lock_gold_coin
     *
     * @return the value of t_practice_song.lock_gold_coin
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    public Integer getLockGoldCoin() {
        return lockGoldCoin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_practice_song.lock_gold_coin
     *
     * @param lockGoldCoin the value for t_practice_song.lock_gold_coin
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    public void setLockGoldCoin(Integer lockGoldCoin) {
        this.lockGoldCoin = lockGoldCoin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_practice_song.is_deleted
     *
     * @return the value of t_practice_song.is_deleted
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_practice_song.is_deleted
     *
     * @param isDeleted the value for t_practice_song.is_deleted
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_practice_song.create_time
     *
     * @return the value of t_practice_song.create_time
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_practice_song.create_time
     *
     * @param createTime the value for t_practice_song.create_time
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_practice_song.update_time
     *
     * @return the value of t_practice_song.update_time
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_practice_song.update_time
     *
     * @param updateTime the value for t_practice_song.update_time
     *
     * @mbg.generated Wed Aug 24 21:12:33 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}