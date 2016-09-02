/**
 * zhandc 2016年8月27日
 */
package com.jusbilee.app.admin.controller;

import com.jusbilee.app.admin.manager.SongManager;
import com.jusbilee.app.admin.request.SongRequest;
import com.jusbilee.app.mybatis.pojo.Song;
import com.jusbilee.app.qiniu.QiniuFileUploadService;
import com.rockit.core.pojo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
    private QiniuFileUploadService qiniuFileUploadService;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("meta/song_list");
        List<Song> allLevels = songManager.querySongs();
        mv.addObject("songs", allLevels);
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

        // songManager.updateSong(songId, request);

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
