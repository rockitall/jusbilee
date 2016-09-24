package com.jusbilee.app.api.user.account.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Allen on 2016/9/24.
 */
public class QQUser extends ThirdUserBase {
    @JsonProperty("openid")
    public void setOpenid(String openid) {
        super.openid = openid;
    }

    @JsonProperty("nickname")
    public void setNickname(String nickname) {
        super.nickname = nickname;
    }

    @JsonProperty("figureurl_qq_2")
    public void setAvatar(String avatar) {
        super.avatar = avatar;
    }
}
