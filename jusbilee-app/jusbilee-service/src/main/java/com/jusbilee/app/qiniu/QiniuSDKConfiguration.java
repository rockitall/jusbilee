package com.jusbilee.app.qiniu;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Allen on 2016/8/26.
 */
@Configuration
public class QiniuSDKConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "qiniu.sdk")
    public QiniuSDKProperties qiniuSDKProperties() {
        return new QiniuSDKProperties();
    }
}
