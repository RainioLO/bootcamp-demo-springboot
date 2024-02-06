package com.bootcampsbforum.service;

import java.util.List;
import com.bootcampsbforum.model.dto.jph.Comment;

public interface CommentService {

  List<Comment> getComments();

}
