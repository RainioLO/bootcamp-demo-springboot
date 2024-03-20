package com.bcproductdata.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.stereotype.Component;
import com.bcproductdata.dto.Quote;
import com.bcproductdata.entity.QuoteEntity;
import com.bcproductdata.model.StockId;

@Component
public class QuoteMapper {

  public QuoteEntity mapQuoteEntity(Quote quote, StockId stockId) {

    long timestamp = quote.getT();
    Instant instant = Instant.ofEpochSecond(timestamp);
    LocalDateTime localDateTime =
        LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

    return QuoteEntity.builder() //
        .quoteDate(localDateTime) //
        .quoteStockCode(stockId.getStockId()) //
        .currPrice(quote.getC()) //
        .priceChg(quote.getD()) //
        .priceChgPct(quote.getDp())//
        .priceDayHigh(quote.getH()) //
        .priceDayLow(quote.getL()) //
        .pricePrevOpen(quote.getO())//
        .pricePrevClose(quote.getPc())//
        .build();


  }
}
