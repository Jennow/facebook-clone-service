package com.jeniferprochnow.facebookcloneservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.jeniferprochnow.facebookcloneservice"})
@EntityScan(basePackages = {"com.jeniferprochnow.facebookcloneservice.entity"})
public class FacebookCloneServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacebookCloneServiceApplication.class, args);
	}

}
