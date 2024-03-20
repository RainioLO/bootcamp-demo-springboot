package com.bcproductdata.service;

import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.bcproductdata.dto.Coin;
import com.bcproductdata.model.CoinId;

public interface CoinIdService {

  List<CoinId> setCoinId(List<CoinId> ids) throws JsonProcessingException;

  List<CoinId> getCoinIds() throws JsonProcessingException;

  Boolean deleteCoinId(List<CoinId> ids) throws JsonProcessingException;

  Boolean deleteAllCoinIds() throws JsonProcessingException;

  List<Coin> getCoins() throws JsonProcessingException;


}
