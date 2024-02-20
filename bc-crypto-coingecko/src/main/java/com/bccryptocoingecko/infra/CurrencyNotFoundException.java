package com.bccryptocoingecko.infra;

public class CurrencyNotFoundException extends BusinessException {

  public CurrencyNotFoundException(Syscode syscode) {
    super(syscode);
  }
}
