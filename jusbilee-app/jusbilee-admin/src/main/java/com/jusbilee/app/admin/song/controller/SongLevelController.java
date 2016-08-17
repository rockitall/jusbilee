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

import com.jusbilee.app.admin.domain.SongLevel;
import com.jusbilee.app.admin.domain.SongLevelCriteria;
import com.jusbilee.app.admin.service.SongLevelService;
import com.jusbilee.app.base.BaseController;
import com.jusbilee.app.common.pojo.JsonResult;

/**
 * @author zhandc 2016年8月17日
 *
 */

@RestController
@RequestMapping("/songLevel")
public class SongLevelController extends BaseController{
	
	@Autowired
	private SongLevelService songLevelService;
	
	@RequestMapping("/query")
	public JsonResult query(@Valid @ModelAttribute SongLevelCriteria criteria, BindingResult bindingResult) {
		assertValid(bindingResult);
		songLevelService.query(criteria);
		return ok(criteria);
	}
	
	@RequestMapping("/selectById")
	public JsonResult selectById(@RequestParam(value = "levelId", required = true) long levelId) {
		SongLevel songLevel = songLevelService.selectById(levelId);
		return ok(songLevel);
	}
	
	@RequestMapping("/add")
	public JsonResult insertSysUser(@Valid @ModelAttribute SongLevel songLevel, BindingResult bindingResult) {
		assertValid(bindingResult);
		songLevelService.add(songLevel);
		return ok();
	}
	
	@RequestMapping("/modify")
	public JsonResult update(@Valid @ModelAttribute SongLevel songLevel, BindingResult bindingResult) {
		assertValid(bindingResult);
		songLevelService.update(songLevel);
		return ok();
	}
	
	@RequestMapping("/delete")
	public JsonResult delete(@RequestParam(value = "levelId", required = true) long levelId) {
		songLevelService.delete(levelId);
		return ok();
	}

}
