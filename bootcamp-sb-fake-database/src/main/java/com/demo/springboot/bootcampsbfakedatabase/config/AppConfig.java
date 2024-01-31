package com.demo.springboot.bootcampsbfakedatabase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean(name = "tutor") // call by Stringboot when start
  String tutorName() {
    return "Vincent";
  }

  @Bean(name = "tutor2") // call by Stringboot when start
  String tutorName2() {
    return "Oscar";
  }
}
