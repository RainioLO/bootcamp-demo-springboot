package com.bccryptocoingecko.service;

import java.util.List;
import com.bccryptocoingecko.model.Coin;

public interface CoinService {

  List<Coin> getCoins();
  
}
