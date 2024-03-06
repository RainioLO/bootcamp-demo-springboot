package com.bcstockfinnhub.exception;

import com.bcstockfinnhub.infra.Syscode;

public class SymbolNotFoundException extends BusinessRuntimeException {

  public SymbolNotFoundException(Syscode syscode) {
    super(syscode);
  }
}
