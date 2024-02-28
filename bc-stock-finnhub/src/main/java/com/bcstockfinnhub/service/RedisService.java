package com.bcstockfinnhub.service;

import com.bcstockfinnhub.model.Profile;
import com.bcstockfinnhub.model.Quote;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface RedisService {

  Quote createQuote(String key, Quote quote) throws JsonProcessingException;
  Quote getQuote(String key) throws JsonProcessingException;

  Profile createProfile(String key, Profile profile) throws JsonProcessingException;
  Profile getProfile(String key) throws JsonProcessingException;
}
