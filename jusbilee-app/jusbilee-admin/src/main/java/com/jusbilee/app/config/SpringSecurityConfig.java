package com.jusbilee.app.config;

import com.jusbilee.app.security.CaptchaVerifyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.aspectj.AspectJMethodSecurityInterceptor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private Environment environment;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        if (environment.acceptsProfiles("prod", "home")) {
            CaptchaVerifyFilter filter = new CaptchaVerifyFilter();
            http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
            http.
                    authorizeRequests()
                    .antMatchers("/admin/assets/**", "/admin/captcha").permitAll()
                    .anyRequest().authenticated()
                    .and().formLogin()
                    .loginPage("/admin/login").successForwardUrl("/admin/index")
                    .permitAll();
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}