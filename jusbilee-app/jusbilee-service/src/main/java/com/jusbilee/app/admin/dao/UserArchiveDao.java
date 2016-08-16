/**
 * zhandc 2016年8月15日
 */
package com.jusbilee.app.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.jusbilee.app.admin.dao.sql.UserArchiveDaoprovider;
import com.jusbilee.app.admin.domain.UserArchive;
import com.jusbilee.app.admin.domain.UserArchiveCriteria;

/**
 * @author zhandc 2016年8月15日
 *
 */

@Mapper
public interface UserArchiveDao {
	
	@InsertProvider(type = UserArchiveDaoprovider.class, method = "archiveInsert")
	void archiveInsert(UserArchive userArchive);
	
	@UpdateProvider(type = UserArchiveDaoprovider.class, method = "archiveUpdate")
	void archiveUpdate(UserArchive userArchive);
	
	@SelectProvider(type = UserArchiveDaoprovider.class, method = "selectUserArchive")
	UserArchive selectUserArchive(@Param("userId") long userId);
	
	@SelectProvider(type = UserArchiveDaoprovider.class, method = "selectbyId")
	UserArchive selectbyId(@Param("userId")  long userId);
	
	@SelectProvider(type = UserArchiveDaoprovider.class, method = "userFriends")
	List<UserArchive> userFriends(@Param("userId")  long userId);
	
	@SelectProvider(type = UserArchiveDaoprovider.class, method = "queryUserFriends")
	List<UserArchive> queryUserFriends(UserArchiveCriteria criteria);
	
	@SelectProvider(type = UserArchiveDaoprovider.class, method = "countUserFriends")
	int countUserFriends(UserArchiveCriteria criteria);

}
