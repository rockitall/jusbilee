package com.jusbilee.app.api;

import com.rockit.core.code.ErrorCode;
import com.rockit.core.exception.ApiException;
import com.rockit.core.exception.IllegalApiParameterException;
import com.rockit.core.pojo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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
        } else if (e instanceof MissingServletRequestParameterException) {
            errorCode = ErrorCode.ILLEGAL_PARAMETER;
            MissingServletRequestParameterException ex = ((MissingServletRequestParameterException) e);
            args = new String[]{"参数'" + ex.getParameterName() + "'缺失"};
        } else if (e instanceof MethodArgumentTypeMismatchException || e instanceof ConversionFailedException) {
            MethodArgumentTypeMismatchException ex = ((MethodArgumentTypeMismatchException) e);
            errorCode = ErrorCode.ILLEGAL_PARAMETER;
            args = new String[]{"参数'" + ex.getName() + "'数据类型不正确"};
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
