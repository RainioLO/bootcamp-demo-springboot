package com.bcproductdata.model;

import com.bcproductdata.dto.Profile2;
import lombok.Getter;


@Getter
public class ApiRespProfile {

  private String code;
  private String message;
  private Profile2 data;

}
