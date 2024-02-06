package com.bootcampsbforum.infra;

import org.springframework.web.util.UriComponentsBuilder;

public class BcUtil {

  public static String url(Scheme scheme, String domain, String endpoint) {
    return UriComponentsBuilder.newInstance() //
        .scheme(scheme.lowrcaseName()) // .scheme("https")
        .host(domain) //
        .path(endpoint) //
        .toUriString(); // handle special character, such as : / \
  }
}
