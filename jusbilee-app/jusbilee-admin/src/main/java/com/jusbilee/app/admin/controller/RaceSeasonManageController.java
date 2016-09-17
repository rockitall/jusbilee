/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.admin.controller;

import com.jusbilee.app.admin.criteria.RaceSeasonQueryCriteria;
import com.jusbilee.app.admin.domain.AdminRaceSeasonListItem;
import com.jusbilee.app.admin.manager.RaceSeasonManager;
import com.jusbilee.app.admin.request.RaceSeasonRequest;
import com.jusbilee.app.mybatis.pojo.RaceSeason;
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
@Controller
@RequestMapping("/meta/race/season")
public class RaceSeasonManageController {
    private static final Logger logger = LoggerFactory.getLogger(RaceSeasonManageController.class);

    @Autowired
    private RaceSeasonManager raceSeasonManager;

    @RequestMapping("/list")
    @ResponseBody
    public ModelAndView add(@Valid @ModelAttribute RaceSeasonQueryCriteria criteria,
                            @Valid @ModelAttribute Pagination pagination, BindingResult bindingResult) throws Exception {
        ModelAndView mv = new ModelAndView("meta/race_season_list");
        try {
            long total = raceSeasonManager.countRaceSeason(criteria);
            List<AdminRaceSeasonListItem> seasons = Collections.emptyList();
            if (total > 0) {
                pagination.setTotal(total);
                seasons = raceSeasonManager.queryRaceSeason(criteria, pagination);
            }
            mv.addObject("seasons", seasons);
            mv.addObject("c", criteria);
            mv.addObject("p", pagination);
        } catch (Exception e) {
            logger.error("", e);
        }
        return mv;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(@Valid @ModelAttribute RaceSeasonRequest request, BindingResult bindingResult) throws Exception {
        try {
            raceSeasonManager.addRaceSeason(request);
            return JsonResult.ok();
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@RequestParam Integer seasonId,
                             @Valid @ModelAttribute RaceSeasonRequest request, BindingResult bindingResult) throws Exception {
        try {
            raceSeasonManager.updateRaceSeason(seasonId, request);
            return JsonResult.ok();
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public JsonResult get(@PathVariable("id") Integer seasonId) {
        try {
            RaceSeason season = raceSeasonManager.getRaceSeason(seasonId);
            return JsonResult.ok(new RaceSeasonWrapper(season));
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam("seasonId") Integer seasonId) {
        try {
            raceSeasonManager.deleteRaceSeason(seasonId);
            return JsonResult.ok();
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    private static class RaceSeasonWrapper {
        private RaceSeason season;
        private DateFormat fmt;

        public RaceSeasonWrapper(RaceSeason season) {
            this.season = season;
            this.fmt = new SimpleDateFormat("yyyy/MM/dd");
        }

        public Integer getId() {
            return season.getId();
        }

        public String getSeasonName() {
            return season.getSeasonName();
        }

        public String getStartTime() {
            return season.getStartTime() != null ? fmt.format(season.getStartTime()) : "";
        }

        public String getEndTime() {
            return season.getEndTime() != null ? fmt.format(season.getEndTime()) : "";
        }
    }
}
