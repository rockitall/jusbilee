package com.jusbilee.app.admin.manager;

import com.jusbilee.app.admin.criteria.AdminSongQueryCriteria;
import com.jusbilee.app.admin.domain.AdminSongListItem;
import com.jusbilee.app.admin.request.SongRequest;
import com.jusbilee.app.admin.service.AdminSongService;
import com.jusbilee.app.mybatis.pojo.Song;
import com.jusbilee.app.qiniu.UploadFileNameUtils;
import com.qiniu.util.Auth;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allen on 2016/9/1.
 */
@Service
public class SongManager {
    @Autowired
    private AdminSongService songService;
    @Autowired
    private QiniuFileUploadManager qiniuFileUploadService;

    public List<AdminSongListItem> querySongByCriteria(AdminSongQueryCriteria cretiria, Pagination pagination) {
        return songService.query(cretiria, pagination);
    }

    public long countSongByCriteria(AdminSongQueryCriteria cretiria, Pagination pagination) {
        return songService.count(cretiria, pagination);
    }

    public void addSong(SongRequest request) {
        Auth auth = qiniuFileUploadService.auth();
        String sn = UploadFileNameUtils.getUploadSN();

        String iconUrl = qiniuFileUploadService.uploadImageFile(request.getIconMultipartFile(), auth, "icon", sn);
        String screenshotUrl = "";
        if (notEmpty(request.getScreenshotMultipartFile())) {
            screenshotUrl = qiniuFileUploadService.uploadImageFile(request.getScreenshotMultipartFile(), auth, "screenshot", sn);
        }
        String opernUrl = "";
        if (notEmpty(request.getOpernMultipartFile())) {
            opernUrl = qiniuFileUploadService.uploadImageFile(request.getOpernMultipartFile(), auth, "opern", sn);
        }
        String wavPlayUrl = qiniuFileUploadService.uploadMusicFile(request.getWavMultipartFile(), auth, "wav", sn);
        String midiPlayUrl = qiniuFileUploadService.uploadMusicFile(request.getMidiMultipartFile(), auth, "midi", sn);

        Song song = new Song();
        song.setName(request.getName());
        song.setDescription(request.getDescription());
        song.setIconUrl(iconUrl);
        song.setOpernScreenshotUrl(screenshotUrl);
        song.setOpernUrl(opernUrl);
        song.setWavPlayUrl(wavPlayUrl);
        song.setMidiPlayUrl(midiPlayUrl);
        song.setLevelId(request.getLevelId());
        song.setStyleId(request.getStyleId());
        songService.addSong(song);
    }

    public void updateSong(Integer songId, SongRequest request) {
        Auth auth = qiniuFileUploadService.auth();
        String sn = UploadFileNameUtils.getUploadSN();

        Song song = new Song();

        song.setId(songId);
        song.setName(request.getName());
        song.setDescription(request.getDescription());
        song.setLevelId(request.getLevelId());
        song.setStyleId(request.getStyleId());
        List<String> toDeleteImageFiles = new ArrayList<>(5);
        List<String> toDeleteMusicFiles = new ArrayList<>(5);
        String url;
        if (notEmpty(request.getIconMultipartFile())) {
            toDeleteImageFiles.add(song.getIconUrl());
            url = qiniuFileUploadService.uploadImageFile(request.getIconMultipartFile(), auth, "icon", sn);
            song.setIconUrl(url);
        }
        if (notEmpty(request.getScreenshotMultipartFile())) {
            toDeleteImageFiles.add(song.getOpernScreenshotUrl());
            url = qiniuFileUploadService.uploadImageFile(request.getScreenshotMultipartFile(), auth, "screenshot", sn);
            song.setOpernScreenshotUrl(url);
        }
        if (notEmpty(request.getOpernMultipartFile())) {
            toDeleteImageFiles.add(song.getOpernUrl());
            url = qiniuFileUploadService.uploadImageFile(request.getOpernMultipartFile(), auth, "opern", sn);
            song.setOpernUrl(url);
        }
        if (notEmpty(request.getWavMultipartFile())) {
            toDeleteMusicFiles.add(song.getWavPlayUrl());
            url = qiniuFileUploadService.uploadMusicFile(request.getWavMultipartFile(), auth, "wav", sn);
            song.setWavPlayUrl(url);
        }
        if (notEmpty(request.getMidiMultipartFile())) {
            toDeleteMusicFiles.add(song.getMidiPlayUrl());
            url = qiniuFileUploadService.uploadMusicFile(request.getMidiMultipartFile(), auth, "midi", sn);
            song.setMidiPlayUrl(url);
        }

        songService.update(song);

        for (String urlItem : toDeleteImageFiles) {
            qiniuFileUploadService.deleteImageFile(auth, urlItem);
        }

        for (String urlItem : toDeleteMusicFiles) {
            qiniuFileUploadService.deleteMusicFile(auth, urlItem);
        }
    }

    public void deleteSong(Integer songId) {
        Song song = songService.selectById(songId);

        Auth auth = qiniuFileUploadService.auth();
        qiniuFileUploadService.deleteImageFile(auth, song.getIconUrl());
        qiniuFileUploadService.deleteImageFile(auth, song.getOpernScreenshotUrl());
        qiniuFileUploadService.deleteImageFile(auth, song.getOpernUrl());
        qiniuFileUploadService.deleteMusicFile(auth, song.getWavPlayUrl());
        qiniuFileUploadService.deleteMusicFile(auth, song.getMidiPlayUrl());

        songService.deleteSong(songId);
    }

    private boolean notEmpty(MultipartFile file) {
        return file != null && !file.isEmpty();
    }

    public Song getSongById(Integer id) {
        return songService.selectById(id);
    }
}
