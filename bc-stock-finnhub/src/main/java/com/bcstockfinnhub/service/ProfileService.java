package com.bcstockfinnhub.service;

import com.bcstockfinnhub.model.Profile;

public interface ProfileService {

  Profile getProfile(String symbol) throws Exception;
  
}
