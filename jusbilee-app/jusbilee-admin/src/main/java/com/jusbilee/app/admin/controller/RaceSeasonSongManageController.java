/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.admin.controller;

import com.jusbilee.app.admin.criteria.RaceSeasonSongQueryCriteria;
import com.jusbilee.app.admin.criteria.RaceSeasonSongSelectQueryCriteria;
import com.jusbilee.app.admin.domain.AdminRaceSeasonSongListItem;
import com.jusbilee.app.admin.domain.AdminRaceSeasonSongSelectListItem;
import com.jusbilee.app.admin.domain.AdminSongSubLevelListItem;
import com.jusbilee.app.admin.manager.RaceSeasonSongManager;
import com.jusbilee.app.admin.manager.SongLevelManager;
import com.jusbilee.app.admin.manager.SongStyleManager;
import com.jusbilee.app.admin.manager.SongSubLevelManager;
import com.jusbilee.app.admin.request.RaceSeasonSongRequest;
import com.jusbilee.app.mybatis.pojo.SongLevel;
import com.rockit.core.pojo.JsonResult;
import com.rockit.core.pojo.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/meta/race/season/song")
public class RaceSeasonSongManageController {
    private static final Logger logger = LoggerFactory.getLogger(RaceSeasonSongManageController.class);
    @Autowired
    private RaceSeasonSongManager raceSeasonSongManager;
    @Autowired
    private SongLevelManager stageLevelManager;
    @Autowired
    private SongSubLevelManager songSubLevelManager;
    @Autowired
    private SongStyleManager songStyleManager;

    @RequestMapping("/list")
    @ResponseBody
    public ModelAndView list(@Valid @ModelAttribute RaceSeasonSongQueryCriteria criteria,
                             @Valid @ModelAttribute Pagination pagination, BindingResult bindingResult) throws Exception {
        ModelAndView mv = new ModelAndView("meta/race_season_song_list");
        try {
            long total = raceSeasonSongManager.countRaceSeasonSong(criteria);
            List<AdminRaceSeasonSongListItem> songs = Collections.emptyList();
            if (total > 0) {
                pagination.setTotal(total);
                songs = raceSeasonSongManager.queryRaceSeasonSong(criteria, pagination);
            }
            List<SongLevel> levelList = stageLevelManager.list();
            mv.addObject("levels", levelList);
            mv.addObject("songs", songs);
            mv.addObject("c", criteria);
            mv.addObject("p", pagination);
        } catch (Exception e) {
            logger.error("", e);
        }
        return mv;
    }


    @RequestMapping("/select")
    @ResponseBody
    public ModelAndView select(@Valid @ModelAttribute RaceSeasonSongSelectQueryCriteria criteria,
                               @Valid @ModelAttribute Pagination pagination, BindingResult bindingResult) throws Exception {
        ModelAndView mv = new ModelAndView("meta/song_select");
        try {
            long total = raceSeasonSongManager.countRaceSeasonSongSelect(criteria);
            List<AdminRaceSeasonSongSelectListItem> songs = Collections.emptyList();
            if (total > 0) {
                pagination.setTotal(total);
                songs = raceSeasonSongManager.queryRaceSeasonSongSelect(criteria, pagination);
            }
            mv.addObject("songs", songs);
            mv.addObject("c", criteria);
            mv.addObject("p", pagination);
        } catch (Exception e) {
            logger.error("", e);
        }
        return mv;
    }

    @RequestMapping("/select/page")
    @ResponseBody
    public ModelAndView selectPage(@Valid @ModelAttribute RaceSeasonSongSelectQueryCriteria criteria,
                                   BindingResult bindingResult) throws Exception {
        ModelAndView mv = new ModelAndView("meta/race_season_song_select");
        try {
            List<AdminSongSubLevelListItem> sublevels = songSubLevelManager.getAll();
            mv.addObject("sublevels", sublevels);
            mv.addObject("c", criteria);

        } catch (Exception e) {
            logger.error("", e);
        }
        return mv;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(@Valid @ModelAttribute RaceSeasonSongRequest request,
                          BindingResult bindingResult) throws Exception {
        try {
            raceSeasonSongManager.addRaceSeasonSong(request);
            return JsonResult.ok();
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam("seasonSongId") Integer seasonSongId) {
        try {
            raceSeasonSongManager.deleteRaceSeasonSong(seasonSongId);
            return JsonResult.ok();
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }
}
