package com.jusbilee.app.api.practice.service;

import com.jusbilee.app.api.practice.dao.ApiSongStyleDao;
import com.jusbilee.app.api.practice.domain.ApiSongStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Allen on 2016/9/10.
 */
@Service
public class ApiSongStyleService {
    @Autowired
    private ApiSongStyleDao apiSongStyleDao;

    public List<ApiSongStyle> getSongStyleList() {
        return apiSongStyleDao.getAllSongStyle();
    }
}
