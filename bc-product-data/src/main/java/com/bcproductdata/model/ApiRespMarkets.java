package com.bcproductdata.model;

import java.util.List;
import com.bcproductdata.dto.Market;
import lombok.Getter;


@Getter
public class ApiRespMarkets {

  private String code;
  private String message;
  private List<Market> data;

}
