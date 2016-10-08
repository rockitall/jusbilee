package com.jusbilee.app.api.practice.service;

import com.jusbilee.app.api.practice.dao.ApiPracticeSongDao;
import com.jusbilee.app.api.practice.domain.ApiPracticeSong;
import com.jusbilee.app.api.practice.domain.ApiSongExt;
import com.jusbilee.app.api.practice.param.ApiPracticeSongCriteria;
import com.jusbilee.app.mybatis.dao.PracticeSongMapper;
import com.jusbilee.app.mybatis.pojo.PracticeSong;
import com.jusbilee.app.mybatis.pojo.PracticeSongCriteria;
import com.rockit.core.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Allen on 2016/9/10.
 */
@Service
public class ApiPracticeSongService {
    @Autowired
    private ApiPracticeSongDao apiPracticeSongDao;
    @Autowired
    private PracticeSongMapper practiceSongMapper;

    public List<ApiPracticeSong> getStyleOnlinePracticeSongList(Integer styleId, Pagination pagination) {
        return apiPracticeSongDao.getStyleOnlinePracticeSongList(styleId, pagination);
    }

    public PracticeSong getPracticeSongBySongId(Integer songId) {
        PracticeSongCriteria criteria = new PracticeSongCriteria();
        criteria.createCriteria().andSongIdEqualTo(songId);
        List<PracticeSong> songs = practiceSongMapper.selectByExample(criteria);
        return songs.isEmpty() ? null : songs.get(0);
    }

    public List<ApiSongExt> queryPracticeSong(ApiPracticeSongCriteria criteria, Pagination pagination) {
        return apiPracticeSongDao.queryPracticeSong(criteria, pagination);
    }
}
