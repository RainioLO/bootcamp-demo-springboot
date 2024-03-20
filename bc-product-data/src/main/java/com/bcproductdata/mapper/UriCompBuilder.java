package com.bcproductdata.mapper;

import org.springframework.web.util.UriComponentsBuilder;
import com.bcproductdata.infra.Currency;
import com.bcproductdata.infra.Scheme;
import com.bcproductdata.model.StockId;
import lombok.Getter;

@Getter
public class UriCompBuilder {
  public static String url(Scheme scheme, String domain, String basepath,
      String endpoint) {

    return UriComponentsBuilder.newInstance() //
        .scheme(scheme.name().toLowerCase()) //
        .host(domain) //
        .path(basepath) //
        .path(endpoint) //
        .toUriString();
  }

  public static String url(Scheme scheme, String host, int port,
      String basepath, String endpoint) {

    return UriComponentsBuilder.newInstance() //
        .scheme(scheme.name().toLowerCase()) //
        .host(host) //
        .port(port).path(basepath) //
        .path(endpoint) //
        .toUriString();
  }

  public static String urlQuote(Scheme scheme, String host, int port,
      String basepath, String quoteEndpoint, StockId stockId) {

    return UriComponentsBuilder.newInstance() //
        .scheme(scheme.name().toLowerCase()) //
        .host(host) //
        .port(port).path(basepath) //
        .path(quoteEndpoint) //
        .queryParam("symbol", stockId.getStockId())//
        .toUriString();
  }


  public static String urlProfile(Scheme scheme, String host, int port,
      String basepath, String profileEndpoint, StockId stockId) {

    return UriComponentsBuilder.newInstance() //
        .scheme(scheme.name().toLowerCase()) //
        .host(host) //
        .port(port).path(basepath) //
        .path(profileEndpoint) //
        .queryParam("symbol", stockId.getStockId())//
        .toUriString();
  }

  public static String url(Scheme scheme, String domain, String basepath,
      String endpoint, Currency currency, String key, String... ids) {

    StringBuilder idsString = new StringBuilder("");

    for (int i = 0; i < ids.length; i++) {
      idsString.append(ids[i]);
      if (i < ids.length - 1) {
        idsString.append(",");
      }
    }


    String urlString = UriComponentsBuilder.newInstance() //
        .scheme(scheme.name().toLowerCase()) //
        .host(domain) //
        .path(basepath) //
        .path(endpoint) //
        .queryParam("vs_currency", currency.name().toLowerCase()) //
        .queryParam("ids", idsString.toString()) //
        .queryParam("x_cg_demo_api_key", key) //
        .toUriString();

    return urlString;
  }

  public static String url(Scheme scheme, String domain, String basepath,
      String endpoint, Currency currency, String... ids) {

    StringBuilder idsString = new StringBuilder("");

    for (int i = 0; i < ids.length; i++) {
      idsString.append(ids[i]);
      if (i < ids.length - 1) {
        idsString.append(",");
      }
    }


    String urlString = UriComponentsBuilder.newInstance() //
        .scheme(scheme.name().toLowerCase()) //
        .host(domain) //
        .path(basepath) //
        .path(endpoint) //
        .queryParam("currency", currency.name().toLowerCase()) //
        .queryParam("ids", idsString.toString()) //
        .toUriString();

    return urlString;
  }

  public static String urlCoinsMarket(Scheme scheme, String host, int port,
      String basepath, String endpoint, Currency currency, String ids) {

    String urlString = UriComponentsBuilder.newInstance() //
        .scheme(scheme.name().toLowerCase()) //
        .host(host) //
        .port(port) //
        .path(basepath) //
        .path(endpoint) //
        .queryParam("currency", currency.name().toLowerCase()) //
        .queryParam("ids", ids) //
        .toUriString();

    return urlString;
  }


}
