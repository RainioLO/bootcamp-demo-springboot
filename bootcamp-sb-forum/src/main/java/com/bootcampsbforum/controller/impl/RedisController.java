package com.bootcampsbforum.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcampsbforum.controller.RedisOperation;
import com.bootcampsbforum.model.dto.jph.User2;
import com.bootcampsbforum.service.RedisService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping(value = "/api/v1")
public class RedisController implements RedisOperation {

  @Autowired
  private RedisService redisService;

  @Override
  public User2 createUser(String key, User2 user)
      throws JsonProcessingException {
    return redisService.createUser(key, user);
  }

  @Override
  public User2 getUser2(String key) throws JsonProcessingException {
    return redisService.getUser2(key);
  }



}
