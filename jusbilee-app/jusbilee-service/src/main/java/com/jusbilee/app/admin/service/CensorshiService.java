/**
 * zhandc 2016年8月9日
 */
package com.jusbilee.app.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jusbilee.app.admin.dao.CensorshipDao;
import com.jusbilee.app.admin.domain.Censorship;
import com.jusbilee.app.admin.domain.CensorshipCriteria;
import com.jusbilee.app.common.exception.CensorshipAlreadyExistsException;
import com.jusbilee.app.common.exception.UserAlreadyExistsException;

/**
 * @author zhandc 2016年8月9日
 *
 */

@Service
public class CensorshiService {

	@Autowired
	private CensorshipDao censorshipDao;

	public void query(CensorshipCriteria criteria) {
		int total = censorshipDao.count(criteria);
		if (total > 0) {
			List<Censorship> list = censorshipDao.queryList(criteria);
			criteria.setTotal(total);
			criteria.setRows(list);
		}
	}
	
	public void addCensorship(Censorship censorship) throws CensorshipAlreadyExistsException {
		this.checkUsernameExists(censorship.getName());
		censorshipDao.censorshipInsert(censorship);
	}
	
	public void updateCensorship(Censorship censorship) throws CensorshipAlreadyExistsException {
		this.checkUsernameExists(censorship);
		censorshipDao.updateCensorship(censorship);
	}
	
	public void deleteCensorship( long censorshipId){
		censorshipDao.deleteCensorship(censorshipId);
		censorshipDao.deleteCSByCensorshipId(censorshipId);
	}
	
	public Censorship selectById(long censorshipId){
		return censorshipDao.selectById(censorshipId);
	}
	
	public void queryCensorshipSong(CensorshipCriteria criteria) {
		int total = censorshipDao.countCensorshipSong(criteria);
		if (total > 0) {
			List<Censorship> list = censorshipDao.queryCensorshipSongList(criteria);
			criteria.setTotal(total);
			criteria.setRows(list);
		}
	}
	
	public void mulAddCensorshipSong(long censorshipId, String songIdStr ){
		censorshipDao.deleteCSByCensorshipId(censorshipId);
		String[] songIds = songIdStr.split(";");
		for(String id : songIds){
			this.addCensorshipSong(censorshipId, Long.valueOf(id));
		}
	}
	
	public void deleteCSByCensorshipId(long censorshipId){
		censorshipDao.deleteCSByCensorshipId(censorshipId);
	}
	
	public void addCensorshipSong(long censorshipId, long songId){
		censorshipDao.insertCensorshipSong(censorshipId, songId);
	}
	
	private void checkUsernameExists(Censorship _censorship) throws UserAlreadyExistsException {
		Censorship censorship = censorshipDao.selectByName(_censorship.getName());
		if (censorship.getCensorshipId() !=censorship.getCensorshipId()) {
			throw new CensorshipAlreadyExistsException();
		}
	}

	private void checkUsernameExists(String name) throws UserAlreadyExistsException {
		Censorship censorship = censorshipDao.selectByName(name);
		if (censorship != null) {
			throw new CensorshipAlreadyExistsException();
		}
	}

}
