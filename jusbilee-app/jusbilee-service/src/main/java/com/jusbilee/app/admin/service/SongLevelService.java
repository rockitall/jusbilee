/**
 * zhandc 2016年8月17日
 */
package com.jusbilee.app.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jusbilee.app.admin.dao.SongLevelDao;
import com.jusbilee.app.admin.domain.SongLevel;
import com.jusbilee.app.admin.domain.SongLevelCriteria;
import com.jusbilee.app.admin.domain.SongStyle;

/**
 * @author zhandc 2016年8月17日
 *
 */

@Service
public class SongLevelService {
	
	@Autowired
	private SongLevelDao songLevelDao;
	
	public void add(SongLevel songLevel){
		songLevelDao.songLevelInsert(songLevel);
	}
	
	public void update(SongLevel songLevel){
		songLevelDao.songLevelUpdate(songLevel);
	}
	
	public void delete(long levelId){
		songLevelDao.songLevelDelete(levelId);
	}
	
	public SongLevel selectById(long levelId){
		return songLevelDao.selectById(levelId);
	}
	
	public void query(SongLevelCriteria criteria) {
		int total = songLevelDao.count(criteria);
		if (total > 0) {
			List<SongLevel> list = songLevelDao.queryList(criteria);
			criteria.setTotal(total);
			criteria.setRows(list);
		}
	}

}
