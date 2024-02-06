package com.bootcampsbforum.service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.bootcampsbforum.infra.BcUtil;
import com.bootcampsbforum.infra.JPHClientException;
import com.bootcampsbforum.infra.Scheme;
import com.bootcampsbforum.infra.Syscode;
import com.bootcampsbforum.model.dto.jph.Post;
import com.bootcampsbforum.service.PostService;

@Service
public class PostJsonHolder implements PostService {

  @Value(value = "${api.jph.domain}")
  private String domain;

  @Value(value = "${api.jph.endpoints.post}")
  private String postEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<Post> getPosts() { // instance method ny this Service object
    // RestTemplate restTemplate = new RestTemplate(); // to getForObject
    String postUrl = BcUtil.url(Scheme.HTTPS, domain, postEndpoint); // variable in local method

    
    try {
      Post[] posts = restTemplate.getForObject(postUrl, Post[].class); // try whether can get from the holder
      // 95% unchecked exception
      // Post[].class is the container to hold
      // the server or the URL problem
      // System.out.println("After restTemplate");
      // System.out.println(Arrays.toString(users));

      return Arrays.stream(posts).collect(Collectors.toList());
    } catch (RestClientException e) {
      throw new JPHClientException(Syscode.JPH_NOT_AVAILABLE);
    }
  }
}
