package com.bootcampsbforum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcampsbforum.controller.PostOperation;
import com.bootcampsbforum.model.dto.jph.Post;
import com.bootcampsbforum.service.PostService;

@RestController
@RequestMapping(value = "/api/v1")
public class PostController implements PostOperation {

  @Autowired
  private PostService postservice;

  @Override
  public List<Post> getPosts() {
    return postservice.getPosts();
  }

}
