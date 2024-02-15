package com.bccryptocoingecko.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bccryptocoingecko.infra.BcUtil;
import com.bccryptocoingecko.infra.Scheme;
import com.bccryptocoingecko.model.Coin;
import com.bccryptocoingecko.service.CoinService;

@Service
public class CoinServiceImpl implements CoinService {

  // third party address --> controller (ourselves address)
  @Value(value = "${api.coingecko.domain}")
  private String domain;

  @Value(value = "${api.coingecko.endpoint.coin_market_usd}")
  private String coinEndpoint;

  @Override
  public List<Coin> getCoins() {
    RestTemplate restTemplate = new RestTemplate();
    String coinUrl = BcUtil.url(Scheme.HTTPS, domain, coinEndpoint);
    // String coinUrl = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&x_cg_demo_api_key=CG-cTyrK8iCq46x38hgMQZfgGGQ";
    Coin[] coins = restTemplate.getForObject(coinUrl, Coin[].class);
    return Arrays.stream(coins).collect(Collectors.toList());
  }


}
