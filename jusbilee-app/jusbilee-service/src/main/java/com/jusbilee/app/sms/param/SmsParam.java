package com.jusbilee.app.sms.param;


import javax.validation.constraints.NotNull;

/**
 * Created by Allen on 2016/7/31.
 */
public class SmsParam {
    @NotNull(message = "smsType不能为空")
    private SmsType smsType;

    public SmsType getSmsType() {
        return smsType;
    }

    public void setSmsType(SmsType smsType) {
        this.smsType = smsType;
    }
}
