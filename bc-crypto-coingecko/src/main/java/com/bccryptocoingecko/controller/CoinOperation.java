package com.bccryptocoingecko.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bccryptocoingecko.infra.ApiResponse;
import com.bccryptocoingecko.infra.BusinessException;
import com.bccryptocoingecko.infra.BusinessRuntimeException;
import com.bccryptocoingecko.model.Coin;
import com.bccryptocoingecko.model.CoinDTO;

public interface CoinOperation {

  @GetMapping(value = "/coins")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<Coin>> getCoins (@RequestParam(value = "currency") String currency, @RequestParam(value = "ids") String id)
  throws BusinessException, BusinessRuntimeException;

  @GetMapping(value = "/coindto")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<CoinDTO>> getCoinDTO(@RequestParam(value = "currency") String currency, @RequestParam(value = "ids") String id)
  throws BusinessException, BusinessRuntimeException;
  
}
