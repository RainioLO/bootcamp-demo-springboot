package com.bcproductdata.mapper;

import org.springframework.stereotype.Component;
import com.bcproductdata.entity.StockIdEntity;
import com.bcproductdata.model.StockId;

@Component
public class StockIdMapper {


  public StockId mapSymbolId(StockIdEntity entity) {
    return StockId.builder() //
        .stockId(entity.getStockId()) //
        .build();
  }

  public StockId mapSymbolId(String symbol) {
    return StockId.builder() //
        .stockId(symbol) //
        .build();
  }

  public StockIdEntity mapSymbolIdEntity(StockId id) {
    StockIdEntity stockIdEntity = new StockIdEntity();
    stockIdEntity.setStockId(id.getStockId());
    return stockIdEntity;
  }

}
