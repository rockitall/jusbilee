package com.jusbilee.app.api.user.request;


import javax.validation.constraints.NotNull;

/**
 * Created by Allen on 2016/8/22.
 */
public class UserFriendRequest {
    @NotNull(message = "friendId不能为空")
    private Long friendId;

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }
}
