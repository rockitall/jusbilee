package com.jusbilee.app.sms.service;

import com.jusbilee.app.common.exception.VerifyCodeExpiredException;
import com.jusbilee.app.common.exception.VerifyCodeIncorrectException;
import com.jusbilee.app.common.utils.UniqueIdUtils;
import com.jusbilee.app.redis.RedisCacheService;
import com.jusbilee.app.sms.param.SmsParam;
import com.jusbilee.app.sms.param.SmsType;
import com.jusbilee.app.sms.param.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by allen on 16-2-6.
 */
@Service
public class SmsService {
    @Autowired
    private RedisCacheService redisCacheService;

    public VerifyCode getVerifyCode(SmsParam param) {
        VerifyCode verifyCode = new VerifyCode();
        verifyCode.setSsid(UniqueIdUtils.getSSID());
        verifyCode.setCode(UniqueIdUtils.getVerifyCode());

        redisCacheService.setSmsVerifyCode(verifyCode, param.getSmsType());

        return verifyCode;
    }

    public void checkVerifyCode(SmsType smsType, VerifyCode verifyCode) {
        String cacheCode = redisCacheService.getSmsVerifyCode(verifyCode.getSsid(), smsType);
        if (cacheCode == null) {
            throw new VerifyCodeExpiredException();
        }
        if (!cacheCode.equals(verifyCode.getCode())) {
            throw new VerifyCodeIncorrectException();
        }
    }
}
