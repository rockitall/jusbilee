package com.jusbilee.app.base;

import com.jusbilee.app.common.exception.ApiException;
import com.jusbilee.app.common.code.ErrorCode;
import com.jusbilee.app.common.exception.IllegalApiParameterException;
import com.jusbilee.app.common.pojo.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Allen on 2016/7/30.
 */
@RestController
public class BaseController {
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    public JsonResult handleException(Exception e) {
        int errorCode;
        Object[] args = null;
        if (e instanceof IllegalArgumentException || e instanceof IllegalApiParameterException) {
            errorCode = ErrorCode.ILLEGAL_PARAMETER;
            args = new String[]{e.getMessage()};
        } else if (e instanceof ApiException) {
            errorCode = ((ApiException) e).getErrorCode();
        } else {
            errorCode = ErrorCode.SYS_ERR;
        }

        String message = messageSource.getMessage("E_MSG_" + errorCode, args, Locale.getDefault());
        return JsonResult.error(errorCode, message);
    }

    public static void assertValid(BindingResult result) {
        FieldError fieldError = result.getFieldError();
        if (fieldError != null) {
            throw new IllegalApiParameterException(fieldError.getDefaultMessage());
        }
    }

    public static JsonResult ok(Object o) {
        return JsonResult.ok(o);
    }

    public static JsonResult ok() {
        return JsonResult.ok();
    }

    protected static JsonResult ok(String key, Object value) {
        Map<String, Object> data = new HashMap<>();
        data.put(key, value);
        return JsonResult.ok(data);
    }
}
