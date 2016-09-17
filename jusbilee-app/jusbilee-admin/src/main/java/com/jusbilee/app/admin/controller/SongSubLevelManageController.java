/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.admin.controller;

import com.jusbilee.app.admin.criteria.AdminSongSubLevelQueryCriteria;
import com.jusbilee.app.admin.domain.AdminSongSubLevelListItem;
import com.jusbilee.app.admin.manager.SongLevelManager;
import com.jusbilee.app.admin.manager.SongSubLevelManager;
import com.jusbilee.app.admin.request.SongSubLevelRequest;
import com.jusbilee.app.mybatis.pojo.SongLevel;
import com.jusbilee.app.mybatis.pojo.SongSubLevel;
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
import java.util.Collections;
import java.util.List;

/**
 * @author zhandc 2016年8月28日
 */

@Controller
@RequestMapping("/meta/song/sublevel")
public class SongSubLevelManageController {
    private static final Logger logger = LoggerFactory.getLogger(SongSubLevelManageController.class);
    @Autowired
    private SongLevelManager songLevelManager;

    @Autowired
    private SongSubLevelManager songSubLevelManager;

    @RequestMapping("/list")
    @ResponseBody
    public ModelAndView add(@Valid @ModelAttribute AdminSongSubLevelQueryCriteria criteria,
                            @Valid @ModelAttribute Pagination pagination, BindingResult bindingResult) throws Exception {
        ModelAndView mv = new ModelAndView("meta/song_sub_level_list");
        try {
            long total = songSubLevelManager.countSongSubLevel(criteria);
            List<AdminSongSubLevelListItem> sublevels = Collections.emptyList();
            if (total > 0) {
                pagination.setTotal(total);
                sublevels = songSubLevelManager.querySongSubLevel(criteria, pagination);
            }
            List<SongLevel> levels = songLevelManager.list();
            mv.addObject("levels", levels);
            mv.addObject("sublevels", sublevels);
            mv.addObject("c", criteria);
            mv.addObject("p", pagination);
        } catch (Exception e) {
            logger.error("", e);
        }
        return mv;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(@Valid @ModelAttribute SongSubLevelRequest request, BindingResult bindingResult) throws Exception {
        try {
            songSubLevelManager.addSongSubLevel(request);
            return JsonResult.ok();
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(@RequestParam Integer subLevelId,
                             @Valid @ModelAttribute SongSubLevelRequest request, BindingResult bindingResult) throws Exception {
        try {
            songSubLevelManager.updateSongSubLevel(subLevelId, request);
            return JsonResult.ok();
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public JsonResult get(@PathVariable("id") Integer subLevelId) {
        try {
            SongSubLevel subLevel = songSubLevelManager.getSongSubLevel(subLevelId);
            return JsonResult.ok(subLevel);
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam("subLevelId") Integer subLevelId) {
        try {
            songSubLevelManager.deleteSongSubLevel(subLevelId);
            return JsonResult.ok();
        } catch (Exception e) {
            logger.error("", e);
            return JsonResult.error(1, "error");
        }
    }
}
