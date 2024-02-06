package com.bootcampsbforum.dto.gov.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bootcampsbforum.dto.gov.CommentDTO;
import com.bootcampsbforum.dto.gov.PostDTO;
import com.bootcampsbforum.dto.gov.UserCommentDTO;
import com.bootcampsbforum.dto.gov.UserDTO;
import com.bootcampsbforum.dto.gov.UserPostDTO;
import com.bootcampsbforum.model.dto.jph.Comment;
import com.bootcampsbforum.model.dto.jph.Post;
import com.bootcampsbforum.model.dto.jph.User;

// when server start, Spring ensures modelMapper is ready before creating GovMapper object
// 
@Component
public class GovMapper {

  @Autowired
  private ModelMapper modelmapper;

  public UserDTO map(User user) {
    return this.modelmapper.map(user, UserDTO.class); // from User to UserDTO to consumer
  }

  public UserPostDTO mapPost(User user, List<Post> posts) {

    List<PostDTO> postDTOs = posts.stream() //
        .filter(e -> e.getUserId() == user.getId()) //
        .map(e -> {
          return PostDTO.builder() //
              .id(e.getId()) //
              .title(e.getTitle()) //
              .body(e.getBody())//
              .build();
        }).collect(Collectors.toList());

    return UserPostDTO.builder() //
        .id(user.getId()).username(user.getUsername()) //
        .email(user.getEmail()) //
        .phone(user.getPhone()) //
        .postDTOs(postDTOs) //
        .build();
    //
    // // @Autowired
    // private ModelMapper modelmapper;

    // map all fields by name

    // UserPostDTO userPostDTO = this.modelmapper.map(user, UserPostDTO.class);
    // userPostDTO.setPostDTOs(postDTOs);
    // return userPostDTO;
    // // UserPostDTO userPostDTO = mode

  }

  public static UserCommentDTO mapComment(User user, List<Comment> comments) {

    List<CommentDTO> commentDTOs = comments.stream() //
        .filter(e -> e.getEmail() == user.getEmail()) //
        .map(e -> {
          return CommentDTO.builder() //
              .id(e.getId()) //
              .email(e.getEmail()) //
              .body(e.getBody())//
              .name(e.getName()).build();
        }).collect(Collectors.toList());

    return UserCommentDTO.builder() //
        .username(user.getUsername()) //
        .email(user.getEmail()) //
        .phone(user.getPhone()) //
        .commentDTOs(commentDTOs) //
        .build();
  }

}
