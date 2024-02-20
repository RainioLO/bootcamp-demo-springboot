package com.bootcampsbforum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.client.RestTemplate;
import com.bootcampsbforum.infra.RedisHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
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

  @Bean
  RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory,
      ObjectMapper objectMapper) {
    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>(); // redisTemplate is higher level class
    redisTemplate.setConnectionFactory(factory);
    redisTemplate.setKeySerializer(RedisSerializer.string()); //key
    redisTemplate.setValueSerializer(RedisSerializer.json()); //key
    redisTemplate.afterPropertiesSet();
    // Jackson2JsonRedisSerializer<Object> serializer =
    // new Jackson2JsonRedisSerializer<>(objectMapper, Object.class);
    // redisTemplate.setValueSerializer(serializer);
    return redisTemplate;
  }

  @Bean
  ObjectMapper objectMapper() { // from pointer to new object
    return new ObjectMapper(); // put in context, get by autowire
  }

  @Bean
  RedisHelper redisHelper(RedisConnectionFactory factory,
      ObjectMapper objectMapper) {
    return new RedisHelper(factory, objectMapper);
  }
}
