package com.bccryptocoingecko.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @Bean 
  ModelMapper ModelMapper(){
    return new ModelMapper();
  }
  
}
