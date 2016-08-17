/**
 * zhandc 2016年8月17日
 */
package com.jusbilee.app.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jusbilee.app.admin.dao.SongStyleDao;
import com.jusbilee.app.admin.domain.SongStyle;
import com.jusbilee.app.admin.domain.SongStyleCriteria;

/**
 * @author zhandc 2016年8月17日
 *
 */

@Service
public class SongStyleService {

	@Autowired
	private SongStyleDao songStyleDao;
	
	public void add(SongStyle songStyle){
		 songStyleDao.songStyleInsert(songStyle);
	}
	
	public void update(SongStyle songStyle){
		songStyleDao.songStyleUpdate(songStyle);
	}
	
	public void delete(long styleId){
		songStyleDao.songStyleDelete(styleId);
	}
	
	public SongStyle selectById(long styleId){
		return songStyleDao.selectById(styleId);
	}
	
	public void query(SongStyleCriteria criteria) {
		int total = songStyleDao.count(criteria);
		if (total > 0) {
			List<SongStyle> list = songStyleDao.queryList(criteria);
			criteria.setTotal(total);
			criteria.setRows(list);
		}
	}
}
