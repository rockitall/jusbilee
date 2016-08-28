/**
 * zhandc 2016年8月28日
 */
package com.jusbilee.app.song.dao.sql;

import com.jusbilee.app.song.domain.PracticeSongCriteria;

/**
 * @author zhandc 2016年8月28日
 *
 */
public class PracticeSongDaoSqlProvider {
	
	public String getList(PracticeSongCriteria criteria){
		StringBuilder sb = new StringBuilder(256);
		sb.append("select p.id as id, p.song_id as songId, p.style_id as styleId ,s.name as songName, s2.name as styleName, p.lock_gold_coin as lockGoldCoin, p.create_time as createTime ");
		sb.append(" from t_practice_song p");
		sb.append(" left join t_song s on p.song_id=s.id ");
		if(criteria.getSongName() != null){
			sb.append(" and instr(s.name, #{songName}) > 0 ");
		}
		sb.append("left join t_song_style s2 on p.style_id = s2.id ");
		sb.append(" where p.is_deleted = 0 ");
		if(criteria.getStyleId() != null){
			sb.append(" and p.style_id = #{styleId} ");
		}
		
		sb.append(" order by songName ");
		sb.append(" limit #{rp} offset #{offset}");
		return sb.toString();
	}

}
