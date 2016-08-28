/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.song.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jusbilee.app.song.dao.StageSongDao;
import com.jusbilee.app.song.domain.StageSongDomain;
import com.jusbilee.app.song.domain.StageSongDomainCriteria;

/**
 * @author zhandc 2016年8月28日
 *
 */

@Service
public class StageSongService {

	@Autowired
	private StageSongDao stageSongDao;
	

	public void query(StageSongDomainCriteria criteria) {
		/*int total = songStyleDao.count(criteria);
		if (total > 0) {
			List<SongStyle> list = songStyleDao.queryList(criteria);
			criteria.setTotal(total);
			criteria.setRows(list);
		}*/
		
		List<StageSongDomain> list = stageSongDao.getList(criteria);
		criteria.setRows(list);
	}
	
	public void add(StageSongDomain stageSongDomain){
		stageSongDao.insert(stageSongDomain);
	}
	
	public void delete(int id ){
		stageSongDao.delete(id);
	}
	
	public void update(StageSongDomain stageSongDomain){
		stageSongDao.update(stageSongDomain);
	}
}
