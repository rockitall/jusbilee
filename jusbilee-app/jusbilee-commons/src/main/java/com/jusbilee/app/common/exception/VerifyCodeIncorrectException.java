package com.jusbilee.app.common.exception;

import com.jusbilee.app.common.code.ErrorCode;

/**
 * Created by allen on 16-2-5.
 */
public class VerifyCodeIncorrectException extends ApiException {
    public VerifyCodeIncorrectException() {
        super(ErrorCode.SMS_VERIFY_CODE_INCORRECT);
    }
}

