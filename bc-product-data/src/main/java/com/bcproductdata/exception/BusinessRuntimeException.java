package com.bcproductdata.exception;

import com.bcproductdata.infra.Syscode;

public class BusinessRuntimeException extends RuntimeException {

  private String code;

  public BusinessRuntimeException(Syscode syscode) {
    super(syscode.getMessage());
    this.code = syscode.getCode();
  }
}

