/**
 * zhandc 2016年8月17日
 */
package com.jusbilee.app.admin.dao.sql;

import com.jusbilee.app.admin.domain.SongLevelCriteria;

/**
 * @author zhandc 2016年8月17日
 *
 */
public class SongLevelDaoProvider {

	public String count(SongLevelCriteria criteria) {

		StringBuilder sb = new StringBuilder(128);
		sb.append(" select count(1) from t_song_level where 1=1 ");
		if (criteria.getLevelName() != null) {
			sb.append(" and instr(level_name, #{levelName} ) > 0 ");
		}
		return sb.toString();
	}

	public String queryList(SongLevelCriteria criteria) {
		StringBuilder sb = new StringBuilder(128);
		sb.append("select id as levelId, level_name as levelName, create_time as createTime ");
		sb.append(" from t_song_level where 1=1");
		if (criteria.getLevelName() != null) {
			sb.append(" and instr(level_name, #{levelName} ) > 0 ");
		}
		sb.append(" order by level_name ");
		sb.append(" limit #{rp} offset #{offset}");
		return sb.toString();
	}

}
