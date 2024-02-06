package com.bootcampsbforum.dto.gov;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentDTO {

  private int id;
  private String email;
  private String name;
  private String body;

}
