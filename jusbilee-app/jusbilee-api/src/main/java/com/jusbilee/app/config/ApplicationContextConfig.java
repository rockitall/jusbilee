package com.jusbilee.app.config;

import com.jusbilee.app.interceptor.AuthenticateInterceptor;
import com.jusbilee.app.redis.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Allen on 2016/7/16.
 */
@Component
public class ApplicationContextConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private RedisCacheService redisCacheService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticateInterceptor(redisCacheService));
    }
}
