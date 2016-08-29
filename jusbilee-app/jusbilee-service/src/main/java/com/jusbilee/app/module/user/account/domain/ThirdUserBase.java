package com.jusbilee.app.module.user.account.domain;

/**
 * Created by Allen on 2016/8/1.
 */
public class ThirdUserBase {
    private Long userId;

    protected String nickname = "";
    protected String avatar = "";
    protected String openid;

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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
