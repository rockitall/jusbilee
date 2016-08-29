package com.jusbilee.app.module.user.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Allen on 2016/8/23.
 */
public class UserAvatarModificationRequest {
    @NotEmpty(message = "用户昵称不能为空")
    @Length(max = 12, message = "用户昵称不能超过12个字符")
    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
