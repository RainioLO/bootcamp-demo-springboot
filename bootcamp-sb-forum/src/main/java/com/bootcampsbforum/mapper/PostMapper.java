package com.bootcampsbforum.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bootcampsbforum.dto.gov.request.PostRequestDTO;
import com.bootcampsbforum.entity.PostEntity;


// When server starts,
// Spring ensures modelMapper is ready before creating GovMapper object
@Component // -> Bean
public class PostMapper {

  @Autowired
  private ModelMapper modelMapper;

  public PostEntity mapEntity(PostRequestDTO dto) { // from PostRequestDTO to PostEntity
    return new PostEntity(null, //
        dto.getTitle(), //
        dto.getBody(), //
        null);
  }

}