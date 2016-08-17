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

import com.jusbilee.app.admin.domain.SongMessage;
import com.jusbilee.app.admin.domain.SongMessageCriteria;
import com.jusbilee.app.admin.service.SongMessageService;
import com.jusbilee.app.base.BaseController;
import com.jusbilee.app.common.pojo.JsonResult;

/**
 * @author zhandc 2016年8月17日
 *
 */

@RestController
@RequestMapping("/song")
public class SongMessageController extends BaseController{
	
	@Autowired
	private SongMessageService songMessageService;
	
	@RequestMapping("/query")
	public JsonResult query(@Valid @ModelAttribute SongMessageCriteria criteria, BindingResult bindingResult) {
		assertValid(bindingResult);
		songMessageService.query(criteria);
		return ok(criteria);
	}
	
	@RequestMapping("/selectById")
	public JsonResult selectById(@RequestParam(value = "songId", required = true) long songId) {
		SongMessage songMessage = songMessageService.selectById(songId);
		return ok(songMessage);
	}
	
	@RequestMapping("/add")
	public JsonResult insertSysUser(@Valid @ModelAttribute SongMessage songMessage, BindingResult bindingResult) {
		assertValid(bindingResult);
		songMessageService.songMseeageInsert(songMessage);
		return ok();
	}
	
	@RequestMapping("/modify")
	public JsonResult updateSysUser(@Valid @ModelAttribute SongMessage songMessage, BindingResult bindingResult) {
		assertValid(bindingResult);
		songMessageService.songMseeageModify(songMessage);
		return ok();
	}
	

}
