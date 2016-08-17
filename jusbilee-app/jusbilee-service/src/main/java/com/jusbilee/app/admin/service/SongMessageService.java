/**
 * zhandc 2016年8月17日
 */
package com.jusbilee.app.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jusbilee.app.admin.dao.SongMessageDao;
import com.jusbilee.app.admin.domain.SongMessage;
import com.jusbilee.app.admin.domain.SongMessageCriteria;

/**
 * @author zhandc 2016年8月17日
 *
 */

@Service
public class SongMessageService {

	@Autowired
	private SongMessageDao songMessageDao;
	
	public void songMseeageInsert(SongMessage songMessage){
		songMessageDao.songMessageInsert(songMessage);
	}
	
	public void songMseeageModify(SongMessage songMessage){
		songMessageDao.songMessageUpdate(songMessage);
	}
	

	public void query(SongMessageCriteria criteria) {
		int total = songMessageDao.songMessageCount(criteria);
		if (total > 0) {
			List<SongMessage> list = songMessageDao.songMessageQueryList(criteria);
			criteria.setTotal(total);
			criteria.setRows(list);
		}
	}
	
	public SongMessage selectById(long songId){
		return songMessageDao.selectById(songId);
	}
}
