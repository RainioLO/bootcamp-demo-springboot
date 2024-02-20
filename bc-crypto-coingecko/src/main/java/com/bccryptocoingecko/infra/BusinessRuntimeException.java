package com.bccryptocoingecko.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BusinessRuntimeException extends RuntimeException{
  private String code;

  public BusinessRuntimeException (Syscode syscode){
    super(syscode.getMessage());
    this.code = syscode.getCode();
  }


}
