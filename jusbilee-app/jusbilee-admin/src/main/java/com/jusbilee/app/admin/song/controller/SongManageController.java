/**
 * zhandc 2016年8月27日
 */
package com.jusbilee.app.admin.song.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.jusbilee.app.admin.request.SongRequests;
import com.jusbilee.app.mybatis.pojo.Song;
import com.jusbilee.app.qiniu.QinniuUtil;
import com.jusbilee.app.song.service.SongService;
import com.rockit.core.pojo.JsonResult;

/**
 * @author zhandc 2016年8月27日
 *
 */

@Controller
@RequestMapping("/meta/song/lib")
public class SongManageController {

	@Autowired
	private SongService songService;

	@Autowired
	private QinniuUtil qinniuUtil;

	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("meta/song_lib_list");
		List<Song> allLevels = songService.querySongs();
		mv.addObject("songs", allLevels);
		return mv;
	}

	@RequestMapping("/add")
	@ResponseBody
	public JsonResult add(HttpServletRequest request, @Valid @ModelAttribute SongRequests.SongParam param,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		MultipartFile iconUrl = ((MultipartHttpServletRequest) request).getFile("iconUrl");
		MultipartFile opernScreenshotUrl = ((MultipartHttpServletRequest) request).getFile("opernScreenshotUrl");
		MultipartFile opernUrl = ((MultipartHttpServletRequest) request).getFile("opernUrl");
		MultipartFile wavPlayUrl = ((MultipartHttpServletRequest) request).getFile("wavPlayUrl");
		MultipartFile midiPlayUrl = ((MultipartHttpServletRequest) request).getFile("midiPlayUrl");

		qinniuUtil.upload(iconUrl);
		qinniuUtil.upload(opernScreenshotUrl);
		qinniuUtil.upload(opernUrl);
		qinniuUtil.upload(wavPlayUrl);
		qinniuUtil.upload(midiPlayUrl);

		Song song = new Song();
		song.setName(param.getName());
		song.setDescription(param.getDescription());
		song.setIconUrl(iconUrl.getOriginalFilename());
		song.setOpernScreenshotUrl(opernScreenshotUrl.getOriginalFilename());
		song.setOpernUrl(opernUrl.getOriginalFilename());
		song.setWavPlayUrl(wavPlayUrl.getOriginalFilename());
		song.setMidiPlayUrl(midiPlayUrl.getOriginalFilename());
		song.setCreateTime(new Date());
		songService.addSong(song);

		return JsonResult.ok();
	}


	@RequestMapping("/delete")
	@ResponseBody
	public JsonResult delete(@RequestParam(required = true) Integer songId) {

		Song song = songService.selectById(songId);
		qinniuUtil.deleteSong(song);

		songService.delete(songId);
		return JsonResult.ok();
	}

	@RequestMapping("/update")
	@ResponseBody
	public JsonResult update(HttpServletRequest request, @Valid @ModelAttribute SongRequests.SongParam param,
			@RequestParam(required = true) Integer songId,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		MultipartFile iconUrl = ((MultipartHttpServletRequest) request).getFile("iconUrl");
		MultipartFile opernScreenshotUrl = ((MultipartHttpServletRequest) request).getFile("opernScreenshotUrl");
		MultipartFile opernUrl = ((MultipartHttpServletRequest) request).getFile("opernUrl");
		MultipartFile wavPlayUrl = ((MultipartHttpServletRequest) request).getFile("wavPlayUrl");
		MultipartFile midiPlayUrl = ((MultipartHttpServletRequest) request).getFile("midiPlayUrl");

		Song song = new Song();
		song.setId(songId);
		if (!iconUrl.isEmpty()) {
			qinniuUtil.upload(iconUrl);
			song.setIconUrl(iconUrl.getOriginalFilename());
		}
		if (!opernScreenshotUrl.isEmpty()) {
			qinniuUtil.upload(opernScreenshotUrl);
			song.setOpernScreenshotUrl(opernScreenshotUrl.getOriginalFilename());
		}
		if (!opernUrl.isEmpty()) {
			qinniuUtil.upload(opernUrl);
			song.setOpernUrl(opernUrl.getOriginalFilename());
		}

		if (!wavPlayUrl.isEmpty()) {
			qinniuUtil.upload(wavPlayUrl);
			song.setWavPlayUrl(wavPlayUrl.getOriginalFilename());
		}

		if (!midiPlayUrl.isEmpty()) {
			qinniuUtil.upload(midiPlayUrl);
			song.setMidiPlayUrl(midiPlayUrl.getOriginalFilename());
		}

		song.setName(param.getName());
		song.setDescription(param.getDescription());

		song.setUpdateTime(new Date());
		songService.update(song);

		return JsonResult.ok();
	}

}
