package com.bccryptocoingecko.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bccryptocoingecko.model.Coin;
import com.bccryptocoingecko.model.CoinDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface RedisOperation {

  @GetMapping(value = "/coin")
  Coin getCoin (@RequestParam String key) throws JsonProcessingException;

  @GetMapping(value = "/coinDTO")
  CoinDTO getCoinDTO (@RequestParam String key) throws JsonProcessingException;

}
