package com.bootcampsbforum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcampsbforum.model.dto.jph.Comment;

public interface CommentOperation {

  @GetMapping(value = "/comments")
  List<Comment> getComments();


}
