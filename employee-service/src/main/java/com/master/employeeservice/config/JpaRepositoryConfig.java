package com.master.employeeservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = { "com.master.employeeservice.repository" })
public class JpaRepositoryConfig {}
