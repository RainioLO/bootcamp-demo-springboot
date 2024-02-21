package com.bccryptocoingecko.service;

import com.bccryptocoingecko.model.Coin;
import com.bccryptocoingecko.model.CoinDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface RedisService {

  Coin createCoin(String key, Coin coin) throws JsonProcessingException;

  Coin getCoin(String key) throws JsonProcessingException;

  CoinDTO createCoinDTO(String key, CoinDTO coinDTO) throws JsonProcessingException;

  CoinDTO getCoinDTO(String key) throws JsonProcessingException;

}
