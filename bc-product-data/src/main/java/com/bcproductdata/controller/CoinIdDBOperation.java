package com.bcproductdata.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.bcproductdata.dto.Coin;
import com.bcproductdata.model.CoinId;

public interface CoinIdDBOperation {

  @PostMapping(value = "/coin_ids/add")
  @ResponseStatus(value = HttpStatus.OK)
  List<CoinId> setCoinIds(@RequestParam List<CoinId> coins) throws JsonProcessingException;

  // @GetMapping(value = "/coin_ids")
  // @ResponseStatus(value = HttpStatus.OK)
  // List<CoinId> getCoinIds() throws JsonProcessingException;

  @DeleteMapping(value = "/coin_ids/delete")
  @ResponseStatus(value = HttpStatus.OK)
  Boolean deleteCoinId(@RequestParam (name = "coins") List<CoinId> coins) throws JsonProcessingException;

  @DeleteMapping(value = "/coin_ids/delete_all")
  @ResponseStatus(value = HttpStatus.OK)
  Boolean deleteAllCoinId() throws JsonProcessingException;

  // @GetMapping(value = "/coins/list")
  // @ResponseStatus(value = HttpStatus.OK)
  // List<Coin> getCoins() throws JsonProcessingException;

}