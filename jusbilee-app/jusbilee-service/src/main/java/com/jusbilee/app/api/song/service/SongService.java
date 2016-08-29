package com.jusbilee.app.api.song.service;


import com.jusbilee.app.mybatis.dao.SongMapper;
import com.jusbilee.app.mybatis.pojo.Song;
import com.jusbilee.app.mybatis.pojo.SongCriteria;

import java.util.List;

/**
 * Created by Allen on 2016/8/21.
 */
public class SongService {
    private SongMapper mapper;

    public List<Song> querySongs() {
        SongCriteria criteria = new SongCriteria();
        criteria.createCriteria().andIdEqualTo(1);
        criteria.setLimit(10);
        criteria.setOffset(0);

        return mapper.selectByExample(criteria);
    }
}
