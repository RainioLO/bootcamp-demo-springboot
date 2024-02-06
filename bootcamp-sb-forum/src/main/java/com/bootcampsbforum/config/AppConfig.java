package com.bootcampsbforum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.modelmapper.ModelMapper;

// Library (dependency) or your own classes -> object (bean) -> Spring context
@Configuration
public class AppConfig {

  // service start --> create RestTemplate
  @Bean // should call one time when server start
  RestTemplate restTemplate() { // 引入來new object
    return new RestTemplate();
  }

  @Bean
  ModelMapper ModelMapper() { // 外面的class, new asap
    return new ModelMapper();
  }

}
