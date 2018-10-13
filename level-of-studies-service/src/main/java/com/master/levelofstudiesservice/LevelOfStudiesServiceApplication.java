package com.master.levelofstudiesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LevelOfStudiesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LevelOfStudiesServiceApplication.class, args);
	}
}
