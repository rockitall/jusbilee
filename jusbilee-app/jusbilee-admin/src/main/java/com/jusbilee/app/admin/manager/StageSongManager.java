package com.jusbilee.app.admin.manager;

import com.jusbilee.app.admin.criteria.AdminStageSongQueryCriteria;
import com.jusbilee.app.admin.domain.AdminStageSongListItem;
import com.jusbilee.app.admin.domain.Status;
import com.jusbilee.app.admin.request.StageSongRequest;
import com.jusbilee.app.admin.service.AdminStageSongService;
import com.jusbilee.app.mybatis.pojo.StageSong;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Allen on 2016/9/3.
 */
@Service
public class StageSongManager {
    @Autowired
    private AdminStageSongService adminStageSongService;

    public StageSong addStageSong(StageSongRequest request) throws Exception {
        StageSong song = transformToStageSong(request);
        adminStageSongService.add(song);
        return song;
    }

    public void updateStageSong(Integer stageSongId, StageSongRequest request) throws ParseException {
        StageSong song = transformToStageSong(request);
        adminStageSongService.updateById(stageSongId, song);
    }

    private StageSong transformToStageSong(StageSongRequest request) throws ParseException {
        StageSong song = new StageSong();
        song.setStageLevelId(request.getStageLevelId());
        song.setSongId(request.getSongId());

        byte status = request.isOnline() ? Status.StageSongStatus.ONLINE : Status.StageSongStatus.OFFLINE;
        song.setStatus(status);
        if (request.isOnline()) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            song.setStartTime(dateFormat.parse(request.getStartTime()));
            song.setEndTime(dateFormat.parse(request.getEndTime()));
        }
        song.setPassScore(request.getPassScore());
        song.setSortOrder(request.getSortOrder());
        return song;
    }

    public StageSong getStageSong(Integer stageSongId) {
        return adminStageSongService.selectById(stageSongId);
    }

    public List<AdminStageSongListItem> queryStageSong(AdminStageSongQueryCriteria criteria, Pagination pagination) {
        return adminStageSongService.queryStageSong(criteria, pagination);
    }

    public long countStageSong(AdminStageSongQueryCriteria criteria) {
        return adminStageSongService.countStageSong(criteria);
    }

    public void delete(Integer stageSongId) {
        adminStageSongService.deleteById(stageSongId);
    }
}
