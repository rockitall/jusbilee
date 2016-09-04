package com.jusbilee.app.admin.manager;

import com.jusbilee.app.admin.criteria.AdminPracticeSongCriteria;
import com.jusbilee.app.admin.domain.AdminPracticeSongListItem;
import com.jusbilee.app.admin.domain.AdminStageSongListItem;
import com.jusbilee.app.admin.domain.Status;
import com.jusbilee.app.admin.request.PracticeSongRequest;
import com.jusbilee.app.admin.service.AdminPracticeSongService;
import com.jusbilee.app.mybatis.pojo.PracticeSong;
import com.rockit.core.Constants;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Allen on 2016/9/3.
 */
@Service
public class PracticeSongManager {
    @Autowired
    private AdminPracticeSongService adminPracticeSongService;

    public PracticeSong addPracticeSong(PracticeSongRequest request) throws Exception {
        PracticeSong song = transformToPracticeSong(request);
        adminPracticeSongService.add(song);
        return song;
    }

    public void updatePracticeSong(Integer practiceSongId, PracticeSongRequest request) throws Exception {
        PracticeSong song = transformToPracticeSong(request);
        adminPracticeSongService.updateById(practiceSongId, song);
    }

    public PracticeSong transformToPracticeSong(PracticeSongRequest request) throws Exception {
        PracticeSong song = new PracticeSong();
        song.setSongId(request.getSongId());
        song.setStyleId(request.getSongStyleId());
        byte status = request.isOnline() ? Status.StageSongStatus.ONLINE : Status.StageSongStatus.OFFLINE;
        song.setStatus(status);

        if (request.isOnline()) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            song.setStartTime(dateFormat.parse(request.getStartTime()));
            song.setEndTime(dateFormat.parse(request.getEndTime()));
        }
        song.setUnlockGoldCoin(request.getUnlockGoldCoin());
        byte passStageUnlock = request.isPassStageUnlock() ? Constants.BOOL.YES : Constants.BOOL.NO;
        song.setPassStageUnlock(passStageUnlock);
        return song;
    }

    public PracticeSong getPracticeSong(Integer practiceSongId) {
        return adminPracticeSongService.selectById(practiceSongId);
    }

    public List<AdminPracticeSongListItem> queryPracticeSong(AdminPracticeSongCriteria criteria, Pagination pagination) {
        return adminPracticeSongService.queryPracticeSong(criteria, pagination);
    }

    public long countPracticeSong(AdminPracticeSongCriteria criteria) {
        return adminPracticeSongService.countPracticeSong(criteria);
    }

    public void deletePracticeSong(Integer practiceSongId) {
        adminPracticeSongService.deletePracticeSong(practiceSongId);
    }
}
