package com.jusbilee.app.module.user.account.param;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class PasswordModification {
    @NotBlank(message = "新密码不能为空")
    @Length(max = 32, message = "新密码不能超过32个字符")
    private String password;

    @NotBlank(message = "原密码不能为空")
    @Length(max = 32, message = "原密码不能超过32个字符")
    private String oldPassword;

    private Long userId;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}