package com.jusbilee.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private Environment environment;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        if (environment.acceptsProfiles("prod", "dev")) {
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