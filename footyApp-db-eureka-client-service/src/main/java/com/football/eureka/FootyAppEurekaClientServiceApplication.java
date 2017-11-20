package com.football.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories
public class FootyAppEurekaClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootyAppEurekaClientServiceApplication.class, args);
	}
}
