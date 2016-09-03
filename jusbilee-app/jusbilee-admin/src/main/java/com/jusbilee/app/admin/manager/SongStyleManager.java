package com.jusbilee.app.admin.manager;

import com.jusbilee.app.admin.request.SongStyleRequest;
import com.jusbilee.app.api.style.service.SongStyleService;
import com.jusbilee.app.mybatis.pojo.SongStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Allen on 2016/9/1.
 */
@Service
public class SongStyleManager {
    @Autowired
    private SongStyleService songStyleService;

    public List<SongStyle> list() {
        return songStyleService.list();
    }

    public void addSongStyle(SongStyleRequest request) {
        SongStyle style = new SongStyle();
        style.setName(request.getName());
        style.setSortOrder(request.getSortOrder());
        songStyleService.addSongStyle(style);
    }

    public void updateSongStyle(Integer songStyleId, SongStyleRequest request) {
        SongStyle style = new SongStyle();
        style.setId(songStyleId);
        style.setName(request.getName());
        style.setSortOrder(request.getSortOrder());

        songStyleService.updateSongStyle(style);
    }

    public void deleteSongStyle(Integer songStyleId) {
        songStyleService.deleteSongStyle(songStyleId);
    }
}
