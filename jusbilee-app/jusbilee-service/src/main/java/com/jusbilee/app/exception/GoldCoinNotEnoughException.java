package com.jusbilee.app.exception;

import com.rockit.core.code.ErrorCode;
import com.rockit.core.exception.ApiException;

/**
 * Created by allen on 16-2-5.
 */
public class GoldCoinNotEnoughException extends ApiException {
    public GoldCoinNotEnoughException() {
        super(ErrorCode.UNAUTHORIZED);
    }
}
