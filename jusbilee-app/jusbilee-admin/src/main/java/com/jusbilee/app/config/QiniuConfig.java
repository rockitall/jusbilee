/**
 * zhandc 2016年8月27日
 */
package com.jusbilee.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jusbilee.app.qiniu.QiniuSDKProperties;

/**
 * @author zhandc 2016年8月27日
 *
 */

@Configuration
public class QiniuConfig {

	@Bean
	@ConfigurationProperties(prefix = "qiniu.sdk")
	public QiniuSDKProperties qiniuSDKProperties() {
		return new QiniuSDKProperties();
	}

}
