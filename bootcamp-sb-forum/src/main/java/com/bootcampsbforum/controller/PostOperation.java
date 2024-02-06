package com.bootcampsbforum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcampsbforum.model.dto.jph.Post;

public interface PostOperation {

  @GetMapping (value = "/posts")
  List<Post> getPosts();
  
}
