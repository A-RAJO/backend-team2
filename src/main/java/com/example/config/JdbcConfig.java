package com.example.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
@RequiredArgsConstructor
public class JdbcConfig {

    private final DataSourceProperties dataSourceProperties;

    @Bean
    public DataSource datasource(){
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUsername(dataSourceProperties.getUsername());
        datasource.setPassword(dataSourceProperties.getPassword());
        datasource.setDriverClassName(dataSourceProperties.getDriverClassName());
        datasource.setUrl(dataSourceProperties.getUrl());
        return datasource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate() { return new JdbcTemplate(datasource()); }


    @Bean(name = "tm1")
    public PlatformTransactionManager transactionManager() { return new DataSourceTransactionManager(datasource()); }

}