package com.bcstockfinnhub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bcstockfinnhub.infra.ApiResponse;
import com.bcstockfinnhub.model.Profile;
import com.bcstockfinnhub.model.Quote;

public interface QuoteOperation {

  @GetMapping(value = "/quote")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<Quote> getQuote(
      @RequestParam(value = "symbol") String symbol) throws Exception;

  @GetMapping(value = "/profile2")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<Profile> getProfile(
      @RequestParam(value = "symbol") String symbol) throws Exception;

  @GetMapping(value = "/redis/quote")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<Quote> getRedisQuote(
      @RequestParam(value = "key") String key) throws Exception;

  @GetMapping(value = "/redis/profile2")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<Profile> getRedisProfile(
      @RequestParam(value = "key") String key) throws Exception;

}
