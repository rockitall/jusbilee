package com.jusbilee.app.config;

import com.jusbilee.app.qiniu.QiniuSDKProperties;
import com.jusbilee.app.qiniu.QiniuSdkAuth;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by Allen on 2016/8/29.
 */
@Configuration
@EnableAsync
public class ApplicationConfig {
    @Bean
    public QiniuSdkAuth qiniuSdkAuth(QiniuSDKProperties properties) {
        return QiniuSdkAuth.create(properties.getAccessKey(), properties.getSecretKey());
    }

    @Bean(name = "raceExecutor")
    @ConfigurationProperties(prefix = "executor.race")
    public TaskExecutor taskExecutor() {
        return new ThreadPoolTaskExecutor();
    }
}
