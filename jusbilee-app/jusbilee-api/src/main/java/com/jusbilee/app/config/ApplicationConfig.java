package com.jusbilee.app.config;

import com.jusbilee.app.qiniu.QiniuSDKProperties;
import com.jusbilee.app.qiniu.QiniuSdkAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by Allen on 2016/8/29.
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public QiniuSdkAuth qiniuSdkAuth(QiniuSDKProperties properties) {
        return QiniuSdkAuth.create(properties.getAccessKey(), properties.getSecretKey());
    }
    
    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(3);
        return executor;
    }
}
