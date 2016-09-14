/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.admin.controller;

import com.jusbilee.app.admin.criteria.AdminStageSongQueryCriteria;
import com.jusbilee.app.admin.domain.AdminStageSongListItem;
import com.jusbilee.app.admin.domain.Status;
import com.jusbilee.app.admin.manager.SongLevelManager;
import com.jusbilee.app.admin.manager.StageSongManager;
import com.jusbilee.app.admin.request.StageSongRequest;
import com.jusbilee.app.mybatis.pojo.SongLevel;
import com.jusbilee.app.mybatis.pojo.StageSong;
import com.rockit.core.pojo.JsonResult;
import com.rockit.core.pojo.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

/**
 * @author zhandc 2016年8月28日
 */

@Controller
@RequestMapping("/meta/stage/song")
public class StageSongManageController {
    private static final Logger logger = LoggerFactory.getLogger(StageSongManageController.class);
    @Autowired
    private StageSongManager stageSongManager;
    @Autowired
    private SongLevelManager stageLevelManager;

    @RequestMapping("/list")
    @ResponseBody
    public ModelAndView add(@Valid @ModelAttribute AdminStageSongQueryCriteria criteria,
                            @Valid @ModelAttribute Pagination pagination, BindingResult bindingResult) throws Exception {
        ModelAndView mv = new ModelAndView("meta/stage_song_list");
        try {
            long total = stageSongManager.countStageSong(criteria);

            List<AdminStageSongListItem> songs = Collections.emptyList();
            if (total > 0) {
                pagination.setTotal(total);
                songs = stageSongManager.queryStageSong(criteria, pagination);
            }

            List<SongLevel> levels = stageLevelManager.list();
            mv.addObject("levels", levels);
            mv.addObject("songs", songs);
            mv.addObject("c", criteria);
            mv.addObject("p", pagination);

        } catch (Exception e) {
            logger.error("", e);
        }
        return mv;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(@Valid @ModelAttribute StageSongRequest request, BindingResult bindingResult) throws Exception {
        try {
            StageSong song = stageSongManager.addStageSong(request);
            return JsonResult.ok(new StageSongWrapper(song));
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@RequestParam Integer stageSongId,
                             @Valid @ModelAttribute StageSongRequest request, BindingResult bindingResult) throws Exception {
        try {
            stageSongManager.updateStageSong(stageSongId, request);
            return JsonResult.ok();
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public JsonResult get(@PathVariable("id") Integer stageSongId) {
        try {
            StageSong song = stageSongManager.getStageSong(stageSongId);
            return JsonResult.ok(new StageSongWrapper(song));
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam("id") Integer stageSongId) {
        try {
            stageSongManager.delete(stageSongId);
            return JsonResult.ok();
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    private static class StageSongWrapper {
        private StageSong song;
        private DateFormat fmt;

        public StageSongWrapper(StageSong song) {
            this.song = song;
            this.fmt = new SimpleDateFormat("yyyy/MM/dd");
        }

        public Integer getId() {
            return song.getId();
        }

        public Integer getSongId() {
            return song.getSongId();
        }

        public String getStartTime() {
            return song.getStartTime() != null ? fmt.format(song.getStartTime()) : "";
        }

        public String getEndTime() {
            return song.getEndTime() != null ? fmt.format(song.getEndTime()) : "";
        }

        public Boolean isOnline() {
            return song.getStatus() == Status.PracticeSongStatus.ONLINE;
        }

        public Integer getLevelId() {
            return song.getLevelId();
        }

        public Integer getPassScore() {
            return song.getPassScore();
        }

        public Integer getSortOrder() {
            return song.getSortOrder();
        }
    }
}
