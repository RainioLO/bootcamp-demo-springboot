package com.bcproductdata.mapper;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bcproductdata.dto.Quote;
import com.bcproductdata.entity.QuoteEntity;
import com.bcproductdata.entity.StockDailyEntity;
import com.bcproductdata.entity.StockIdEntity;
import com.bcproductdata.exception.BusinessRuntimeException;
import com.bcproductdata.infra.Syscode;
import com.bcproductdata.model.StockId;
import com.bcproductdata.repository.StockIdRepository;

@Component
public class StockDailyMapper {

  @Autowired
  private StockIdRepository stockIdRepository;

  public StockDailyEntity mapStockDailyEntity(Quote quote, StockId id) {

    StockIdEntity stockIdEntity =
        stockIdRepository.findByStockId(id.getStockId());

    if (stockIdEntity == null) {
      throw new BusinessRuntimeException(Syscode.ERROR);
    }

    long timestamp = quote.getT();
    Instant instant = Instant.ofEpochSecond(timestamp);
    LocalDate tradeDate = LocalDate.ofInstant(instant, ZoneOffset.UTC);

    StockDailyEntity stockDailyEntity = new StockDailyEntity(null, //
        tradeDate, //
        quote.getH(), //
        quote.getL(), //
        quote.getO(), //
        quote.getC(), //
        stockIdEntity);

    return stockDailyEntity;

  }


  public StockDailyEntity mapStockDailyEntity(QuoteEntity quoteEntity,
      StockId id) {

    StockIdEntity stockIdEntity =
        stockIdRepository.findByStockId(id.getStockId());

    if (stockIdEntity == null) {
      throw new BusinessRuntimeException(Syscode.ERROR);
    }

    StockDailyEntity stockDailyEntity = new StockDailyEntity(null, //
        quoteEntity.getQuoteDate().toLocalDate(), //
        quoteEntity.getPriceDayHigh(), //
        quoteEntity.getPriceDayLow(), //
        quoteEntity.getPricePrevOpen(), //
        quoteEntity.getCurrPrice(), //
        stockIdEntity);

    return stockDailyEntity;
  }
}
