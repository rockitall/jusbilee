package com.jusbilee.app.admin.manager;

import com.jusbilee.app.admin.criteria.AdminSongSubLevelQueryCriteria;
import com.jusbilee.app.admin.domain.AdminSongSubLevelListItem;
import com.jusbilee.app.admin.request.SongSubLevelRequest;
import com.jusbilee.app.admin.service.SongSubLevelService;
import com.jusbilee.app.mybatis.pojo.SongSubLevel;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Allen on 2016/9/15.
 */
@Service
public class SongSubLevelManager {
    @Autowired
    private SongSubLevelService songSubLevelService;

    public long countSongSubLevel(AdminSongSubLevelQueryCriteria criteria) {
        return songSubLevelService.countSongSubLevel(criteria);
    }

    public List<AdminSongSubLevelListItem> querySongSubLevel(AdminSongSubLevelQueryCriteria criteria, Pagination pagination) {
        return songSubLevelService.querySongSubLevel(criteria, pagination);
    }

    public List<AdminSongSubLevelListItem> getAll() {
        AdminSongSubLevelQueryCriteria criteria = new AdminSongSubLevelQueryCriteria();
        Pagination pagination = new Pagination();
        pagination.setLiseSize(10000);
        return songSubLevelService.querySongSubLevel(criteria, pagination);
    }

    public void addSongSubLevel(SongSubLevelRequest request) {
        SongSubLevel level = new SongSubLevel();
        level.setLevelId(request.getLevelId());
        level.setSubLevelName(request.getSubLevelName());
        level.setScore(request.getScore());

        songSubLevelService.addSongSubLevel(level);
    }

    public void updateSongSubLevel(Integer subLevelId, SongSubLevelRequest request) {
        SongSubLevel level = transformToSongSubLevel(request);
        songSubLevelService.updateSongSubLevel(subLevelId, level);
    }

    private SongSubLevel transformToSongSubLevel(SongSubLevelRequest request) {
        SongSubLevel level = new SongSubLevel();
        level.setLevelId(request.getLevelId());
        level.setSubLevelName(request.getSubLevelName());
        level.setScore(request.getScore());
        return level;
    }

    public void deleteSongSubLevel(Integer subLevelId) {
        songSubLevelService.deleteSongSubLevel(subLevelId);
    }

    public SongSubLevel getSongSubLevel(Integer subLevelId) {
        return songSubLevelService.getSongSubLevel(subLevelId);
    }
}
