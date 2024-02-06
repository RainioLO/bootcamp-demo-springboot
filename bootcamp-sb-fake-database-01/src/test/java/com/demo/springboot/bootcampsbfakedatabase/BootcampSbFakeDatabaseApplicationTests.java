package com.demo.springboot.bootcampsbfakedatabase;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // Stimulate the actual process of "mvn spring-boot:run"
// Testing @SpringBootApplication -> @ComponentScan + @Autowired
// To trigger @SpringBootTest, we use "mvn clean test"

class BootcampSbFakeDatabaseApplicationTests {

	// In @SpringBootTest env,
	// the spring context will contain all your custom beans
	// i.e. @Controller, @Service, @Configuration, @Bean



	@Test // At least one @Test to start up test environment
	void contextLoads() {
	}

}
