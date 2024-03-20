package com.bcproductdata.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "texternal_crypto_coingecko_market")
public class MarketEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "quote_date")
  private LocalDateTime quoteDate;

  @Column(name = "quote_coin_code")
  private String quoteCoinCode;

  @Column(name = "quote_currency")
  private String quoteCurrency;

  @Column(name = "name")
  private String name;

  @Column(name = "image")
  private String image;

  @Column(name = "curr_price")
  private Double currentPrice;

  @Column(name = "market_cap")
  private Double marketCap;

  @Column(name = "market_cap_rank")
  private Integer marketCapRank;

  @Column(name = "fully_diluted_valuation")
  private Double fullyDilutedValuation;

  @Column(name = "total_volume")
  private Double totalVolume;

  @Column(name = "high_24h")
  private Double high24h;

  @Column(name = "low_24h")
  private Double low24h;

  @Column(name = "price_change_24h")
  private Double priceChange24h;

  @Column(name = "price_change_pct_24h")
  private Double priceChangePct24h;

  @Column(name = "market_cap_change_24h")
  private Double marketCapChange24h;

  @Column(name = "market_cap_change_pct_24h")
  private Double marketCapChangePct24h;

  @Column(name = "circulating_supply")
  private Double circulatingSupply;

  @Column(name = "total_supply")
  private Double totalSupply;

  @Column(name = "max_supply")
  private Double maxSupply;

  @Column(name = "ath")
  private Double ath;

  @Column(name = "ath_change_percentage")
  private Double athChangePercentage;

  @Column(name = "ath_date")
  private LocalDateTime athDate;

  @Column(name = "atl")
  private Double atl;

  @Column(name = "atl_change_percentage")
  private Double atlChangePercentage;

  @Column(name = "atl_date")
  private LocalDateTime atlDate;


}
