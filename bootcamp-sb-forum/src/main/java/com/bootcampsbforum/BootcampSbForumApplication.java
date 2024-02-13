package com.bootcampsbforum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Test event - Stimulate Spring Boot App Run
// it can cheak the pom, whether ok or not to find the bean
// if no that data, cant find data source --> fail
public class BootcampSbForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampSbForumApplication.class, args);
	}

}
