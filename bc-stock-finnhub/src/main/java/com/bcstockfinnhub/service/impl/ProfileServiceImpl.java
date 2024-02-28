package com.bcstockfinnhub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bcstockfinnhub.infra.BcUtil;
import com.bcstockfinnhub.infra.Scheme;
import com.bcstockfinnhub.model.Profile;
import com.bcstockfinnhub.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

  @Autowired
  private RestTemplate restTemplate;

  private String symbol;

  @Value("${api.finnhub.domain}")
  private String domain;

  @Value("${api.finnhub.endpoints.profile2}")
  private String profileEndpoint;

  @Value("${api.finnhub.parameters.symbol.apple}")
  private String appleSymbol;

  @Value("${api.finnhub.parameters.symbol.tesla}")
  private String teslaSymbol;

  @Value("${api.finnhub.parameters.symbol.microsoft}")
  private String microsoftSymbol;

  @Value("${api.finnhub.parameters.token}")
  private String token;

  @Override
  public Profile getProfile(String symbol) throws Exception {

    switch (symbol) {
      case "AAPL":
        symbol = appleSymbol;
        break;
      case "TSLA":
        symbol = teslaSymbol;
        break;
      case "MSFT":
        symbol = microsoftSymbol;
        break;

      default:
        throw new Exception("Symbol Not Found");
    }

    String url =
        BcUtil.url(Scheme.HTTPS, domain, profileEndpoint, symbol, token);

    Profile profile = restTemplate.getForObject(url, Profile.class);
    return profile;
  }
}
