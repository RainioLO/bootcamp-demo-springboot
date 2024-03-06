package com.bcstockfinnhub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import com.bcstockfinnhub.exception.SymbolNotFoundException;
import com.bcstockfinnhub.exception.ThirdAPIException;
import com.bcstockfinnhub.infra.BcUtil;
import com.bcstockfinnhub.infra.Scheme;
import com.bcstockfinnhub.infra.Syscode;
import com.bcstockfinnhub.model.Quote;
import com.bcstockfinnhub.model.Symbol;
import com.bcstockfinnhub.service.QuoteService;

@Service
public class QuoteServiceImpl implements QuoteService {

  @Autowired
  private RestTemplate restTemplate;

  private String symbol;

  @Value("${api.finnhub.domain}")
  private String domain;

  @Value("${api.finnhub.endpoints.quote}")
  private String quoteEndpoint;

  @Value("${api.finnhub.parameters.symbol.apple}")
  private String appleSymbol;

  @Value("${api.finnhub.parameters.symbol.tesla}")
  private String teslaSymbol;

  @Value("${api.finnhub.parameters.symbol.microsoft}")
  private String microsoftSymbol;

  @Value("${api.finnhub.parameters.token}")
  private String token;

  @Override
  public Quote getQuote(String symbol) {

    String requestSymbol = Symbol.fromString(symbol).getMessage();
    switch (requestSymbol) {
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
        throw new SymbolNotFoundException(Syscode.INVALID_SYMBOL);
    }

    String url = BcUtil.url(Scheme.HTTPS, domain, quoteEndpoint, symbol, token);

    Quote quote = restTemplate.getForObject(url, Quote.class);
    return quote;
  }
}
