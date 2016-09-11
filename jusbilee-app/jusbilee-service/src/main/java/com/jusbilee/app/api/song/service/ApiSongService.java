package com.jusbilee.app.api.song.service;

import com.jusbilee.app.api.song.dao.ApiSongDao;
import com.jusbilee.app.api.song.domain.ApiSong;
import com.rockit.core.utils.IdentityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2016/9/10.
 */
@Service
public class ApiSongService {
    @Autowired
    private ApiSongDao apiSongDao;

    public List<ApiSong> getSongListByIdList(List<Integer> songIdList) {
        return apiSongDao.getSongListByIdList(songIdList);
    }

    public Map<Integer, ApiSong> getSongListAsMap(List<Integer> songIdList) {
        List<ApiSong> songs = apiSongDao.getSongListByIdList(songIdList);
        return IdentityUtils.asMap(songs, v -> v.getSongId());
    }
}
