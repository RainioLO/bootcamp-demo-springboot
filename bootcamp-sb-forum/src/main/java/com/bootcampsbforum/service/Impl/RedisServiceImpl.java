package com.bootcampsbforum.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.bootcampsbforum.infra.RedisHelper;
import com.bootcampsbforum.model.dto.jph.User2;
import com.bootcampsbforum.service.RedisService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RedisServiceImpl implements RedisService {

  // @Autowired
  // private RedisTemplate<String, String> redisTemplate; // similar to RestTemplate which to call Api

  @Autowired
  private RedisHelper redisHelper;

  // @Autowired
  // private ObjectMapper objectMapper;

  // call this method and store in redis
  @Override
  public User2 createUser(String key, User2 user)
      throws JsonProcessingException {
    redisHelper.set(key, user);
    return user;
  }

  @Override
  public User2 getUser2(String key) throws JsonProcessingException {
    return redisHelper.get(key, User2.class);
  }

}
