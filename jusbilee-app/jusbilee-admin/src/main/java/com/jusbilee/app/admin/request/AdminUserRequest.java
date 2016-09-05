package com.jusbilee.app.admin.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * Created by Allen on 2016/9/5.
 */
public class AdminUserRequest {

    @NotEmpty(message = "登录名不能为空")
    @Pattern(regexp = "^[a-zA-z0-9]+$", message = "登录名只能为大小写字母、数字")
    @Length(min = 4, max = 16, message = "登录名长度在4~16之间")
    private String username;

    @NotEmpty(message = "用户昵称不能为空")
    private String nickname;

    private String password;
    private String mobile;
    private String email;
    private Byte isAdmin;

    public Byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
