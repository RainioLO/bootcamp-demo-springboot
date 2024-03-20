package com.bcproductdata.service;

import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.bcproductdata.entity.CoinEntity;

public interface CryptoService {

  Boolean storeCoinsToDB() throws JsonProcessingException;

  Boolean clearCoinsFromDB() throws JsonProcessingException;

  Boolean storeBitcoinsToDB() throws JsonProcessingException;

  Boolean storeCoinEntitiesToDB() throws JsonProcessingException;

  Boolean clearCoinEntitiesFromDB() throws JsonProcessingException;


  List<CoinEntity> getCoinMarketPrices() throws JsonProcessingException;
}
