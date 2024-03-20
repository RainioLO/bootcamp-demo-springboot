package com.bcproductdata.mapper;

import org.springframework.stereotype.Component;
import com.bcproductdata.dto.Market;
import com.bcproductdata.entity.MarketEntity;
import com.bcproductdata.infra.Currency;

@Component
public class MarketMapper {

  public MarketEntity mapMarketEntity(Market market, Currency currency) {

    return MarketEntity.builder() //
        .name(market.getName()) //
        .quoteDate(market.getLastUpdated()) //
        .quoteCoinCode(market.getId()) //
        .quoteCurrency(currency.name().toLowerCase()) //
        .name(market.getName()) //
        .image(market.getImage()) //
        .currentPrice(market.getCurrentPrice()) //
        .marketCap((double) (long) market.getMarketCap()) //
        .marketCapRank(market.getMarketCapRank()) //
        .fullyDilutedValuation(
            (double) (long) market.getFullyDilutedValuation()) //
        .totalVolume((double) (long) market.getTotalVolume()) //
        .high24h(market.getHigh24h()) //
        .low24h(market.getLow24h()) //
        .priceChange24h(market.getPriceChange24h()) //
        .priceChangePct24h(market.getPriceChangePercent24h()) //
        .marketCapChange24h((double) (long) market.getMarketCapChange24h()) //
        .marketCapChangePct24h(market.getMarketCapChangePercent24h()) //
        .circulatingSupply(market.getCirculatingSupply()) //
        .totalSupply(market.getTotalSupply()) //
        .maxSupply((double) (long) market.getMaxSupply()) //
        .ath(market.getAth()) //
        .athChangePercentage(market.getAthChangePercentage()) //
        .athDate(market.getAthDate()) //
        .atl(market.getAtl()) //
        .atlChangePercentage(market.getAtlChangePercentage()) //
        .atlDate(market.getAtlDate()) //
        .build();

  }

}
