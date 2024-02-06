package com.vtxlab.bootcamp.bootcampsbfakedatabase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean(name = "tutor")
  String tutorName() {
    return "Vincent";
  }

  @Bean(name = "tutor2")
  String tutorName2() {
    return "Oscar";
  }

}
