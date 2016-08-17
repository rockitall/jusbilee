/**
 * zhandc 2016年8月17日
 */
package com.jusbilee.app.admin.dao.sql;

import com.jusbilee.app.admin.domain.SongStyleCriteria;

/**
 * @author zhandc 2016年8月17日
 *
 */
public class SongStyleDaoProvider {
	
	public String count(SongStyleCriteria criteria){
		
		StringBuilder sb = new StringBuilder(128);
		sb.append(" select count(1) from t_song_style where 1=1 ");
		if(criteria.getStyleName() != null){
			sb.append(" and instr(style_name, #{styleName} ) > 0 ");
		}
		return sb.toString();
	}
	
	public String queryList(SongStyleCriteria criteria){
		StringBuilder sb = new StringBuilder(128);
		sb.append("select id as styleId, style_name as styleName, create_time as createTime ");
		sb.append(" from t_song_style where 1=1");
		if(criteria.getStyleName() != null){
			sb.append(" and instr(style_name, #{styleName} ) > 0 ");
		}
		sb.append(" order by style_name ");
		sb.append(" limit #{rp} offset #{offset}");
		return sb.toString();
	}

}
