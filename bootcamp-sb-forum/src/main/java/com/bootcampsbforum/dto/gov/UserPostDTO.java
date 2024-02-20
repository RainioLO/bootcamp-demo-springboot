package com.bootcampsbforum.dto.gov;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
// the object is separated from the original object and present to the gov
public class UserPostDTO { // DTO to shpe the data for the user, as the form of presentation

  private int id;
  
  private String username;

  private String email;

  private String phone;

  // Post have many attributes... // choose what to present
  @Setter
  @JsonProperty(value = "posts") //serialization
  private List<PostDTO> postDTOs;

}
