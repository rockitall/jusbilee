/**
 * zhandc 2016年8月8日
 */
package com.jusbilee.app.admin.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jusbilee.app.admin.domain.AppUserCriteria;
import com.jusbilee.app.admin.service.AppUserAdminService;
import com.jusbilee.app.base.BaseController;
import com.jusbilee.app.common.pojo.JsonResult;

/**
 * @author zhandc 2016年8月8日
 *
 */

@RestController
@RequestMapping("/appUser/manage")
public class AppUserAdminController extends BaseController{
	
	@Autowired
	private AppUserAdminService appUserAdminService;
	
	@RequestMapping("/query")
	public JsonResult query(@Valid @ModelAttribute AppUserCriteria criteria, BindingResult bindingResult) {
		assertValid(bindingResult);
		appUserAdminService.queryAppUser(criteria);
		return ok(criteria);
	}

}
