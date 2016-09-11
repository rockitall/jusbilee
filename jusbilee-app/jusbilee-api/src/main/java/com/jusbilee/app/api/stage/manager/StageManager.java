package com.jusbilee.app.api.stage.manager;

import com.jusbilee.app.api.practice.domain.UnlockType;
import com.jusbilee.app.api.practice.service.ApiPracticeSongService;
import com.jusbilee.app.api.practice.service.ApiUserPracticeSummaryService;
import com.jusbilee.app.api.song.domain.ApiSong;
import com.jusbilee.app.api.song.service.ApiSongService;
import com.jusbilee.app.api.stage.domain.ApiStageLevel;
import com.jusbilee.app.api.stage.domain.ApiStageLevelSongCount;
import com.jusbilee.app.api.stage.domain.ApiStageSong;
import com.jusbilee.app.api.stage.domain.ApiUserStageSummary;
import com.jusbilee.app.api.stage.request.UserStageChallengeResultRequest;
import com.jusbilee.app.api.stage.response.StageLevelFacade;
import com.jusbilee.app.api.stage.response.StageSongFacade;
import com.jusbilee.app.api.stage.service.ApiStageLevelService;
import com.jusbilee.app.api.stage.service.ApiStageSongService;
import com.jusbilee.app.api.stage.service.ApiUserStageLogService;
import com.jusbilee.app.api.stage.service.ApiUserStageSummaryService;
import com.jusbilee.app.mybatis.pojo.PracticeSong;
import com.jusbilee.app.mybatis.pojo.StageSong;
import com.jusbilee.app.mybatis.pojo.UserPracticeSummary;
import com.jusbilee.app.mybatis.pojo.UserStageSummary;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.rockit.core.Constants.BOOL.NO;
import static com.rockit.core.Constants.BOOL.YES;

/**
 * Created by Allen on 2016/9/10.
 */
@Service
public class StageManager {
    @Autowired
    private ApiStageLevelService apiStageLevelService;

    @Autowired
    private ApiUserStageSummaryService apiUserStageSummaryService;

    @Autowired
    private ApiStageSongService apiStageSongService;

    @Autowired
    private ApiSongService apiSongService;

    @Autowired
    private ApiUserStageLogService apiUserStageLogService;

    @Autowired
    private ApiUserPracticeSummaryService apiUserPracticeSummaryService;

    @Autowired
    private ApiPracticeSongService apiPracticeSongService;

    public List<StageLevelFacade> getAllStageLevel(Long userId) {
        List<ApiStageLevel> levels = apiStageLevelService.getAllStageLevel();
        if (levels.isEmpty()) {
            return Collections.emptyList();
        }
        Map<Integer, ApiStageLevelSongCount> totals = apiStageLevelService.getAllStageLevelSongCountAsMap();
        Map<Integer, ApiStageLevelSongCount> passes = apiUserStageSummaryService.getUserAllStageLevelPassedSongCount(userId);
        List<StageLevelFacade> facades = new ArrayList<>(levels.size());
        levels.stream().forEach(v -> {
            StageLevelFacade facade = new StageLevelFacade();

            facade.setLevel(v);
            facade.setLevelTotalCount(totals.get(v.getLevelId()));
            facade.setUserPassedCount(passes.get(v.getLevelId()));
            facades.add(facade);
        });
        return facades;
    }

    public List<StageSongFacade> getStageLevelSongList(Long userId, Integer stageLevelId, Pagination pagination) {
        List<ApiStageSong> songs = apiStageSongService.getStageSongByStageLevelId(stageLevelId, pagination);
        if (songs.isEmpty()) {
            return Collections.emptyList();
        }
        List<Integer> songIdList = new ArrayList<>(songs.size());
        songs.stream().forEach(song -> {
            songIdList.add(song.getSongId());
        });
        Map<Integer, ApiUserStageSummary> summaryMap = apiUserStageSummaryService.getUserStageSummaryListBySongIdList(userId, songIdList);
        Map<Integer, ApiSong> songMap = apiSongService.getSongListAsMap(songIdList);
        List<StageSongFacade> facades = new ArrayList<>(songs.size());
        songs.stream().forEach(v -> {
            StageSongFacade facade = new StageSongFacade();

            facade.setExt(v);
            facade.setInfo(songMap.get(v.getSongId()));
            facade.setSummary(summaryMap.get(v.getSongId()));

            facades.add(facade);
        });
        return facades;
    }

    @Transactional
    public void recordUserStageChallengeResult(Long userId, UserStageChallengeResultRequest request) {
        StageSong song = apiStageSongService.getStageSongBySongId(request.getSongId());
        if (song == null) {
            return;
        }

        Byte isPass = (request.getScore() >= song.getPassScore() ? YES : NO);
        UserStageSummary summary = apiUserStageSummaryService.getUserStageSummaryBySongId(request.getSongId());
        if (summary == null) {
            apiUserStageSummaryService.addUserStageSummaryViaPassStage(userId, song, request.getScore(), request.getAssistUserId());
            tryUnlockPracticeSong(userId, isPass, request);
            apiUserStageLogService.log(userId, song, request.getScore(), request.getAssistUserId());
            return;
        }

        if (summary.getScore() > request.getScore()) {
            apiUserStageSummaryService.increaseStageCountById(summary.getId());
            apiUserStageLogService.log(userId, song, request.getScore(), request.getAssistUserId());
        } else {
            apiUserStageSummaryService.updateUserStageSummary(summary, isPass, request.getScore(), request.getAssistUserId());
            apiUserStageLogService.log(userId, song, request.getScore(), request.getAssistUserId());
        }
        tryUnlockPracticeSong(userId, isPass, request);
    }

    private void tryUnlockPracticeSong(Long userId, Byte isPass, UserStageChallengeResultRequest request) {
        if (isPass == YES) {
            UserPracticeSummary practiceSummary = apiUserPracticeSummaryService.getUserPracticeSummaryBySongId(request.getSongId());
            if (practiceSummary == null) {
                PracticeSong practiceSong = apiPracticeSongService.getPracticeSongBySongId(request.getSongId());
                if (practiceSong != null && practiceSong.getPassStageUnlock() == YES) {
                    apiUserPracticeSummaryService.addUserPracticeSummaryViaUnlock(userId, practiceSong, UnlockType.PASS_STAGE);
                }
            }
        }
    }
}
