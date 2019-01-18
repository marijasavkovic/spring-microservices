package com.master.courseservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = { "com.master.courseservice.repository" })
public class JpaRepositoryConfig {}
