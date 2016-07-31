package com.jusbilee.app.common.exception;

import com.jusbilee.app.common.code.ErrorCode;

/**
 * Created by allen on 16-2-5.
 */
public class BadCredentialsException extends ApiException {
    public BadCredentialsException() {
        super(ErrorCode.BAD_CREDENTIALS);
    }
}