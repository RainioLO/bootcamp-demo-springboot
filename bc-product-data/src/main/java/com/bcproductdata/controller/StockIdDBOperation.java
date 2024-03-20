package com.bcproductdata.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
// import com.vtxlab.bootcamp.bcproductdata.dto.Symbol;
import com.bcproductdata.model.StockId;

public interface StockIdDBOperation {

  @PostMapping(value = "/stock_ids/add")
  @ResponseStatus(value = HttpStatus.OK)
  List<StockId> setStockIds(@RequestParam List<StockId> stocks)
      throws JsonProcessingException;

  // @GetMapping(value = "/stock_ids")
  // @ResponseStatus(value = HttpStatus.OK)
  // List<StockId> getStockIds() throws JsonProcessingException;

  @DeleteMapping(value = "/stock_ids/delete")
  @ResponseStatus(value = HttpStatus.OK)
  Boolean deleteStockId(@RequestParam(name = "stocks") List<StockId> stocks)
      throws JsonProcessingException;

  @DeleteMapping(value = "/stock_ids/delete_all")
  @ResponseStatus(value = HttpStatus.OK)
  Boolean deleteAllStockId() throws JsonProcessingException;

  // @GetMapping(value = "/stocks/list")
  // @ResponseStatus(value = HttpStatus.OK)
  // List<Symbol> getStocks() throws JsonProcessingException;

}
