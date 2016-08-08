package com.jusbilee.app.common.exception;

import com.jusbilee.app.common.code.ErrorCode;

/**
 * Created by allen on 16-2-5.
 */
public class UserSignatureException extends ApiException {
    public UserSignatureException() {
        super(ErrorCode.USER_SIGNATURE_ERROR);
    }

    public UserSignatureException(String message) {
        super(ErrorCode.USER_SIGNATURE_ERROR, message);
    }

    public UserSignatureException(String message, Throwable cause) {
        super(ErrorCode.USER_SIGNATURE_ERROR, message, cause);
    }

    public UserSignatureException(Throwable cause) {
        super(ErrorCode.USER_SIGNATURE_ERROR, null, cause);
    }
}
