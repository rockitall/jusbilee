/**
 * zhandc 2016年8月27日
 */
package com.jusbilee.app.admin.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author zhandc 2016年8月27日
 *
 */
public class SongRequests {

	public static class SongParam {
		@NotEmpty(message = "名称不能为空")
		@Length(max = 16, message = "名称不能超过16个字符")
		private String name;

		private String description;


		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name
		 *            the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description
		 *            the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		

	}
}
