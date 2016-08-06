/**
 * zhandc 2016年8月6日
 */
package com.jusbilee.app.admin.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jusbilee.app.admin.domain.SysUser;
import com.jusbilee.app.admin.service.SysUserServices;
import com.jusbilee.app.base.BaseController;
import com.jusbilee.app.common.pojo.JsonResult;

/**
 * @author zhandc 2016年8月6日
 *
 */

@RestController
@RequestMapping("/sysUser")
public class SysUserController extends BaseController{
	
	@Autowired
    private SysUserServices sysUserServices;
	
	@RequestMapping("/user/insert")
    public JsonResult insertSysUser(@Valid @ModelAttribute SysUser sysUser, BindingResult bindingResult) {
        assertValid(bindingResult);
        sysUserServices.insertSysUser(sysUser);
        return ok();
    }
	
	@RequestMapping("/user/update")
    public JsonResult updateSysUser(@Valid @ModelAttribute SysUser sysUser, BindingResult bindingResult) {
        assertValid(bindingResult);
        sysUserServices.updateSysUser(sysUser);
        return ok();
    }
	
	@RequestMapping("/user/selectById")
    public JsonResult selectById(@Valid @ModelAttribute Long userId, BindingResult bindingResult) {
        assertValid(bindingResult);
        SysUser sysUser = sysUserServices.selectById(Long.valueOf(userId));
        return ok(sysUser);
    }

}
