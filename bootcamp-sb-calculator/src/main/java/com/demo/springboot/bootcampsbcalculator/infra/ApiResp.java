package com.demo.springboot.bootcampsbcalculator.infra;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResp<T> {

  private String code;

  private String message;

  private T data; // our data in any type
  
}
