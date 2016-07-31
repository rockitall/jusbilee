package com.jusbilee.app.common.exception;

import com.jusbilee.app.common.code.ErrorCode;

/**
 * Created by allen on 16-2-5.
 */
public class InvalidAccessTokenException extends ApiException {
    public InvalidAccessTokenException() {
        super(ErrorCode.INVALID_ACCESS_TOKEN);
    }

    public InvalidAccessTokenException(String message, Throwable cause) {
        super(ErrorCode.INVALID_ACCESS_TOKEN, cause);
    }
}
