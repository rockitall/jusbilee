package com.jusbilee.app.user.account.param;

import com.rockit.core.constraints.annotation.ID;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Credentials {
    @NotBlank(message = "登录名不能为空")
    @ID(message = "登录名只能包含大小写字母、数字、下划线、横线、@符号及小数点符号，且首尾只能为字母数字")
    @Length(min = 4, max = 16, message = "登录名长度最少4个字符，最多16个字符")
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
