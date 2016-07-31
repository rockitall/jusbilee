package com.jusbilee.app.sms.controller;

import com.jusbilee.app.base.BaseController;
import com.jusbilee.app.common.pojo.JsonResult;
import com.jusbilee.app.sms.param.SmsParam;
import com.jusbilee.app.sms.param.SmsType;
import com.jusbilee.app.sms.param.VerifyCode;
import com.jusbilee.app.sms.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 * Created by Allen on 2016/7/30.
 */
@RestController
public class SmsController extends BaseController {
    @Autowired
    private SmsService smsService;

    @RequestMapping("/sms/{smsType}")
    public JsonResult sms(@Valid SmsParam param, BindingResult bindingResult) {
        VerifyCode verifyCode = smsService.getVerifyCode(param);
        return ok(verifyCode);
    }
}
