package com.bcproductdata.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
@Data
public class Coin {


  private String id;
  private String symbol;
  private String name;


}
