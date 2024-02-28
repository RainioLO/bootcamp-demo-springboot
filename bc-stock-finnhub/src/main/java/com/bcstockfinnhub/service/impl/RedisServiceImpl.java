package com.bcstockfinnhub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcstockfinnhub.infra.RedisHelper;
import com.bcstockfinnhub.model.Profile;
import com.bcstockfinnhub.model.Quote;
import com.bcstockfinnhub.service.RedisService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class RedisServiceImpl implements RedisService {

  @Autowired
  private RedisHelper redishelper;

  @Override
  public Quote createQuote(String key, Quote quote)
      throws JsonProcessingException {
    redishelper.set(key, quote, "30");
    return quote;
  }

  @Override
  public Quote getQuote(String key) throws JsonProcessingException {
    return redishelper.get(key, Quote.class);
  }

  @Override
  public Profile createProfile(String key, Profile profile)
      throws JsonProcessingException {
    redishelper.set(key, profile, "30");
    return profile;
  }

  @Override
  public Profile getProfile(String key) throws JsonProcessingException {
    return redishelper.get(key, Profile.class);
  }
}
