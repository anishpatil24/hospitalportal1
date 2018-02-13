package com.hospitalportal1.hospitalportal1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.hospitalportal1.hospitalportal1.Repository"})
@SpringBootApplication
public class Hospitalportal1Application {

	public static void main(String[] args) {
		SpringApplication.run(Hospitalportal1Application.class, args);
	}
}
