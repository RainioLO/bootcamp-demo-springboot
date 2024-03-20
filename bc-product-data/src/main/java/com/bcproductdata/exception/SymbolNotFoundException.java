package com.bcproductdata.exception;

import com.bcproductdata.infra.Syscode;

public class SymbolNotFoundException extends BusinessRuntimeException {

  public SymbolNotFoundException(Syscode syscode) {
    super(syscode);
  }
}
