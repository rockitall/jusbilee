package com.jusbilee.app.user.pojo;

import java.io.Serializable;

/**
 * Created by Allen on 2016/7/16.
 */
public class UserAccount implements Serializable {
    private Integer userId;
    private String nickname;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
