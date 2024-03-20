package com.bcproductdata.model;

import lombok.Getter;

@Getter
public enum CoinIdEnum {

  BITCOIN ("bitcoin"),
  ETHEREUM ("ethereum"),
  TETHER ("tether"),
  ;

  private String id;

  private CoinIdEnum(String id) {
    this.id = id;
  }

  public static boolean isValidCoinId(String id) {
    
    for (CoinIdEnum coin : CoinIdEnum.values()) {
      if (coin.getId().equals(id)) {
        return true;
      }
    }
    return false;
  }

  
}