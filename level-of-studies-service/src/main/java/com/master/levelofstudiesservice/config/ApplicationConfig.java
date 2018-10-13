package com.master.levelofstudiesservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.master.levelofstudiesservice.config")
public class ApplicationConfig {

    @Autowired
    private Environment env;

    @Bean("mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("custom.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("custom.datasource.url"));
        dataSource.setUsername(env.getProperty("custom.datasource.username"));
        dataSource.setPassword(env.getProperty("custom.datasource.password"));

        return dataSource;
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
