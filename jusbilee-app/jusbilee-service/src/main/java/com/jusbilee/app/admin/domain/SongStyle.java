/**
 * zhandc 2016年8月17日
 */
package com.jusbilee.app.admin.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhandc 2016年8月17日
 *
 */
public class SongStyle {
	private Long styleId;
	private String styleName;
	private Date createTime;
	
	private SimpleDateFormat dfm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	/**
	 * @return the id
	 */
	public Long getId() {
		return styleId;
	}

	/**
	 * @param id the id to set
	 */
	public void setStyleId(Long styleId) {
		this.styleId = styleId;
	}

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

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return this.createTime == null ? "" : dfm.format(createTime);
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
