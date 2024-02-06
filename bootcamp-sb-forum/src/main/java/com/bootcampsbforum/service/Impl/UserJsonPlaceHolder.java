package com.bootcampsbforum.service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcampsbforum.infra.BcUtil;
import com.bootcampsbforum.infra.ResourceNotFound;
import com.bootcampsbforum.infra.Scheme;
import com.bootcampsbforum.infra.Syscode;
import com.bootcampsbforum.model.dto.jph.User;
import com.bootcampsbforum.service.PostService;
import com.bootcampsbforum.service.UserService;

// comment here to check
@Service // service start will access if the class correct or not.
public class UserJsonPlaceHolder implements UserService { // the only object

  @Value(value = "${api.jph.domain}")
  private String domain; // instance variable

  @Value(value = "${api.jph.endpoints.user}") // look at the value at yml
  private String userEndpoint;

  @Autowired
  private PostService postService;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<User> getUsers() { // instance method ny this Service object
    String userUrl = BcUtil.url(Scheme.HTTPS, domain, userEndpoint); // variable in local method
    User[] users = restTemplate.getForObject(userUrl, User[].class);
    // System.out.println("After restTemplate");
    // System.out.println(Arrays.toString(users));

    return Arrays.stream(users).collect(Collectors.toList());
  }

  @Override
  public User getUser(int index) {
    Optional<User> userPostDTO = this.getUsers().stream() //
        .filter(e -> e.getId() == index) //
        .findFirst();
    if (userPostDTO.isPresent())
      return userPostDTO.get();
    throw new ResourceNotFound(Syscode.NOTFOUND);
  }


}
