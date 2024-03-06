package com.bccryptocoingecko.controller.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bccryptocoingecko.controller.CoinOperation;
import com.bccryptocoingecko.infra.ApiResponse;
import com.bccryptocoingecko.infra.CurrencyNotFoundException;
import com.bccryptocoingecko.infra.Syscode;
import com.bccryptocoingecko.model.Coin;
import com.bccryptocoingecko.model.CoinDTO;
import com.bccryptocoingecko.service.CoinService;
import com.bccryptocoingecko.service.RedisService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/crypto/coingecko/api/v1")
public class CoinOperationImpl implements CoinOperation {

  @Autowired
  private CoinService coinService;

  @Autowired
  RedisService redisService;

  static List<String> requirement = new ArrayList<>();

  @Override
  public ApiResponse<List<Coin>> getCoins(String currency, String ids)
      throws CurrencyNotFoundException,JsonProcessingException {

    if (currency.isBlank()) {
      throw new CurrencyNotFoundException(Syscode.CURRENCY_NOTFOUND);
    }

    if (ids.isBlank()) {
      throw new NullPointerException();
    }

    log.info("controller start");
    requirement = Arrays.asList(ids.split(","));
    log.info("requirement " + requirement);
    log.info("controller second");

    List<Coin> usdfilteredCoins = coinService.getCoins().stream()
        .filter(e -> requirement.contains(e.getId()))
        .collect(Collectors.toList());
    // log.info("usdfilteredCoins :" + usdfilteredCoins);
    // log.info("controller return ");

    if (usdfilteredCoins.isEmpty()) {
      throw new NullPointerException();
    }

    switch (currency) {
      case "usd":
          for (Coin coin : usdfilteredCoins) {
            String key = "crypto:coingecko:coins-markets:" + currency + ":"
                + coin.getId();
            redisService.createCoin(key, coin);
          }
        return ApiResponse.<List<Coin>>builder() //
            .code(Syscode.OK.getCode()) //
            .message(Syscode.OK.getMessage()) //
            .data(usdfilteredCoins) //
            .build();
      default:
        throw new CurrencyNotFoundException(Syscode.CURRENCY_NOTFOUND);
    }
  }


  @Override
  public ApiResponse<List<CoinDTO>> getCoinDTO(String currency, String ids)
      throws CurrencyNotFoundException, NullPointerException,
      JsonProcessingException {

    if (currency.isBlank()) {
      throw new CurrencyNotFoundException(Syscode.CURRENCY_NOTFOUND);
    }

    if (ids.isBlank()) {
      throw new NullPointerException();
    }

    requirement = Arrays.asList(ids.split(","));

    List<CoinDTO> usdfilteredCoinsDTO = coinService.getCoins().stream()
        .filter(e -> requirement.contains(e.getId())).map(e -> {
          return CoinDTO.builder() //
              .high24h(e.getHigh24h()) //
              .id(e.getId()) //
              .image(e.getImage()) //
              .low24h(e.getLow24h()) //
              .marketCapRank(e.getMarketCapRank()) //
              .name(e.getName()) //
              .symbol(e.getSymbol()) //
              .currentPrice(e.getCurrentPrice()) //
              .build();
        }).collect(Collectors.toList());

    if (usdfilteredCoinsDTO.isEmpty()) {
      throw new NullPointerException();
    }

    switch (currency) {
      case "usd":
        if (usdfilteredCoinsDTO.size() > 0) {
          for (CoinDTO coin : usdfilteredCoinsDTO) {
            String key = "crypto:coingecko:coins-markets:" + currency + ":"
                + coin.getId();
            redisService.createCoinDTO(key, coin);
          }
        }
        return ApiResponse.<List<CoinDTO>>builder() //
            .code(Syscode.OK.getCode()) //
            .message(Syscode.OK.getMessage()) //
            .data(usdfilteredCoinsDTO) //
            .build();
      default:
        throw new CurrencyNotFoundException(Syscode.CURRENCY_NOTFOUND);
    }
  }
}
