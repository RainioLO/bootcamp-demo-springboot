package com.bccryptocoingecko.infra;

import org.springframework.web.util.UriComponentsBuilder;

public class BcUtil {

  public static String url(Scheme scheme, String domain, String endpoint, String currency, String key) {
      // Ensure that the endpoint does not have a leading slash
      // as it will be split into path segments
      if (endpoint.startsWith("/")) {
          endpoint = endpoint.substring(1);
      }

      // Use the provided scheme instead of hardcoding "https"
      return UriComponentsBuilder.newInstance()
          .scheme(scheme.lowercaseName()) // Use the provided scheme
          .host(domain)
          .pathSegment(endpoint.split("/")) // Split the endpoint into path segments
          .queryParam("vs_currency", currency)
          .queryParam("x_cg_demo_api_key", key)
          .toUriString();
  }
}
