package com.jusbilee.app.config;

import com.jusbilee.app.security.AdminUserDataUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private Environment environment;

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        if(environment.acceptsProfiles("prod")) {

        http.
                authorizeRequests()
                .antMatchers("/admin/assets/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/admin/login")
                .permitAll();
//        }
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(new AdminUserDataUserDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
//    }
}