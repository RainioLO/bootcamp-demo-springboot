package com.bcproductdata.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Quote {

  // Current Price
  private double c;

  // Change
  private Double d;

  // Percent change
  private Double dp;

  // High price of the day
  private double h;

  // Low price of the day
  private double l;

  // Open price of the day
  private double o;

  // Previous close price
  private double pc;

  // Timestamp in UTC
  private long t;

}
