package com.bootcampsbforum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcampsbforum.model.dto.jph.User2;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface RedisOperation {

  @PostMapping(value = "/user2")
  User2 createUser(@RequestParam String key, @RequestBody User2 user2) throws JsonProcessingException;

  @GetMapping(value = "/user2")
  User2 getUser2(@RequestParam String key) throws JsonProcessingException;

}
