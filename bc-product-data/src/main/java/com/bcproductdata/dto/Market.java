package com.bcproductdata.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Market {

  @JsonProperty(value = "id")
  private String id;
  // "id": "ethereum",
  @JsonProperty(value = "symbol")
  private String symbol;
  // "symbol": "eth",
  @JsonProperty(value = "name")
  private String name;
  // "name": "Ethereum",
  @JsonProperty(value = "image")
  private String image;
  // "image": "https://assets.coingecko.com/coins/images/279/large/ethereum.png?1696501628",
  @JsonProperty(value = "current_price")
  private double currentPrice;
  // "current_price": 2506.17,
  @JsonProperty(value = "market_cap")
  private long marketCap;
  // "market_cap": 301052024360,
  @JsonProperty(value = "market_cap_rank")
  private int marketCapRank;
  // "market_cap_rank": 2,
  @JsonProperty(value = "fully_diluted_valuation")
  private long fullyDilutedValuation;
  // "fully_diluted_valuation": 301052024360,
  @JsonProperty(value = "total_volume")
  private long totalVolume;
  // "total_volume": 14436285294,
  @JsonProperty(value = "high_24h")
  private double high24h;
  // "high_24h": 2522.34,
  @JsonProperty(value = "low_24h")
  private double low24h;
  // "low_24h": 2446.63,
  @JsonProperty(value = "price_change_24h")
  private double priceChange24h;
  // "price_change_24h": 54.71,
  @JsonProperty(value = "price_change_percentage_24h")
  private double priceChangePercent24h;
  // "price_change_percentage_24h": 2.23157,
  @JsonProperty(value = "market_cap_change_24h")
  private long marketCapChange24h;
  // "market_cap_change_24h": 7074053605,
  @JsonProperty(value = "market_cap_change_percentage_24h")
  private double marketCapChangePercent24h;
  // "market_cap_change_percentage_24h": 2.40632,
  @JsonProperty(value = "circulating_supply")
  private double circulatingSupply;
  // "circulating_supply": 120171971.326682,
  @JsonProperty(value = "total_supply")
  private double totalSupply;
  // "total_supply": 120171971.326682,
  @JsonProperty(value = "max_supply")
  private long maxSupply;
  // "max_supply": 200000000,
  @JsonProperty(value = "ath")
  private double ath;
  // "ath": 4878.26,
  @JsonProperty(value = "ath_change_percentage")
  private double athChangePercentage;
  // "ath_change_percentage": -48.60699,
  @JsonProperty(value = "ath_date")
  private LocalDateTime athDate;
  // private String athDate;
  // "ath_date": "2021-11-10T14:24:19.604Z",
  @JsonProperty(value = "atl")
  private double atl;
  // "atl": 0.432979,
  @JsonProperty(value = "atl_change_percentage")
  private double atlChangePercentage;
  // "atl_change_percentage": 578931.72221,
  @JsonProperty(value = "atl_date")
  private LocalDateTime atlDate;
  // private String atlDate;
  // "atl_date": "2015-10-20T00:00:00.000Z",
  @JsonProperty(value = "roi")
  private Roi roi;
  // "roi": {
  // "times": 69.67211787949309,
  // "currency": "btc",
  // "percentage": 6967.211787949309
  // },

  @JsonProperty(value = "last_updated")
  private LocalDateTime lastUpdated;
  // private String lastUpdated;
  // "last_updated": "2024-02-10T05:39:53.906Z"

  @Getter
  @Builder
  @EqualsAndHashCode
  @ToString
  public static class Roi {
    @JsonProperty(value = "times")
    private double times;

    @JsonProperty(value = "currency")
    private String currency;

    @JsonProperty(value = "percentage")
    private double percentage;
  }
}
