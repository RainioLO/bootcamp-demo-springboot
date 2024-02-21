package com.bccryptocoingecko.infra;

import java.time.Duration;
import java.util.Objects;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RedisHelper {

  private RedisTemplate<String, String> redisTemplate;

  private ObjectMapper objectMapper; // get from @Beans

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

  public void set(String key, Object value) throws JsonProcessingException {
    String serializedData = objectMapper.writeValueAsString(value);
    this.redisTemplate.opsForValue().set(key, serializedData);
  }

  
  public void set(String key, Object value,String time) throws JsonProcessingException {
    String serializedData = objectMapper.writeValueAsString(value);
    this.redisTemplate.opsForValue().set(key, serializedData);
    this.redisTemplate.expire(key, Duration.ofSeconds(Long.valueOf(time)));
  }

  public <T> T get(String key, Class<T> clazz) throws JsonProcessingException {
    String value = (String) this.redisTemplate.opsForValue().get(key);
    return objectMapper.readValue(value, clazz);
  }


}
