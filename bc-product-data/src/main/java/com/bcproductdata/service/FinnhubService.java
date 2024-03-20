package com.bcproductdata.service;

import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.bcproductdata.entity.StockEntity;

public interface FinnhubService {

  Boolean saveQuotesToDB() throws JsonProcessingException;

  Boolean clearQuotesFromDB() throws JsonProcessingException;

  Boolean storeAAPLQuoteToDB() throws JsonProcessingException;

  Boolean saveProfilesToDB() throws JsonProcessingException;

  Boolean clearProfilesFromDB() throws JsonProcessingException;

  Boolean storeAAPLProfileToDB() throws JsonProcessingException;

  Boolean storeStockEntitiesToDB() throws JsonProcessingException;

  Boolean clearStockEntitiesFromDB() throws JsonProcessingException;

  Boolean reflashStockDailyEntityInDB() throws JsonProcessingException;

  List<StockEntity> getStockMarketPrices();


}
