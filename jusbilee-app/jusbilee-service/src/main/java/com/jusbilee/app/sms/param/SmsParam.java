package com.jusbilee.app.sms.param;


import com.rockit.core.constraints.annotation.Mobile;

import javax.validation.constraints.NotNull;

/**
 * Created by Allen on 2016/7/31.
 */
public class SmsParam {
    @NotNull(message = "smsType不能为空")
    private SmsType smsType;

    @NotNull(message = "username不能为空")
    @Mobile
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SmsType getSmsType() {
        return smsType;
    }

    public void setSmsType(SmsType smsType) {
        this.smsType = smsType;
    }
}
