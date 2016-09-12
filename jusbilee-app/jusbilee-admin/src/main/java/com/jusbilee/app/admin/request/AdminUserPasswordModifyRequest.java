package com.jusbilee.app.admin.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Allen on 2016/9/5.
 */
public class AdminUserPasswordModifyRequest {
    @NotEmpty(message = "新密码不能为空")
    private String userPassword;

    @NotEmpty(message = "原密码不能为空")
    @Length(min = 6, max = 16, message = "用户密码长度在6~16之间")
    private String oldUserPassword;

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getOldUserPassword() {
        return oldUserPassword;
    }

    public void setOldUserPassword(String oldUserPassword) {
        this.oldUserPassword = oldUserPassword;
    }
}
