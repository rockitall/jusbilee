/**
 * zhandc 2016年8月9日
 */
package com.jusbilee.app.admin.dao.sql;

import org.apache.ibatis.jdbc.SQL;

import com.jusbilee.app.admin.domain.Censorship;
import com.jusbilee.app.admin.domain.CensorshipCriteria;

/**
 * @author zhandc 2016年8月9日
 *
 */
public class CensorshipDaoProvider {

	public String censorshipInsert(Censorship censorship) {
		return new SQL() {
			{
				INSERT_INTO("t_censorship");
				VALUES("name", "#{name}");
				if (censorship.getDescription() != null) {
					VALUES("description", "#{description}");
				}
				VALUES("create_time", "now()");
			}
		}.toString();
	}
	
	public String count(CensorshipCriteria criteria){
		StringBuilder sb = new StringBuilder(128);
		sb.append("select count(1) from t_censorship ");
		if(criteria.getCensorshipName() != null){
			sb.append("where instr(name, #{censorshipName}) > 0 ");
		}
		return sb.toString();
		
	}
	
	public String queryList(CensorshipCriteria criteria){
		StringBuilder sb = new StringBuilder(512);
		sb.append("select censorship_id as censorshipId, name, description, create_time as createTime, update_time as updateTime ");
		sb.append("from  t_censorship ");
		if(criteria.getCensorshipName() != null){
			sb.append("where instr(name, #{censorshipName}) > 0 ");
		}
		sb.append("order by censorship_id ");
		return sb.toString();
		
	}
	
	public String countCensorshipSong(CensorshipCriteria criteria){
		StringBuilder sb = new StringBuilder(128);
		sb.append("select count(1) from t_censorship_song ");
		if(criteria.getCensorshipIdQuery() != null){
			sb.append("where censorship_id = #{censorshipIdQuery} ");
		}
		return sb.toString();
		
	}
	
	public String queryCensorshipSongList(CensorshipCriteria criteria){
		StringBuilder sb = new StringBuilder(512);
		sb.append("select t.censorship_id as censorshipId, c.name, t.song_id as songId, s.song_name as songName, s.song_style as songStyle  ");
		sb.append("from t_censorship_song t ");
		sb.append("LEFT JOIN t_censorship c ");
		sb.append("on t.censorship_id=c.censorship_id ");
		sb.append("left join t_song_message s ");
		sb.append("on t.song_id = s.song_id ");
		if(criteria.getCensorshipIdQuery() != null){
			sb.append("where t.censorship_id = #{censorshipIdQuery} ");
		}
		sb.append("order by songName ");
		return sb.toString();
		
	}

}
