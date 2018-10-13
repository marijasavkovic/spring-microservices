package com.master.levelofstudiesservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = { "com.master.levelofstudiesservice.repository" })
public class JpaRepositoryConfig {}
