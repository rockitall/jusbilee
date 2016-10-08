package com.jusbilee.app.api.practice.manager;

import com.jusbilee.app.api.coin.domain.GoldCoinEventType;
import com.jusbilee.app.api.coin.service.ApiUserGoldCoinService;
import com.jusbilee.app.api.practice.domain.*;
import com.jusbilee.app.api.practice.param.ApiPracticeSongCriteria;
import com.jusbilee.app.api.practice.request.UserPracticeRequest;
import com.jusbilee.app.api.practice.response.PracticeLogSongFacade;
import com.jusbilee.app.api.practice.response.PracticeSongFacade;
import com.jusbilee.app.api.practice.service.ApiPracticeSongService;
import com.jusbilee.app.api.practice.service.ApiSongStyleService;
import com.jusbilee.app.api.practice.service.ApiUserPracticeLogService;
import com.jusbilee.app.api.practice.service.ApiUserPracticeSummaryService;
import com.jusbilee.app.api.song.domain.ApiSong;
import com.jusbilee.app.api.song.service.ApiSongService;
import com.jusbilee.app.api.stage.service.ApiUserStageSummaryService;
import com.jusbilee.app.api.user.account.service.ApiUserSummaryService;
import com.jusbilee.app.exception.GoldCoinNotEnoughException;
import com.jusbilee.app.mybatis.pojo.*;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.rockit.core.Constants.BOOL.NO;
import static com.rockit.core.Constants.BOOL.YES;

/**
 * Created by Allen on 2016/9/10.
 */
@Service
public class PracticeManager {
    @Autowired
    private ApiSongStyleService apiSongStyleService;

    @Autowired
    private ApiSongService apiSongService;

    @Autowired
    private ApiPracticeSongService apiPracticeSongService;

    @Autowired
    private ApiUserPracticeSummaryService apiUserPracticeSummaryService;

    @Autowired
    private ApiUserGoldCoinService apiUserGoldCoinService;

    @Autowired
    private ApiUserStageSummaryService apiUserStageSummaryService;

    @Autowired
    private ApiUserSummaryService apiUserSummaryService;

    @Autowired
    private ApiUserPracticeLogService apiUserPracticeLogService;


    public List<PracticeSongFacade> getStyleOnlinePracticeSongList(Integer styleId, Pagination pagination, Long userId) {
        List<ApiPracticeSong> practiceSongList = apiPracticeSongService.getStyleOnlinePracticeSongList(styleId, pagination);
        if (practiceSongList.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> songIdList = new ArrayList<>();
        Map<Integer, ApiPracticeSong> practiceMap = new HashMap<>();
        practiceSongList.stream().forEach(song -> {
            songIdList.add(song.getSongId());
            practiceMap.put(song.getSongId(), song);
        });

        Map<Integer, ApiSong> songMap = apiSongService.getSongListAsMap(songIdList);
        Map<Integer, ApiUserPracticeSummary> statMap = apiUserPracticeSummaryService.getUserPracticeSummaryListBySongIdListAsMap(userId, songIdList);
        List<PracticeSongFacade> facades = new ArrayList<>(practiceSongList.size());

        practiceSongList.stream().forEach(song -> {
            PracticeSongFacade facade = new PracticeSongFacade();

            facade.setExt(song);
            facade.setInfo(songMap.get(song.getSongId()));
            facade.setSummary(statMap.get(song.getSongId()));

            facades.add(facade);
        });

        return facades;
    }

    public List<PracticeLogSongFacade> getPracticeLogSongListByStyleId(Long userId, Integer styleId, Pagination pagination) {
        List<ApiUserPracticeSummary> summaries = apiUserPracticeSummaryService.getUserPracticeSummaryListByStyleId(userId, styleId, pagination);
        if (summaries.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> songIdList = new ArrayList<>();
        Map<Integer, ApiUserPracticeSummary> practiceMap = new HashMap<>();
        summaries.stream().forEach(song -> {
            songIdList.add(song.getSongId());
            practiceMap.put(song.getSongId(), song);
        });

        Map<Integer, ApiSong> songMap = apiSongService.getSongListAsMap(songIdList);
        List<PracticeLogSongFacade> facades = new ArrayList<>(summaries.size());
        summaries.stream().forEach(summary -> {
            PracticeLogSongFacade facade = new PracticeLogSongFacade();

            facade.setInfo(songMap.get(summary.getSongId()));
            facade.setSummary(summary);

            facades.add(facade);
        });
        return facades;
    }

    public List<ApiSongExt> queryPracticeSong(ApiPracticeSongCriteria criteria, Pagination pagination, Long userId) {
        List<ApiSongExt> songList = apiPracticeSongService.queryPracticeSong(criteria, pagination);
        if (songList.isEmpty()) {
            return Collections.emptyList();
        }
        List<Integer> songIdList = new ArrayList<>();
        songList.stream().forEach(song -> songIdList.add(song.getSongId()));
        Map<Integer, ApiUserPracticeSummary> statMap = apiUserPracticeSummaryService.getUserPracticeSummaryListBySongIdListAsMap(userId, songIdList);
        songList.stream().forEach(song -> song.setSummary(statMap.get(song.getSongId())));
        return songList;
    }

    @Transactional
    public void unlockPracticeSongViaGoldCoin(Long userId, Integer songId) throws GoldCoinNotEnoughException {
        UserPracticeSummary summary = apiUserPracticeSummaryService.getUserPracticeSummaryBySongId(songId);
        if (summary != null) {
            return;
        }
        PracticeSong song = apiPracticeSongService.getPracticeSongBySongId(songId);
        if (song == null) {
            return;
        }
        if (song.getUnlockGoldCoin() > 0) {
            int goldCoin = apiUserGoldCoinService.getUserGoldCoin(userId);
            if (song.getUnlockGoldCoin() > goldCoin) {
                throw new GoldCoinNotEnoughException();
            }

            apiUserPracticeSummaryService.addUserPracticeSummaryViaUnlock(userId, song, UnlockType.GOLD_COIN);
            apiUserGoldCoinService.consumeUserGoldCoinAndIncreaseUnlockCount(userId, song.getUnlockGoldCoin());
            apiUserGoldCoinService.consumeLog(userId, GoldCoinEventType.UNLOCK_PRACTICE_SONG, song.getUnlockGoldCoin(), songId.longValue());
        }
    }

    public List<ApiSongStyle> getSongStyleList() {
        return apiSongStyleService.getSongStyleList();
    }

    public void practice(Long userId, UserPracticeRequest request) {
        PracticeSong song = apiPracticeSongService.getPracticeSongBySongId(request.getSongId());
        if (song == null) {
            return;
        }
        UserPracticeSummary summary = apiUserPracticeSummaryService.getUserPracticeSummaryBySongId(request.getSongId());
        if (summary != null) {
            updateUserPracticeSummary(summary, request);
            updateUserSummary(summary, request);
            addUserPracticeLog(summary, request);
            return;
        }

        if (song.getPassStageUnlock() == NO) {
            if (song.getUnlockGoldCoin() >= 0) {
                apiUserPracticeSummaryService.addUserPracticeSummaryViaUnlock(userId, song, UnlockType.NO_NEED_UNLOCK);
                updateUserSummary(summary, request);
                addUserPracticeLog(summary, request);
                return;
            }
            return;
        }

        UserStageSummary stageSummary = apiUserStageSummaryService.getUserStageSummaryBySongId(request.getSongId());
        if (stageSummary.getIsPassed() == YES) {
            apiUserPracticeSummaryService.addUserPracticeSummaryViaUnlock(userId, song, UnlockType.PASS_STAGE);
            updateUserSummary(summary, request);
            addUserPracticeLog(summary, request);
        }
    }


    private void addUserPracticeLog(UserPracticeSummary summary, UserPracticeRequest request) {
        UserPracticeLog log = new UserPracticeLog();
        log.setPracticeScore(request.getPracticeScore());
        log.setPracticeTime(request.getPracticeTime());
        log.setFullScoreBestTime(request.getFullScoreBestTime());
        log.setUserId(summary.getUserId());
        log.setSongId(summary.getSongId());
        log.setPracticeSongId(summary.getPracticeSongId());
        log.setStyleId(summary.getStyleId());
        apiUserPracticeLogService.addPracticeLog(log);
    }

    private void updateUserSummary(UserPracticeSummary summary, UserPracticeRequest request) {
        UserSummary userSummary = new UserSummary();
        userSummary.setTotalPracticeCount(summary.getTotalPracticeCount() + 1);
        userSummary.setTotalPracticeScore(summary.getTotalPracticeScore() + request.getPracticeScore());
        userSummary.setTotalPracticeTime(summary.getTotalPracticeTime() + request.getPracticeTime());
        apiUserSummaryService.updateUserSummaryByUserId(summary.getUserId(), userSummary);
    }

    private void updateUserPracticeSummary(UserPracticeSummary summary, UserPracticeRequest request) {
        UserPracticeSummary update = new UserPracticeSummary();
        update.setId(summary.getId());
        update.setTotalPracticeCount(summary.getTotalPracticeCount() + 1);
        update.setTotalPracticeTime(summary.getTotalPracticeTime() + request.getPracticeTime());
        update.setTotalPracticeScore(summary.getTotalPracticeScore() + request.getPracticeScore());
        if (request.getPracticeScore() > summary.getBestScore()) {
            update.setBestScore(request.getPracticeScore());
        }
        if (request.getFullScoreBestTime() > summary.getFullScoreBestTime()) {
            update.setFullScoreBestTime(request.getFullScoreBestTime());
        }
        apiUserPracticeSummaryService.update(update);
    }
}
