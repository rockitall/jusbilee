package com.jusbilee.app.user.param;

import org.hibernate.validator.constraints.NotBlank;

public class Registration extends Credentials {
    @NotBlank(message = "用户昵称不能为空")
    private String nickname;

    //    @NotBlank(message = "验证码不能为空")
    private String verifyCode;

    //    @NotBlank(message = "ssid不能为空")
    private String ssid;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
