package com.jusbilee.app.config;

import com.rockit.core.http.HttpClientProperties;
import com.rockit.core.http.HttpClientService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Allen on 2016/8/1.
 */
@Configuration
public class HttpClientConfig {
    @Bean
    @ConfigurationProperties(prefix = "httpclient")
    public HttpClientProperties httpClientProperties() {
        return new HttpClientProperties();
    }

    @Bean
    public HttpClientService httpClientService(HttpClientProperties httpClientProperties) {
        return new HttpClientService(httpClientProperties);
    }
}
