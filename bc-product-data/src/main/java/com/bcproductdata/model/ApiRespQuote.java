package com.bcproductdata.model;

import com.bcproductdata.dto.Quote;
import lombok.Getter;


@Getter
public class ApiRespQuote {

  private String code;
  private String message;
  private Quote data;

}
