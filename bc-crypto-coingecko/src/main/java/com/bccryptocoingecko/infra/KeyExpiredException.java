package com.bccryptocoingecko.infra;

public class KeyExpiredException extends IllegalArgumentException {

  private String code;

  public KeyExpiredException(Syscode syscode) {
    super(syscode.getMessage());
    this.code = syscode.getCode();
  }

}
