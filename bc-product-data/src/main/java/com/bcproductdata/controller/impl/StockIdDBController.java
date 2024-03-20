package com.bcproductdata.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.bcproductdata.dto.Symbol;
import com.bcproductdata.model.StockId;
import com.bcproductdata.service.StockIdService;
import com.bcproductdata.controller.StockIdDBOperation;


// @RestController
// @RequestMapping(value = "/stock/api/v1")
public class StockIdDBController implements StockIdDBOperation {

  @Autowired
  private StockIdService stockIdService;

  @Override
  public List<StockId> setStockIds(List<StockId> stocks)
      throws JsonProcessingException {
    return stockIdService.setStockId(stocks);
  }

  // @Override
  // public List<StockId> getStockIds() throws JsonProcessingException {
  // return stockIdService.getStockIds();
  // }

  @Override
  public Boolean deleteStockId(List<StockId> stocks)
      throws JsonProcessingException {
    return stockIdService.deleteStockId(stocks);
  }

  @Override
  public Boolean deleteAllStockId() throws JsonProcessingException {
    return stockIdService.deleteAllStockIds();
  }

  // @Override
  // public List<Symbol> getStocks() throws JsonProcessingException {
  // return stockIdService.getSymbols();
  // }
}
