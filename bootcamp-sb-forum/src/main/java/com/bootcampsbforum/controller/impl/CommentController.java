package com.bootcampsbforum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcampsbforum.controller.CommentOperation;
import com.bootcampsbforum.model.dto.jph.Comment;
import com.bootcampsbforum.service.CommentService;

@RestController
@RequestMapping(value = "/api/v1")
public class CommentController implements CommentOperation {

  @Autowired
  private CommentService commentservice;

  @Override
  public List<Comment> getComments(){
    return commentservice.getComments();
  }
  
}
