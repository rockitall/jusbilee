/**
 * zhandc 2016年8月27日
 */
package com.jusbilee.app.admin.controller;

import com.jusbilee.app.admin.criteria.AdminSongQueryCriteria;
import com.jusbilee.app.admin.domain.AdminSongListItem;
import com.jusbilee.app.admin.manager.SongLevelManager;
import com.jusbilee.app.admin.manager.SongManager;
import com.jusbilee.app.admin.manager.SongStyleManager;
import com.jusbilee.app.admin.request.SongRequest;
import com.jusbilee.app.mybatis.pojo.Song;
import com.jusbilee.app.mybatis.pojo.SongLevel;
import com.jusbilee.app.mybatis.pojo.SongStyle;
import com.rockit.core.pojo.JsonResult;
import com.rockit.core.pojo.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(SongManageController.class);
    @Autowired
    private SongManager songManager;
    @Autowired
    private SongLevelManager stageLevelManager;
    @Autowired
    private SongStyleManager songStyleManager;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute AdminSongQueryCriteria criteria,
                             @ModelAttribute Pagination pagination, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("meta/song_list");
        try {
            long total = songManager.countSongByCriteria(criteria, pagination);
            List<AdminSongListItem> songList = Collections.emptyList();
            if (total > 0) {
                pagination.setTotal(total);
                songList = songManager.querySongByCriteria(criteria, pagination);
            }
            mv.addObject("songs", songList);
            List<SongLevel> levelList = stageLevelManager.list();
            mv.addObject("levels", levelList);
            List<SongStyle> styleList = songStyleManager.list();
            mv.addObject("styles", styleList);

            mv.addObject("c", criteria);
            mv.addObject("p", pagination);
        } catch (Exception e) {
            logger.error("", e);
        }
        return mv;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(@RequestParam MultipartFile iconFile,
                          @RequestParam(required = false) MultipartFile screenshotFile,
                          @RequestParam(required = false) MultipartFile opernFile,
                          @RequestParam MultipartFile wavFile,
                          @RequestParam MultipartFile midiFile,
                          @Valid @ModelAttribute SongRequest request, BindingResult bindingResult) {
        try {
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
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
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
        try {
            if (bindingResult.hasErrors()) {
                return JsonResult.error(1, bindingResult.getFieldError().getDefaultMessage());
            }
            if (logger.isDebugEnabled()) {
                logger.debug("receive iconFile:" + iconFile);
                logger.debug("receive screenshotFile:" + iconFile);
                logger.debug("receive opernFile:" + iconFile);
                logger.debug("receive wavFile:" + iconFile);
                logger.debug("receive midiFile:" + iconFile);
            }

            request.setIconMultipartFile(iconFile);
            request.setScreenshotMultipartFile(screenshotFile);
            request.setOpernMultipartFile(opernFile);
            request.setWavMultipartFile(wavFile);
            request.setMidiMultipartFile(midiFile);

            songManager.updateSong(songId, request);

            return JsonResult.ok();
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam(required = true) Integer songId) {
        try {
            songManager.deleteSong(songId);
            return JsonResult.ok();
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    @RequestMapping("/{songId}")
    @ResponseBody
    public JsonResult get(@PathVariable("songId") Integer songId) {
        try {
            Song song = songManager.getSongById(songId);
            return JsonResult.ok(song);
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }
}
