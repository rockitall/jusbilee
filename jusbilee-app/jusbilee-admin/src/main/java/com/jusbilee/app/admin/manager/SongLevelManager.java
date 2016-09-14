package com.jusbilee.app.admin.manager;

import com.jusbilee.app.admin.request.SongLevelRequest;
import com.jusbilee.app.admin.service.AdminSongLevelService;
import com.jusbilee.app.mybatis.pojo.SongLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Allen on 2016/9/1.
 */
@Service
public class SongLevelManager {
    @Autowired
    private AdminSongLevelService stageLevelService;

    public List<SongLevel> list() {
        return stageLevelService.list();
    }

    public void addSongLevel(SongLevelRequest request) {
        SongLevel level = new SongLevel();
        level.setName(request.getName());
        level.setWeight(request.getWeight());

        stageLevelService.addSongLevel(level);
    }

    public void updateSongLevel(Integer levelId, SongLevelRequest request) {
        SongLevel level = new SongLevel();
        level.setId(levelId);
        level.setWeight(request.getWeight());
        level.setName(request.getName());

        stageLevelService.updateSongLevel(level);
    }

    public void deleteSongLevel(Integer levelId) {
        stageLevelService.deleteSongLevel(levelId);
    }
}
