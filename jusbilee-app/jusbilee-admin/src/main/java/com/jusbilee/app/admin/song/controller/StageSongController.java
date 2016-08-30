/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.admin.song.controller;

import com.jusbilee.app.api.song.service.SongService;
import com.jusbilee.app.api.stage.service.StageLevelService;
import com.jusbilee.app.mybatis.pojo.Song;
import com.jusbilee.app.mybatis.pojo.StageLevel;
import com.jusbilee.app.song.domain.StageSongDomain;
import com.jusbilee.app.song.domain.StageSongDomainCriteria;
import com.jusbilee.app.song.service.StageSongService;
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
@RequestMapping("/meta/song/stage")
public class StageSongController {

    @Autowired
    private StageSongService stageSongService;

    @Autowired
    private SongService songService;

    @Autowired
    private StageLevelService stageLevelService;

    @RequestMapping("/list")
    public ModelAndView list(@Valid @ModelAttribute StageSongDomainCriteria criteria) {
        ModelAndView mv = new ModelAndView("meta/song_stage_list");
        stageSongService.query(criteria);
        List<StageLevel> allLevels = stageLevelService.list();
        List<Song> songs = songService.querySongs();
        mv.addObject("criteria", criteria);
        mv.addObject("levels", allLevels);
        mv.addObject("songs", songs);
        return mv;
    }


    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(@Valid @ModelAttribute StageSongDomain stageSongDomain, BindingResult bindingResult) {

        stageSongService.add(stageSongDomain);

        return JsonResult.ok();
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@Valid @ModelAttribute StageSongDomain stageSongDomain, BindingResult bindingResult) {

        stageSongService.update(stageSongDomain);

        return JsonResult.ok();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam(required = true) Integer id) {
        stageSongService.delete(id);
        return JsonResult.ok();
    }

}
