package com.bccryptocoingecko.infra;

import org.springframework.web.util.UriComponentsBuilder;

public class BcUtil {

  public static String url(Scheme scheme, String domain, String endpoint){
    return UriComponentsBuilder.newInstance() //
      .scheme(scheme.lowercaseName()) //
      .host(domain) //
      .path(endpoint)
      .toUriString();
  }
}
