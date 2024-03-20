package com.bcproductdata.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {

  @JsonProperty(value = "productType")
  private String productType;

  @JsonProperty(value = "productId")
  private String productId;

  @JsonProperty(value = "name")
  private String name;

  @JsonProperty(value = "currentPrice")
  private Double currentPrice;

  @JsonProperty(value = "priceChangePct")
  private Double priceChangePct;

  @JsonProperty(value = "marketCap")
  private Double marketCap;

  @JsonProperty(value = "logo")
  private String logo;
}
