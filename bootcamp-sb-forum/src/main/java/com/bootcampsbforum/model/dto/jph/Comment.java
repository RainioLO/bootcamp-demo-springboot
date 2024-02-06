package com.bootcampsbforum.model.dto.jph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Comment {

  private int postId;

  private int id;
  private String name;
  private String email;
  private String body;
  
}
