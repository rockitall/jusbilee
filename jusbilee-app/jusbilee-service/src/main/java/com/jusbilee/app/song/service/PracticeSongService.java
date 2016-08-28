/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.song.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jusbilee.app.mybatis.dao.PracticeSongMapper;
import com.jusbilee.app.song.dao.PracticeSongDao;
import com.jusbilee.app.song.domain.PracticeSong;
import com.jusbilee.app.song.domain.PracticeSongCriteria;

/**
 * @author zhandc 2016年8月28日
 *
 */

@Service
public class PracticeSongService {
	
	@Autowired
	private PracticeSongDao practiceSongDao;
	
	@Autowired
	private PracticeSongMapper practiceSongMapper;
	
	public void query(PracticeSongCriteria criteria) {
		/*int total = songStyleDao.count(criteria);
		if (total > 0) {
			List<SongStyle> list = songStyleDao.queryList(criteria);
			criteria.setTotal(total);
			criteria.setRows(list);
		}*/
		
		List<PracticeSong> list = practiceSongDao.getList(criteria);
//		criteria.setTotal(total);
		criteria.setRows(list);
	}
	
	public void add(PracticeSong practiceSong){
		practiceSongDao.insert(practiceSong);
	}
	
	public void delete(long id ){
		practiceSongDao.delete(id);
	}
	
	public void update(PracticeSong practiceSong){
		practiceSongDao.update(practiceSong);
	}

}
