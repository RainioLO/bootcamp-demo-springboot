package com.bcproductdata.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Profile2 {

  private String country;
  // "country": "US",
  private String currency;
  // "currency": "USD",
  private String estimateCurrency;
  // "estimateCurrency": "USD",
  private String exchange;
  // "exchange": "NASDAQ NMS - GLOBAL MARKET",
  private String finnhubIndustry;
  // "finnhubIndustry": "Technology",
  private LocalDate ipo;
  // "ipo": "1986-03-13",
  private String logo;
  // "logo": "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/MSFT.svg",
  private double marketCapitalization;
  // "marketCapitalization": 3002341.966225,
  private String name;
  // "name": "Microsoft Corp",
  private String phone;
  // "phone": "14258828080",
  private double shareOutstanding;
  // "shareOutstanding": 7430.44,
  private String ticker;
  // "ticker": "MSFT",
  private String weburl;
  // "weburl": "https://www.microsoft.com/en-us"

}
