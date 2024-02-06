package com.demo.springboot.bootcampsbcalculator.infra;

import lombok.Getter;

@Getter
public enum Syscode {
  OK("000000", "OK."),//
  NOTFOUND("100000", "Not found."),//
  GENERAL_EXCEPTION("999999", "General Exception."),//
  REST_CLIENT_EXCEPTION("90001", "RestClient Exception"),//
  NO_SUCH_CODE("00000110","No operation with the code."),
  INVALID_INPUT("9" , "Invalid Input."),//
  MATH_PROBLEM("129399", "Can not divided by 0");

  private String code;
  private String message;

  private Syscode(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
