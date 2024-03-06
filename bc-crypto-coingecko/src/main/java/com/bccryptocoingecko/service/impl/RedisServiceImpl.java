package com.bccryptocoingecko.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import com.bccryptocoingecko.infra.RedisHelper;
import com.bccryptocoingecko.infra.Syscode;
import com.bccryptocoingecko.model.Coin;
import com.bccryptocoingecko.model.CoinDTO;
import com.bccryptocoingecko.service.RedisService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class RedisServiceImpl implements RedisService {

  @Autowired
  private RedisHelper redisHelper;

  @Override
  public Coin createCoin(String key, Coin coin) throws JsonProcessingException {
    redisHelper.set(key, coin, "30");
    return coin;
  }

  @Override
  public Coin getCoin(String key) throws JsonProcessingException {
    return redisHelper.get(key, Coin.class);
  }

  @Override
  public CoinDTO createCoinDTO(String key, CoinDTO coinDTO) throws JsonProcessingException {
    redisHelper.set(key, coinDTO, "30");
    return coinDTO;
  }

  @Override
  public CoinDTO getCoinDTO(String key) throws JsonProcessingException {
    return redisHelper.get(key, CoinDTO.class);
  }



}
