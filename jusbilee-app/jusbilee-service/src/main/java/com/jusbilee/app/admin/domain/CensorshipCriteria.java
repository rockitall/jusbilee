/**
 * zhandc 2016年8月9日
 */
package com.jusbilee.app.admin.domain;

import com.jusbilee.app.common.page.Pager;

/**
 * @author zhandc 2016年8月9日
 *
 */
public class CensorshipCriteria extends Pager<Censorship>{

	private String censorshipName;
	private Long censorshipIdQuery;
	/**
	 * @return the censorshipName
	 */
	public String getCensorshipName() {
		return censorshipName;
	}
	/**
	 * @param censorshipName the censorshipName to set
	 */
	public void setCensorshipName(String censorshipName) {
		this.censorshipName = censorshipName;
	}
	/**
	 * @return the censorshipIdQuery
	 */
	public Long getCensorshipIdQuery() {
		return censorshipIdQuery;
	}
	/**
	 * @param censorshipIdQuery the censorshipIdQuery to set
	 */
	public void setCensorshipIdQuery(long censorshipIdQuery) {
		this.censorshipIdQuery = censorshipIdQuery;
	}
	
	
}
