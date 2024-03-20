package com.bcproductdata.service;

import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.bcproductdata.entity.StockDailyEntity;

public interface StockDailyService {

  List<StockDailyEntity> getStockDaily(String symbol);

  void saveDataToRedis() throws JsonProcessingException;

}
