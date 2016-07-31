package com.jusbilee.app.config;

import com.jusbilee.app.interceptor.AuthenticateInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Allen on 2016/7/16.
 */
@Component
public class ApplicationContextConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticateInterceptor());
    }
}
