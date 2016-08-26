package com.jusbilee.app.user.relationship.domain;

import java.io.Serializable;

/**
 * Created by Allen on 2016/8/22.
 */
public class UserFriendProfile implements Serializable {
    private Long userId;
    private String identifier;
    private String nickname;
    private String avatar;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
