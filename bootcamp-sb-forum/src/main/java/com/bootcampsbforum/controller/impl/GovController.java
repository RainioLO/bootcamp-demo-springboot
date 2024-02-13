package com.bootcampsbforum.controller.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcampsbforum.controller.GovOperation;
import com.bootcampsbforum.dto.gov.PostDTO;
import com.bootcampsbforum.dto.gov.UserCommentDTO;
import com.bootcampsbforum.dto.gov.UserDTO;
import com.bootcampsbforum.dto.gov.UserPostDTO;
import com.bootcampsbforum.infra.ApiResp;
import com.bootcampsbforum.infra.ResourceNotFound;
import com.bootcampsbforum.infra.Syscode;
import com.bootcampsbforum.mapper.GovMapper;
import com.bootcampsbforum.model.dto.jph.Comment;
import com.bootcampsbforum.model.dto.jph.Post;
import com.bootcampsbforum.model.dto.jph.User;
import com.bootcampsbforum.service.CommentService;
import com.bootcampsbforum.service.GovService;
import com.bootcampsbforum.service.PostService;
import com.bootcampsbforum.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// Service layer for processing
@RestController
@RequestMapping(value = "/gov/api/v1") // controller request mapping from gov
public class GovController implements GovOperation {

  // @Autowired
  // private UserService userService;

  @Autowired
  private PostService postService;

  @Autowired
  private CommentService commentService;

  @Autowired
  private GovMapper govMapper; // @Component

  @Autowired
  private GovService govService;


  @Override
  public ApiResp<List<UserPostDTO>> getUsers() {
    List<UserPostDTO> userPostDTOs = govService.getUsers().stream().map(e -> {
      List<PostDTO> postDTOs = postService.getPosts().stream() // post DTO builder List ...
          .filter(p -> p.getUserId() == e.getId()) // change the List<Post> to List<PostDTO>
          .map(p -> {
            return PostDTO.builder() //
                .id(p.getId()) //
                .title(p.getTitle()) //
                .body(p.getBody()).build();
          }).collect(Collectors.toList());

      return UserPostDTO.builder() // return the data
          .id(e.getId())//
          .username(e.getUsername())//
          .email(e.getEmail())//
          .phone(e.getPhone())//
          .postDTOs(postDTOs)//
          .build();
    }).collect(Collectors.toList());

    return ApiResp.<List<UserPostDTO>>builder() // return if ok only , other do in service part
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(userPostDTOs) // shown the data
        .build();
  }

  // @Override
  // public UserPostDTO getUser(int userId) {
  // // 1. User Service
  // // 2. Post Service
  // // 3. Relate the user and post
  // // 4. set DTO object
  // User expectedUser = userService.getUsers().stream()
  // .filter(e -> e.getId() == userId).findFirst().get();

  // // List<Post> postList = postService.getPosts();
  // List<PostDTO> postDTOList = postService.getPosts().stream()//
  // .filter(e -> e.getUserId() == userId)//
  // .map(post -> PostDTO.builder()//
  // .id(post.getId())//
  // .title(post.getTitle())//
  // .body(post.getBody())//
  // .build())//
  // .collect(Collectors.toList());

  // // for (int i = 0; i < postList.size(); i++) {
  // // if (postList.get(i).getUserId() == userId) {
  // // postDTOList.add(new PostDTO(postList.get(i).getId(),
  // // postList.get(i).getTitle(), postList.get(i).getBody()));
  // // }
  // // }

  // UserPostDTO userPostDTO = new UserPostDTO(expectedUser.getUsername(),
  // expectedUser.getEmail(), expectedUser.getPhone(), postDTOList);

  // return userPostDTO;
  // }

  // @Override
  // public UserCommentDTO getUserCommentDTO(int userId) {
  // UserCommentDTO userCommentDTO = new UserCommentDTO();
  // return userCommentDTO;
  // }

  @Override
  public ApiResp<UserPostDTO> getUser(int userId) { // (Outside input)
    // Get User by Id
    // 1. User Service
    // 2. Post Service
    // 3. relate the user and post
    // 4. set DTO object and return
    User user = govService.getUser(userId);
log.info("USER     " + user);
    List<PostDTO> postDTOs = postService.getPosts().stream() // post DTO builder List ...
        .filter(e -> e.getUserId() == userId) //
        .map(e -> {
          return PostDTO.builder() //
              .id(e.getId()) //
              .title(e.getTitle()) //
              .body(e.getBody()).build();
        }).collect(Collectors.toList());

    UserPostDTO userPostDTO = UserPostDTO.builder() // return the data
        .id(user.getId()).username(user.getUsername()).email(user.getEmail())
        .phone(user.getPhone()).postDTOs(postDTOs).build();

    return ApiResp.<UserPostDTO>builder() // return if ok only , other do in service part
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(userPostDTO) // shown the data
        .build();
  }

  @Override
  public UserCommentDTO getUserComments(int userId) {
    return null;
  }

  // GlobalExceptionHandler -> NPE
  @Override
  public String testNPE() {
    String s = null;
    return s.concat("hello");
  }

  @Override
  public UserDTO testModelMapper() {
    User user = User.builder()//
        .id(3)//
        .email("abc@gmail.com")//
        .phone("+852 76589047")//
        .username("johnlau")//
        .name("John")//
        .build();
    return govMapper.map(user); // from User to UserDTO
  }

}

