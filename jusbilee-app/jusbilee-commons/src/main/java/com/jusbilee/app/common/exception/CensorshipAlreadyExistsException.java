/**
 * zhandc 2016年8月9日
 */
package com.jusbilee.app.common.exception;

import com.jusbilee.app.common.code.ErrorCode;

/**
 * @author zhandc 2016年8月9日
 *
 */
public class CensorshipAlreadyExistsException extends ApiException {
    public CensorshipAlreadyExistsException() {
        super(ErrorCode.CENSORSHIP_ALREADY_EXISTS);
    }
}

