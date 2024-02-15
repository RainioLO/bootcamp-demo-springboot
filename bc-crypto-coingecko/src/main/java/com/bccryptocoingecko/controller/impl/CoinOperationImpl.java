package com.bccryptocoingecko.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bccryptocoingecko.controller.CoinOperation;
import com.bccryptocoingecko.infra.ApiResponse;
import com.bccryptocoingecko.infra.Syscode;
import com.bccryptocoingecko.model.Coin;
import com.bccryptocoingecko.model.Currency;
import com.bccryptocoingecko.service.CoinService;

@RestController
@RequestMapping(value = "/crypto/coingecko/api/v1")
public class CoinOperationImpl implements CoinOperation {

  @Autowired
  private CoinService coinService;

  @Override
  public ApiResponse<List<Coin>> getCoins(String currency) {
    if (currency.equals(Currency.USD.name().toLowerCase())) {
      return ApiResponse.<List<Coin>>builder() //
          .code(Syscode.OK.getCode()) //
          .message(Syscode.OK.getMessage()) //
          .data(coinService.getCoins()) //present this data from third part in which currenct = usd
          .build();
    } return ApiResponse.<List<Coin>>builder() //
          .code(Syscode.ERROR.getCode()) //
          .message(Syscode.ERROR.getMessage()) //
          .data(null) //
          .build();
  }


}
