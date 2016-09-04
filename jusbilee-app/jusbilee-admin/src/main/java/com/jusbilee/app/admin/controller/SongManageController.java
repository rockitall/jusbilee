/**
 * zhandc 2016年8月27日
 */
package com.jusbilee.app.admin.controller;

import com.jusbilee.app.admin.criteria.AdminSongQueryCriteria;
import com.jusbilee.app.admin.domain.AdminSongListItem;
import com.jusbilee.app.admin.manager.SongManager;
import com.jusbilee.app.admin.manager.SongStyleManager;
import com.jusbilee.app.admin.manager.StageLevelManager;
import com.jusbilee.app.admin.request.SongRequest;
import com.jusbilee.app.mybatis.pojo.Song;
import com.jusbilee.app.mybatis.pojo.SongStyle;
import com.jusbilee.app.mybatis.pojo.StageLevel;
import com.rockit.core.pojo.JsonResult;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * @author zhandc 2016年8月27日
 */

@Controller
@RequestMapping("/meta/song")
public class SongManageController {
    @Autowired
    private SongManager songManager;
    @Autowired
    private StageLevelManager stageLevelManager;
    @Autowired
    private SongStyleManager songStyleManager;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute AdminSongQueryCriteria criteria,
                             @ModelAttribute Pagination pagination, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("meta/song_list");
        long total = songManager.countSongByCriteria(criteria, pagination);
        List<AdminSongListItem> songList = Collections.emptyList();
        if (total > 0) {
            pagination.setTotal(total);
            songList = songManager.querySongByCriteria(criteria, pagination);
        }
        mv.addObject("songs", songList);
        List<StageLevel> levelList = stageLevelManager.list();
        mv.addObject("levels", levelList);

        List<SongStyle> styleList = songStyleManager.list();
        mv.addObject("styles", styleList);

        mv.addObject("c", criteria);
        mv.addObject("p", pagination);
        return mv;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(@RequestParam MultipartFile iconFile,
                          @RequestParam MultipartFile screenshotFile,
                          @RequestParam MultipartFile opernFile,
                          @RequestParam MultipartFile wavFile,
                          @RequestParam MultipartFile midiFile,
                          @Valid @ModelAttribute SongRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        request.setIconMultipartFile(iconFile);
        request.setScreenshotMultipartFile(screenshotFile);
        request.setOpernMultipartFile(opernFile);
        request.setWavMultipartFile(wavFile);
        request.setMidiMultipartFile(midiFile);

        songManager.addSong(request);
        return JsonResult.ok();
    }


    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@RequestParam(required = false) MultipartFile iconFile,
                             @RequestParam(required = false) MultipartFile screenshotFile,
                             @RequestParam(required = false) MultipartFile opernFile,
                             @RequestParam(required = false) MultipartFile wavFile,
                             @RequestParam(required = false) MultipartFile midiFile,
                             @RequestParam(required = true) Integer songId,
                             @Valid @ModelAttribute SongRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        request.setIconMultipartFile(iconFile);
        request.setScreenshotMultipartFile(screenshotFile);
        request.setOpernMultipartFile(opernFile);
        request.setWavMultipartFile(wavFile);
        request.setMidiMultipartFile(midiFile);

        songManager.updateSong(songId, request);

        return JsonResult.ok();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam(required = true) Integer songId) {
        songManager.deleteSong(songId);
        return JsonResult.ok();
    }

    @RequestMapping("/{songId}")
    @ResponseBody
    public JsonResult get(@PathVariable("songId") Integer songId) {
        Song song = songManager.getSongById(songId);
        return JsonResult.ok(song);
    }
}
