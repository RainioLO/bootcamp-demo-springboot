package com.demo.springboot.bootcampsbcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Setter
public class Result {

  private String x;

  private String y;

  private String operation;

  private String result;
  
}
