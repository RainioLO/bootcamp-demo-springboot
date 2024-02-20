package com.demo.springboot.bootcampsbcalculator.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class CalculatorDTO {

  private String x;
  private String y;
  private String operation;



  
}
