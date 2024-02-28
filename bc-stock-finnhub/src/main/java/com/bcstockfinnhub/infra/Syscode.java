package com.bcstockfinnhub.infra;

import lombok.Getter;

@Getter
public enum Syscode {


  OK("10000", "OK."),
  ERROR("99999", "An Error Occurs");

  private String code;
  private String message;

  private Syscode(String code, String message){
    this.code = code;
    this.message = message;

  }
  
}
