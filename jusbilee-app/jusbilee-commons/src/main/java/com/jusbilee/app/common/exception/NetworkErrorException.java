package com.jusbilee.app.common.exception;

import com.jusbilee.app.common.code.ErrorCode;

/**
 * Created by Allen on 2016/8/1.
 */
public class NetworkErrorException extends ApiException {
    public NetworkErrorException() {
        super(ErrorCode.INVALID_ACCESS_TOKEN);
    }

    public NetworkErrorException(String message, Throwable cause) {
        super(ErrorCode.INVALID_ACCESS_TOKEN, cause);
    }
}