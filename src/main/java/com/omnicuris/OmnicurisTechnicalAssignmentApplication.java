package com.omnicuris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class OmnicurisTechnicalAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmnicurisTechnicalAssignmentApplication.class, args);
	}

}
