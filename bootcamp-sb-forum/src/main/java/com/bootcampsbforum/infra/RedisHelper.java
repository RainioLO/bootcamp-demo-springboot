package com.bootcampsbforum.infra;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// @Component
public class RedisHelper {

  // @Autowired // approach 1: field injection
  private RedisTemplate<String, String> redisTemplate; // 開bean add to context

  private ObjectMapper objectMapper;

  // dependency injection: approach 1: service start

  public RedisHelper(RedisTemplate<String, String> redisTemplate,
      ObjectMapper objectmapper) {
    Objects.requireNonNull(redisTemplate);
    Objects.requireNonNull(objectmapper);
    this.redisTemplate = redisTemplate;
    this.objectMapper = objectmapper;
  }

  public RedisHelper(RedisConnectionFactory factory,
      ObjectMapper objectMapper) { // spring context
    Objects.requireNonNull(objectMapper);
    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>(); // redisTemplate is higher level class
    redisTemplate.setConnectionFactory(factory);
    redisTemplate.setKeySerializer(RedisSerializer.string());
    redisTemplate.setValueSerializer(RedisSerializer.json());
    redisTemplate.afterPropertiesSet();
    this.redisTemplate = redisTemplate;
    this.objectMapper = objectMapper;
  }

  // instance methods
  public void set(String key, Object value) throws JsonProcessingException {
    String serializedData = objectMapper.writeValueAsString(value);
    this.redisTemplate.opsForValue().set(key, serializedData); // confirm not NPEss
  }

  // that type is that type
  public <T> T get(String key, Class<T> clazz) throws JsonProcessingException{
    String value = this.redisTemplate.opsForValue().get(key); //before deserialize value //j unit to locate work or not...
    return objectMapper.readValue(value, clazz);
  }

}
