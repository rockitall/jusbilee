package com.jusbilee.app.common.exception;

import com.jusbilee.app.common.code.ErrorCode;

/**
 * Created by Allen on 2016/7/30.
 */
public class IllegalApiParameterException extends ApiException {
    public IllegalApiParameterException(String message) {
        super(ErrorCode.ILLEGAL_PARAMETER, message);
    }
}
