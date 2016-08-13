/**
 * zhandc 2016年8月6日
 */
package com.jusbilee.app.admin.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jusbilee.app.admin.domain.SysUser;
import com.jusbilee.app.admin.domain.SysUserCriteria;
import com.jusbilee.app.admin.service.SysUserServices;
import com.jusbilee.app.base.BaseController;
import com.jusbilee.app.common.pojo.JsonResult;

/**
 * @author zhandc 2016年8月6日
 *
 */

@RestController
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {

	@Autowired
	private SysUserServices sysUserServices;

	@RequestMapping("/add")
	public JsonResult insertSysUser(@Valid @ModelAttribute SysUser sysUser, BindingResult bindingResult) {
		assertValid(bindingResult);
		sysUserServices.insertSysUser(sysUser);
		return ok();
	}

	@RequestMapping("/update")
	public JsonResult updateSysUser(@Valid @ModelAttribute SysUser sysUser, BindingResult bindingResult) {
		assertValid(bindingResult);
		sysUserServices.updateSysUser(sysUser);
		return ok();
	}

	@RequestMapping("/selectById")
	public JsonResult selectById(@RequestParam(value = "userId", required = true) Long userId) {
		SysUser sysUser = sysUserServices.selectById(Long.valueOf(userId));
		return ok(sysUser);
	}

	@RequestMapping("/query")
	public JsonResult query(@Valid @ModelAttribute SysUserCriteria criteria, BindingResult bindingResult) {
		assertValid(bindingResult);
		sysUserServices.query(criteria);
		return ok(criteria);
	}

	@RequestMapping("/deleteById")
	public JsonResult deleteById(@Valid @RequestParam(value = "userId", required = true) Long userId) {
		sysUserServices.deleteSysUser(userId);
		return ok();
	}

	@RequestMapping("/isLock")
	public JsonResult isLock(@Valid @RequestParam(value = "userId", required = true) Long userId,
			@RequestParam(value = "isLocked", required = true) byte isLocked) {
		sysUserServices.updateIslocked(userId, isLocked);
		return ok();
	}

}
