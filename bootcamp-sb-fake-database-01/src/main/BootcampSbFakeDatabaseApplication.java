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

  private static ConfigurableApplicationContext cac;

  public static ConfigurableApplicationContext getSpringContext() {
    return cac;
  }

  public static void main(String[] args) {
    System.out.println("start app fake database");

    // Spring Context
    cac = SpringApplication.run(BootcampSbFakeDatabaseApplication.class, args);

    String[] beans = cac.getBeanDefinitionNames();

    for (String bean : beans) {
      System.out.println("Bean=" + bean);
    }

    System.out.println("end app fake database");
  }
}
