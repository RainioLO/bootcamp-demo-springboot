package com.demo.springboot.bootcampsbcalculator.infra.exception;

import com.demo.springboot.bootcampsbcalculator.infra.Syscode;

public class BusinessException extends Exception {

  private String code;

  public BusinessException(Syscode syscode) {
    super(syscode.getMessage()); //
    this.code = syscode.getCode();
  }

}
