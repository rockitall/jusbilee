/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.song.dao.sql;

import com.jusbilee.app.song.domain.StageSongDomainCriteria;

/**
 * @author zhandc 2016年8月28日
 *
 */
public class StageSongDaoSqlProvider {
	
	public String getList(StageSongDomainCriteria criteria){
		StringBuilder sb = new StringBuilder(256);
		sb.append("select st.id as id, st.song_id as songId, so.name as songName, st.stage_level_id as stageLevelId, ");
		sb.append(" l.name as stageName, st.pass_score as passScore, st.create_time as createTime");
		sb.append(" from t_stage_song st ");
		sb.append("left join t_song so on st.song_id = so.id ");
		if(criteria.getSongName() != null){
			sb.append(" and instr( so.name, #{songName}) > 0 ");
		}
		sb.append("left join t_stage_level l on st.stage_level_id = l.id ");
		if(criteria.getStageId() != null){
			sb.append(" and l.id = #{stageId} ");
		}
		sb.append(" where st.is_deleted = 0 ");
		sb.append(" order by songName ");
		sb.append(" limit #{rp} offset #{offset}");
		return sb.toString();
	}

}
