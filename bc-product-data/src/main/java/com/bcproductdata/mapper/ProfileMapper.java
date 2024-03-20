package com.bcproductdata.mapper;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import com.bcproductdata.dto.Profile2;
import com.bcproductdata.entity.ProfileEntity;
import com.bcproductdata.model.StockId;

@Component
public class ProfileMapper {

  public ProfileEntity mapProfileEntity(Profile2 profile,
      LocalDateTime quoteDate, StockId stockId) {
    return ProfileEntity.builder() //
        .quoteDate(quoteDate)// to be prepared before calling method
        .quoteStockCode(stockId.getStockId())// to be prepared before calling method
        .country(profile.getCountry())//
        .currency(profile.getCurrency())//
        .estimatedCurrency(profile.getEstimateCurrency())//
        .exchange(profile.getExchange())//
        .finnhubindustry(profile.getFinnhubIndustry())//
        .ipo(profile.getIpo())//
        .logo(profile.getLogo())//
        .marketCapitalization(profile.getMarketCapitalization())//
        .name(profile.getName())//
        .phone(profile.getPhone())//
        .shareOutstanding(profile.getShareOutstanding())//
        .ticker(profile.getTicker())//
        .weburl(profile.getWeburl())//
        .build();
  }


}
