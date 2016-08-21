/**
 * zhandc 2016年8月9日
 */
package com.rockit.core.exception;

import com.rockit.core.code.ErrorCode;

/**
 * @author zhandc 2016年8月9日
 *
 */
public class CensorshipAlreadyExistsException extends ApiException {
    public CensorshipAlreadyExistsException() {
        super(ErrorCode.CENSORSHIP_ALREADY_EXISTS);
    }
}

