package com.master.departmentservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = { "com.master.departmentservice.repository" })
public class JpaRepositoryConfig {}
