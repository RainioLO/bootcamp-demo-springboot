package com.bcproductdata.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "texternal_stock_finnhub_profile2")
public class ProfileEntity implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "quote_date")
  private LocalDateTime quoteDate;

  @Column(name = "quote_stock_code")
  private String quoteStockCode;

  @Column(name = "country")
  private String country;

  @Column(name = "currency")
  private String currency;

  @Column(name = "estimate_currency")
  private String estimatedCurrency;

  @Column(name = "exchange")
  private String exchange;

  @Column(name = "finnhubindustry")
  private String finnhubindustry;

  @Column(name = "ipo")
  private LocalDate ipo;

  @Column(name = "logo")
  private String logo;

  @Column(name = "market_capitalization")
  private Double marketCapitalization;

  @Column(name = "name")
  private String name;

  @Column(name = "phone")
  private String phone;

  @Column(name = "share_outstanding")
  private Double shareOutstanding;

  @Column(name = "ticker")
  private String ticker;

  @Column(name = "weburl")
  private String weburl;
}
