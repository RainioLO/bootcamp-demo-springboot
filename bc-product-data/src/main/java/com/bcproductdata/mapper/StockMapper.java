package com.bcproductdata.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bcproductdata.dto.Profile2;
import com.bcproductdata.dto.Quote;
import com.bcproductdata.entity.ProfileEntity;
import com.bcproductdata.entity.QuoteEntity;
import com.bcproductdata.entity.StockEntity;
import com.bcproductdata.entity.StockIdEntity;
import com.bcproductdata.exception.BusinessRuntimeException;
import com.bcproductdata.infra.Syscode;
import com.bcproductdata.model.StockId;
import com.bcproductdata.repository.StockIdRepository;

@Component
public class StockMapper {

  @Autowired
  private StockIdRepository stockIdRepository;

  public StockEntity mapStockEntity(Profile2 profile, Quote quote, StockId id) {

    StockIdEntity stockIdEntity =
        stockIdRepository.findByStockId(id.getStockId());

    StockEntity stockEntity = new StockEntity(null, //
        id.getStockId(), //
        quote.getC(), //
        quote.getDp(), //
        profile.getMarketCapitalization(), //
        profile.getLogo(), //
        stockIdEntity);

    return stockEntity;

  }

  public StockEntity mapStockEntity(ProfileEntity pEntity, QuoteEntity qEntity,
      StockId id) {

    StockIdEntity stockIdEntity =
        stockIdRepository.findByStockId(id.getStockId());

    if (stockIdEntity == null) {
      throw new BusinessRuntimeException(Syscode.ERROR);
    }

    StockEntity stockEntity = new StockEntity(null, //
        qEntity.getQuoteStockCode(), //
        qEntity.getCurrPrice(), //
        qEntity.getPriceChgPct(), //
        pEntity.getMarketCapitalization(), //
        pEntity.getLogo(), //
        stockIdEntity);

    return stockEntity;

  }
}
