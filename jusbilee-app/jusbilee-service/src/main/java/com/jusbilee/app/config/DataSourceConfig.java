package com.jusbilee.app.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

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
