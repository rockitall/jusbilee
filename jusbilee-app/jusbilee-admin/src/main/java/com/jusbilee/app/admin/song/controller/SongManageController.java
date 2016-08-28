/**
 * zhandc 2016年8月27日
 */
package com.jusbilee.app.admin.song.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jusbilee.app.admin.request.SongRequests;
import com.jusbilee.app.mybatis.pojo.Song;
import com.jusbilee.app.mybatis.pojo.SongStyle;
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
    public JsonResult add(@Valid @ModelAttribute SongRequests.SongParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        qinniuUtil.uploadSong(param);
        
        Song song = new Song();
        song.setName(param.getName());
        song.setDescription(param.getDescription());
        song.setIconUrl(param.getIconUrl().getOriginalFilename());
        song.setOpernScreenshotUrl(param.getOpernScreenshotUrl().getOriginalFilename());
        song.setOpernUrl(param.getOpernUrl().getOriginalFilename());
        song.setWavPlayUrl(param.getWavPlayUrl().getOriginalFilename());
        song.setMidiPlayUrl(param.getMidiPlayUrl().getOriginalFilename());
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
}
