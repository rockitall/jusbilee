package com.jusbilee.app.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * Created by Allen on 2016/7/16.
 */
@Configuration
public class DataSourceConfig {
    @Bean(destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties(prefix = "datasource.jdbc")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}
