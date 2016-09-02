package com.jusbilee.app.api.song.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jusbilee.app.mybatis.dao.SongMapper;
import com.jusbilee.app.mybatis.pojo.Song;
import com.jusbilee.app.mybatis.pojo.SongCriteria;
import com.rockit.core.Constants;

/**
 * Created by Allen on 2016/8/21.
 */

@Service
public class SongService {
	
	@Autowired
    private SongMapper mapper;

    public List<Song> querySongs() {
        SongCriteria criteria = new SongCriteria();
        criteria.createCriteria().andIsDeletedEqualTo(Constants.BOOL.NO);
//      criteria.createCriteria().andNameLike(sss)
        criteria.setLimit(100);
        criteria.setOffset(0);
        criteria.setOrderByClause(" name asc, create_time desc");

        return mapper.selectByExample(criteria);
    }
    
    public void addSong(Song song){
    	mapper.insertSelective(song);
    }
    
    public void delete(Integer id){
    	Song song = new Song();
    	song.setId(id);
    	song.setIsDeleted(Constants.BOOL.YES);
    	mapper.updateByPrimaryKeySelective(song);
    }
    
    public Song selectById(Integer id){
    	return mapper.selectByPrimaryKey(id);
    }
    
    public void update(Song song){
    	mapper.updateByPrimaryKeySelective(song);
    }
}
