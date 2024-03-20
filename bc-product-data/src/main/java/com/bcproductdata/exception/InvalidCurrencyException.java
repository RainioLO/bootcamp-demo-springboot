package com.bcproductdata.exception;

import com.bcproductdata.infra.Syscode;

public class InvalidCurrencyException extends BusinessRuntimeException {

  public InvalidCurrencyException(Syscode syscode) {
    super(syscode);
  }
}
