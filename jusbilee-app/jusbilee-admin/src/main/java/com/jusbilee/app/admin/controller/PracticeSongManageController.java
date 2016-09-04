/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.admin.controller;

import com.jusbilee.app.admin.criteria.AdminPracticeSongCriteria;
import com.jusbilee.app.admin.domain.AdminPracticeSongListItem;
import com.jusbilee.app.admin.domain.Status;
import com.jusbilee.app.admin.manager.PracticeSongManager;
import com.jusbilee.app.admin.manager.SongStyleManager;
import com.jusbilee.app.admin.request.PracticeSongRequest;
import com.jusbilee.app.mybatis.pojo.PracticeSong;
import com.jusbilee.app.mybatis.pojo.SongStyle;
import com.rockit.core.Constants;
import com.rockit.core.pojo.JsonResult;
import com.rockit.core.pojo.Pagination;
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
@RequestMapping("/meta/practice/song")
public class PracticeSongManageController {
    @Autowired
    private PracticeSongManager practiceSongManager;

    @Autowired
    private SongStyleManager songStyleManager;


    @RequestMapping("/list")
    @ResponseBody
    public ModelAndView add(@Valid @ModelAttribute AdminPracticeSongCriteria criteria,
                            @Valid @ModelAttribute Pagination pagination, BindingResult bindingResult) throws Exception {
        ModelAndView mv = new ModelAndView("meta/practice_song_list");
        long total = practiceSongManager.countPracticeSong(criteria);

        List<AdminPracticeSongListItem> songs = Collections.emptyList();
        if (total > 0) {
            pagination.setTotal(total);
            songs = practiceSongManager.queryPracticeSong(criteria, pagination);
        }

        List<SongStyle> styles = songStyleManager.list();
        mv.addObject("styles", styles);
        mv.addObject("songs", songs);
        mv.addObject("c", criteria);
        mv.addObject("p", pagination);
        return mv;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(@Valid @ModelAttribute PracticeSongRequest request, BindingResult bindingResult) throws Exception {
        PracticeSong song = practiceSongManager.addPracticeSong(request);
        return JsonResult.ok(new PracticeSongWrapper(song));
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@RequestParam Integer practiceSongId,
                             @Valid @ModelAttribute PracticeSongRequest request, BindingResult bindingResult) throws Exception {
        practiceSongManager.updatePracticeSong(practiceSongId, request);
        return JsonResult.ok();
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public JsonResult get(@PathVariable("id") Integer practiceSongId) throws Exception {
        PracticeSong song = practiceSongManager.getPracticeSong(practiceSongId);
        return JsonResult.ok(new PracticeSongWrapper(song));
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam("id") Integer practiceSongId) throws Exception {
        practiceSongManager.deletePracticeSong(practiceSongId);
        return JsonResult.ok();
    }

    private static class PracticeSongWrapper {
        private PracticeSong song;
        private DateFormat fmt;

        public PracticeSongWrapper(PracticeSong song) {
            this.song = song;
            this.fmt = new SimpleDateFormat("yyyy/MM/dd");
        }

        public Integer getId() {
            return song.getId();
        }

        public Boolean isPassStageUnlock() {
            return song.getPassStageUnlock() == Constants.BOOL.YES;
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

        public Integer getStyleId() {
            return song.getStyleId();
        }

        public Integer getUnlockGoldCoin() {
            return song.getUnlockGoldCoin();
        }
    }
}
