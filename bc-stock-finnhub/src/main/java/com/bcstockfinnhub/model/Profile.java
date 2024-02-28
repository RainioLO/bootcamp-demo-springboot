package com.bcstockfinnhub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Profile {

  private String country;
  private String currency;
  private String exchange;
  private String ipo;
  private Long marketCapitalization;
  private String name;
  private String phone;
  private Double shareOutstanding;
  private String ticker;
  private String weburl;
  private String logo;
  private String cfinnhubIndustry;

}
