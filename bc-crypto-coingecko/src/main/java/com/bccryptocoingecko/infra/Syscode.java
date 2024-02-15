package com.bccryptocoingecko.infra;

import lombok.Getter;

@Getter
public enum Syscode {
  OK("000000", "OK."),
  ERROR("111111", "An error has occurred.");

  private String code;
  private String message;

  private Syscode(String code, String message){ //private for enum
    this.code = code;
    this.message = message;
  }
  
}
