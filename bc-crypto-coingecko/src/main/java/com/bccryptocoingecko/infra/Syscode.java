package com.bccryptocoingecko.infra;

import lombok.Getter;

@Getter
public enum Syscode {
  OK("000000", "OK."),
  ERROR("111111", "An error has occurred."),
  CURRENCY_NOTFOUND("100000", "Currency Not Found."), //
  GENERAL_EXCEPTION("999999", "General Exception."),
  COINGECKO_FAIL_EXCEPTION("10304", "Cannot call third party api"),

  // Runtime Exception
  NPE_EXCEPTION("900000", "Runtime Exception - NPE."), //
  REST_CLIENT_EXCEPTION("90001", "RestClient Exception");

  private String code;
  private String message;

  private Syscode(String code, String message){ //private for enum
    this.code = code;
    this.message = message;
  }
  
}
