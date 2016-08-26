/**
 * zhandc 2016年8月17日
 */
package com.jusbilee.app.admin.song.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jusbilee.app.admin.domain.SongStyle;
import com.jusbilee.app.admin.domain.SongStyleCriteria;
import com.jusbilee.app.admin.service.SongStyleService;
import com.jusbilee.app.base.BaseController;
import com.rockit.core.pojo.JsonResult;

/**
 * @author zhandc 2016年8月17日
 *
 */

public class SongStyleController extends BaseController{
	
	@Autowired
	private SongStyleService songStyleService;
	
	@RequestMapping("/query")
	public JsonResult query(@Valid @ModelAttribute SongStyleCriteria criteria, BindingResult bindingResult) {
		assertValid(bindingResult);
		songStyleService.query(criteria);
		return ok(criteria);
	}
	
	@RequestMapping("/selectById")
	public JsonResult selectById(@RequestParam(value = "styleId", required = true) long styleId) {
		SongStyle songStyle = songStyleService.selectById(styleId);
		return ok(songStyle);
	}
	
	@RequestMapping("/add")
	public JsonResult insertSysUser(@Valid @ModelAttribute SongStyle songStyle, BindingResult bindingResult) {
		assertValid(bindingResult);
		songStyleService.add(songStyle);
		return ok();
	}
	
	@RequestMapping("/modify")
	public JsonResult update(@Valid @ModelAttribute SongStyle songStyle, BindingResult bindingResult) {
		assertValid(bindingResult);
		songStyleService.update(songStyle);
		return ok();
	}
	
	@RequestMapping("/delete")
	public JsonResult delete(@RequestParam(value = "styleId", required = true) long styleId) {
		songStyleService.delete(styleId);
		return ok();
	}

}
