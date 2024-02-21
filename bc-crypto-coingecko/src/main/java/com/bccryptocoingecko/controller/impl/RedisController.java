package com.bccryptocoingecko.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bccryptocoingecko.controller.RedisOperation;
import com.bccryptocoingecko.model.Coin;
import com.bccryptocoingecko.model.CoinDTO;
import com.bccryptocoingecko.service.RedisService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping(value = "/redis/api/v1")
public class RedisController implements RedisOperation {

  @Autowired
  private RedisService redisService;

  @Override
  public Coin getCoin(String key) throws JsonProcessingException {
    if (redisService.getCoin(key) == null) {
      throw new IllegalArgumentException();
    }
    return redisService.getCoin(key);
  }

  @Override
  public CoinDTO getCoinDTO(String key) throws JsonProcessingException {
    if (redisService.getCoin(key) == null) {
      throw new IllegalArgumentException();
    }
    return redisService.getCoinDTO(key);
  }

}
