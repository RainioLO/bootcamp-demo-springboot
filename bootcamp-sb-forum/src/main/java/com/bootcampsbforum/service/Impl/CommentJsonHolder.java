package com.bootcampsbforum.service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcampsbforum.infra.Scheme;
import com.bootcampsbforum.model.dto.jph.Comment;
import com.bootcampsbforum.service.CommentService;
// for getting the comment list from the online

@Service
public class CommentJsonHolder implements CommentService {

  @Value(value = "${api.jph.domain}")
  private String domain;

  @Value(value = "${api.jph.endpoints.comment}")
  private String commentEndpoint;

  @Override
  public List<Comment> getComments() { // instance method ny this Service object
    RestTemplate restTemplate = new RestTemplate(); // new the object from outside
    String commentUrl = url(domain, commentEndpoint); // variable in local method
    Comment[] comments = restTemplate.getForObject(commentUrl, Comment[].class);
    // System.out.println("After restTemplate");
    // System.out.println(Arrays.toString(users));

    return Arrays.stream(comments).collect(Collectors.toList());
  }

  private static String url(String domain, String endpoint) {
    return UriComponentsBuilder.newInstance()
        .scheme(Scheme.HTTPS.lowrcaseName()).host(domain) //
        .path(endpoint) //
        .toUriString(); // handle special character like :
  }
  
}
