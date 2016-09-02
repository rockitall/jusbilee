/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.admin.controller;

import com.jusbilee.app.api.song.service.SongService;
import com.jusbilee.app.api.style.service.SongStyleService;
import com.jusbilee.app.mybatis.pojo.Song;
import com.jusbilee.app.mybatis.pojo.SongStyle;
import com.jusbilee.app.song.domain.PracticeSong;
import com.jusbilee.app.song.domain.PracticeSongCriteria;
import com.jusbilee.app.song.service.PracticeSongService;
import com.rockit.core.pojo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * @author zhandc 2016年8月28日
 */

@Controller
@RequestMapping("/meta/song/practice")
public class PracticeSongController {

    @Autowired
    private PracticeSongService practiceSongService;

    @Autowired
    private SongStyleService songStyleService;

    @Autowired
    private SongService songService;

    @RequestMapping("/list")
    public ModelAndView list(@Valid @ModelAttribute PracticeSongCriteria criteria) {
        ModelAndView mv = new ModelAndView("meta/song_practice_list");
        practiceSongService.query(criteria);
        List<SongStyle> allLevels = songStyleService.list();
        List<Song> songs = songService.querySongs();
        mv.addObject("criteria", criteria);
        mv.addObject("styles", allLevels);
        mv.addObject("songs", songs);
        return mv;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(@Valid @ModelAttribute PracticeSong practiceSong, BindingResult bindingResult) {

        practiceSongService.add(practiceSong);

        return JsonResult.ok();
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@Valid @ModelAttribute PracticeSong practiceSong, BindingResult bindingResult) {

        practiceSongService.update(practiceSong);

        return JsonResult.ok();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam(required = true) Long id) {
        practiceSongService.delete(id);
        return JsonResult.ok();
    }
}
