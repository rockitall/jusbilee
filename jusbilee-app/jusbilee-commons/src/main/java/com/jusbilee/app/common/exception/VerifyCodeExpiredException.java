package com.jusbilee.app.common.exception;

import com.jusbilee.app.common.code.ErrorCode;

/**
 * Created by Allen on 2016/7/30.
 */
public class VerifyCodeExpiredException extends ApiException {
    public VerifyCodeExpiredException() {
        super(ErrorCode.SMS_VERIFY_CODE_EXPIRED);
    }
}
