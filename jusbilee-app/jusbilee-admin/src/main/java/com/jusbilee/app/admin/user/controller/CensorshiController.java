/**
 * zhandc 2016年8月9日
 */
package com.jusbilee.app.admin.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jusbilee.app.admin.domain.Censorship;
import com.jusbilee.app.admin.domain.CensorshipCriteria;
import com.jusbilee.app.admin.service.CensorshiService;
import com.jusbilee.app.base.BaseController;
import com.jusbilee.app.common.pojo.JsonResult;

/**
 * @author zhandc 2016年8月9日
 *
 */

@RestController
@RequestMapping("/censorshi")
public class CensorshiController extends BaseController {
	
	@Autowired
	private CensorshiService censorshiService;
	
	/**
	 * 查询关卡列表
	 * @param criteria
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping("/query")
	public JsonResult query(@Valid @ModelAttribute CensorshipCriteria criteria, BindingResult bindingResult) {
		assertValid(bindingResult);
		censorshiService.query(criteria);
		return ok(criteria);
	}
	
	@RequestMapping("/selectById")
	public JsonResult selectById(@RequestParam(value = "censorshipId", required = true) long censorshipId) {
		Censorship censorship = censorshiService.selectById(censorshipId);
		return ok(censorship);
	}
	
	@RequestMapping("/add")
	public JsonResult insertSysUser(@Valid @ModelAttribute Censorship censorship, BindingResult bindingResult) {
		assertValid(bindingResult);
		censorshiService.addCensorship(censorship);
		return ok();
	}
	
	@RequestMapping("/update")
	public JsonResult updateSysUser(@Valid @ModelAttribute Censorship censorship, BindingResult bindingResult) {
		assertValid(bindingResult);
		censorshiService.updateCensorship(censorship);
		return ok();
	}
	
	@RequestMapping("/deleteById")
	public JsonResult deleteById(@Valid @RequestParam(value = "censorshipId", required = true) long censorshipId) {
		censorshiService.deleteCensorship(censorshipId);
		return ok();
	}
	
	
	/**
	 * 获取关卡里面对应的歌曲
	 * @param criteria
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping("/queryCensorshipSong")
	public JsonResult queryCensorshipSong(@Valid @ModelAttribute CensorshipCriteria criteria, BindingResult bindingResult) {
		assertValid(bindingResult);
		censorshiService.queryCensorshipSong(criteria);
		return ok(criteria);
	}
	
	/**
	 * 批量修改或者添加某个关卡下面的歌曲
	 * @param censorshipId 关卡id
	 * @param songIdStr 歌曲id串···
	 * @return
	 */
	@RequestMapping("/updateOrInserCensorshipSong")
	public JsonResult updateOrInser(@Valid @RequestParam(value = "censorshipId", required = true) long censorshipId,
			@RequestParam(value = "songIdStr", required = true) String songIdStr) {
		censorshiService.mulAddCensorshipSong(censorshipId, songIdStr);
		return ok();
	}

}
