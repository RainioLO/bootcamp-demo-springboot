package com.bcstockfinnhub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Quote {

  @JsonProperty("c") // name in JSON format
  private String currentPrice;

  @JsonProperty("h")
  private String highPriceOfTheDay;

  @JsonProperty("l")
  private String lowPriceOfTheDay;

  @JsonProperty("o")
  private String openPriceOfTheDay;

  @JsonProperty("pc")
  private String previousClosePrice;

  @JsonProperty("t")
  private String t;
  
}
