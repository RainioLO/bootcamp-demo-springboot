package com.bcproductdata.model;

import java.util.List;
import com.bcproductdata.dto.Coin;
import lombok.Getter;


@Getter
public class ApiRespCoins {

  private String code;
  private String message;
  private List<Coin> data;

}
