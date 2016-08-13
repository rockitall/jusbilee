/**
 * zhandc 2016年8月8日
 */
package com.jusbilee.app.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jusbilee.app.admin.dao.AppUserAdminDao;
import com.jusbilee.app.admin.domain.AppUserCriteria;
import com.jusbilee.app.user.domain.AppUser;

/**
 * @author zhandc 2016年8月8日
 *
 */

@Service
public class AppUserAdminService {
	
	@Autowired
	private AppUserAdminDao appUserAdminDao;
	
	 public void queryAppUser(AppUserCriteria criteria){
		   int total = appUserAdminDao.statisticsCount(criteria);
		   if(total > 0 ){
			   List<AppUser> list = appUserAdminDao.statisticsList(criteria);
			   criteria.setTotal(total);
			   criteria.setRows(list);
		   }
		   
	   }

}