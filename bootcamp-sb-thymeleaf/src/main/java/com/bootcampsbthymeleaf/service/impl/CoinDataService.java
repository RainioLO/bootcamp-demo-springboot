package com.bootcampsbthymeleaf.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcampsbthymeleaf.model.CoinData;
import com.bootcampsbthymeleaf.service.ApiService;

@Service
public class CoinDataService implements ApiService<CoinData> {

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<CoinData> fetchData() {
    String apiUrl =
        "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&x_cg_demo_api_key=CG-cTyrK8iCq46x38hgMQZfgGGQ";
    CoinData[] coins = restTemplate.getForObject(apiUrl, CoinData[].class);
    return Arrays.stream(coins).collect(Collectors.toList());
  }
}
