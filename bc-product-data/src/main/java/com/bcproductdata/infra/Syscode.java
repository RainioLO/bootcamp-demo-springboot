package com.bcproductdata.infra;

import lombok.Getter;

@Getter
public enum Syscode {


  OK("10000", "OK."),
  ERROR("99999", "An Error Occurs"),
  INVALID_SYMBOL("11111", "Invalid Symbol"),
  NPE_EXCEPTION("480999" , "NPE or Expired"),
  GENERAL_EXCEPTION("77777", "Common Exception"),
  CLIENT_RESPONSE_EXCEPTION("90000", "RestClientException - Finnhub Service is unavailable"),
  INVALID_CURRENCY_EXCEPTION ("878787", "Invalid Currency");

  private String code;
  private String message;

  private Syscode(String code, String message){
    this.code = code;
    this.message = message;

  }
  
}
