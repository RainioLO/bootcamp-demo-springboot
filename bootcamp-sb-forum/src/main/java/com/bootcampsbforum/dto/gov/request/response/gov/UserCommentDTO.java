package com.bootcampsbforum.dto.gov.request.response.gov;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCommentDTO {

  private String username;

  private String email;

  private String phone;

  // Post have many attributes... // choose what to present
  private List<CommentDTO> commentDTOs;
  
}
