/**
 * zhandc 2016年8月27日
 */
package com.jusbilee.app.admin.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

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

		private MultipartFile iconUrl;
		private MultipartFile opernScreenshotUrl;
		private MultipartFile opernUrl;
		private MultipartFile wavPlayUrl;
		private MultipartFile midiPlayUrl;

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

		/**
		 * @return the iconUrl
		 */
		public MultipartFile getIconUrl() {
			return iconUrl;
		}

		/**
		 * @param iconUrl
		 *            the iconUrl to set
		 */
		public void setIconUrl(MultipartFile iconUrl) {
			this.iconUrl = iconUrl;
		}

		/**
		 * @return the opernScreenshotUrl
		 */
		public MultipartFile getOpernScreenshotUrl() {
			return opernScreenshotUrl;
		}

		/**
		 * @param opernScreenshotUrl
		 *            the opernScreenshotUrl to set
		 */
		public void setOpernScreenshotUrl(MultipartFile opernScreenshotUrl) {
			this.opernScreenshotUrl = opernScreenshotUrl;
		}

		/**
		 * @return the opernUrl
		 */
		public MultipartFile getOpernUrl() {
			return opernUrl;
		}

		/**
		 * @param opernUrl
		 *            the opernUrl to set
		 */
		public void setOpernUrl(MultipartFile opernUrl) {
			this.opernUrl = opernUrl;
		}

		/**
		 * @return the wavPlayUrl
		 */
		public MultipartFile getWavPlayUrl() {
			return wavPlayUrl;
		}

		/**
		 * @param wavPlayUrl
		 *            the wavPlayUrl to set
		 */
		public void setWavPlayUrl(MultipartFile wavPlayUrl) {
			this.wavPlayUrl = wavPlayUrl;
		}

		/**
		 * @return the midiPlayUrl
		 */
		public MultipartFile getMidiPlayUrl() {
			return midiPlayUrl;
		}

		/**
		 * @param midiPlayUrl
		 *            the midiPlayUrl to set
		 */
		public void setMidiPlayUrl(MultipartFile midiPlayUrl) {
			this.midiPlayUrl = midiPlayUrl;
		}

	}
}
