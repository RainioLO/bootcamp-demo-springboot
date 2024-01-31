package com.demo.springboot.bootcampsbfakedatabase;

import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
// consist of these three @SpringBootConfiguration, @EnableAutoConfiguration, @ComponentScan
// @Component --> Controller + Service + Repository
public class BootcampSbFakeDatabaseApplication {

	private static ConfigurableApplicationContext cac; // bean

	public static ConfigurableApplicationContext getStringContext(){ // from this to get object from the context
		return cac;
	}


	public static void main(String[] args) {
		System.out.println("Start app fake database");
		// Spring Context
		cac = SpringApplication.run(BootcampSbFakeDatabaseApplication.class, args);

		String[] beans = cac.getBeanDefinitionNames(); // return string[]

		for (String bean : beans){
			System.out.println("Bean=" + bean);
		}
		System.out.println("End app fake database");
	}

}
