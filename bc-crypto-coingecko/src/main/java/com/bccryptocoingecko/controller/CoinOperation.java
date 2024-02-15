package com.bccryptocoingecko.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bccryptocoingecko.infra.ApiResponse;
import com.bccryptocoingecko.model.Coin;

public interface CoinOperation {

  @GetMapping(value = "/coins")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<Coin>> getCoins(@RequestParam(value = "currency") String currency);
  
}
