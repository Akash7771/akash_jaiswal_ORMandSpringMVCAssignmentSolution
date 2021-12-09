package com.greatlearning.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com.greatlearning")
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.greatlearning.entities"})
@EnableJpaRepositories("com.greatlearning.repositories")
@EnableWebMvc
public class CustomerTrackerCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerTrackerCrmApplication.class, args);
	}

}
