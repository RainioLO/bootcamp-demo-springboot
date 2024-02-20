package com.bootcampsbforum.service;

import com.bootcampsbforum.model.dto.jph.User2;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface RedisService {

  User2 createUser(String key, User2 user) throws JsonProcessingException;

  User2 getUser2(String key) throws JsonProcessingException;
  
}
