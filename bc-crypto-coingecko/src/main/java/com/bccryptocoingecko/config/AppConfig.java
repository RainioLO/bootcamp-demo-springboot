package com.bccryptocoingecko.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.client.RestTemplate;
import com.bccryptocoingecko.infra.RedisHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  ModelMapper ModelMapper() {
    return new ModelMapper();
  }

  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  @Bean
  RedisHelper redisHelper(RedisConnectionFactory factory,
      ObjectMapper objectMapper) {
    return new RedisHelper(factory, objectMapper);
  }


}
