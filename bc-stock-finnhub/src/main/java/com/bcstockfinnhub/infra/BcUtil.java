package com.bcstockfinnhub.infra;

import org.springframework.web.util.UriComponentsBuilder;

public class BcUtil {

  public static String url(Scheme scheme, String domain, String endpoint,
      String symbol, String token) {

    return UriComponentsBuilder.newInstance() //
        .scheme(scheme.lowercaseName()) //
        .host(domain) //
        .path(endpoint) //
        .queryParam("symbol", symbol) //
        .queryParam("token", token) //
        .toUriString();
  }
}
