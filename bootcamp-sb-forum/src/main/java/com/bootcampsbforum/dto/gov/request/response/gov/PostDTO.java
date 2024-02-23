package com.bootcampsbforum.dto.gov.request.response.gov;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class PostDTO {

  private int id;

  private String title;

  private String body;
  
}
