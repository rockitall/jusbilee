/**
 * zhandc 2016年9月2日
 */
package com.jusbilee.app.api.practice.controller;

import com.jusbilee.app.api.BaseController;
import com.jusbilee.app.api.practice.domain.ApiSongExt;
import com.jusbilee.app.api.practice.domain.ApiSongStyle;
import com.jusbilee.app.api.practice.manager.PracticeManager;
import com.jusbilee.app.api.practice.param.ApiPracticeSongCriteria;
import com.jusbilee.app.api.practice.response.PracticeSongFacade;
import com.jusbilee.app.context.HttpContext;
import com.rockit.core.pojo.JsonResult;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PracticeController extends BaseController {
    @Autowired
    private PracticeManager practiceManager;

    @RequestMapping("/song/style/list")
    public JsonResult getPracticeSongStyle() {
        HttpContext.current().getRequireUserId();
        List<ApiSongStyle> styles = practiceManager.getSongStyleList();
        return ok(styles);
    }

    /**
     * 获取练习库的歌曲列表
     *
     * @param styleId
     * @return
     */
    @RequestMapping("/practice/style/song/list")
    public JsonResult getStyleOnlinePracticeSongList(@RequestParam Integer styleId,
                                                     @ModelAttribute Pagination pagination, BindingResult bindingResult) {
        assertValid(bindingResult);
        Long userId = HttpContext.current().getRequireUserId();
        List<PracticeSongFacade> facades = practiceManager.getStyleOnlinePracticeSongList(styleId, pagination, userId);
        return ok(facades);
    }

    /**
     * 搜索练习库的歌曲列表
     *
     * @param criteria
     * @return
     */
    @RequestMapping("/practice/song/search")
    public JsonResult queryPracticeSong(@ModelAttribute Pagination pagination, @ModelAttribute ApiPracticeSongCriteria criteria, BindingResult bindingResult) {
        assertValid(bindingResult);
        Long userId = HttpContext.current().getRequireUserId();
        List<ApiSongExt> facades = practiceManager.queryPracticeSong(criteria, pagination, userId);
        return ok(facades);
    }
}
