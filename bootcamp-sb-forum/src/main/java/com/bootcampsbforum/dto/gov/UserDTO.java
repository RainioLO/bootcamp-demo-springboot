package com.bootcampsbforum.dto.gov;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// User -> UserDtO (ignore some fields)
public class UserDTO {

  private int id;
  private String email;
  private String phone;
  
}
