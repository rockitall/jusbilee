/**
 * zhandc 2016年8月17日
 */
package com.jusbilee.app.admin.domain;

import com.rockit.core.pojo.Pager;

/**
 * @author zhandc 2016年8月17日
 *
 */
public class SongStyleCriteria extends Pager<SongStyle>{
	
	private String styleName;

	/**
	 * @return the styleName
	 */
	public String getStyleName() {
		return styleName;
	}

	/**
	 * @param styleName the styleName to set
	 */
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}
	

}
