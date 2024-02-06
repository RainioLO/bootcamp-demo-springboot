package com.demo.springboot.bootcampsbcalculator.infra;

import org.springframework.web.util.UriComponentsBuilder;

public class BcUtil {

  public static String url(String domain, String endpoint) {
    return UriComponentsBuilder.newInstance()
        .scheme(Scheme.HTTPS.lowrcaseName()).host(domain) //
        .path(endpoint) //
        .toUriString(); // handle special character like :
  }
}
