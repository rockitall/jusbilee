package com.jusbilee.app.user.param;

import com.jusbilee.app.common.constraints.annotation.Mobile;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Credentials {
    @NotBlank(message = "登录名不能为空")
    @Mobile(message = "登录名必须是一个有效的手机号码")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Length(max = 32, message = "密码不能超过32个字符")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
