package com.bootcampsbforum.controller;

import java.util.List;
import javax.print.attribute.standard.MediaTray;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcampsbforum.dto.gov.request.response.gov.UserCommentDTO;
import com.bootcampsbforum.dto.gov.request.response.gov.UserDTO;
import com.bootcampsbforum.dto.gov.request.response.gov.UserPostDTO;
import com.bootcampsbforum.infra.ApiResp;

public interface GovOperation {

  // @GetMapping(value = "/user/{userId}")
  // UserPostDTO getUser(@PathVariable int userId);

  // 1. No user found
  // 2. User found, but no post --> empty array
  @GetMapping(value = "/user")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResp<UserPostDTO> getUser(@RequestParam(value = "id") int userId);

  @GetMapping(value = "/users")//,produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  ApiResp<List<UserPostDTO>> getUsers();

  // 404 -> request path issue or resource not found
  // 204 -> id not found. Processed the business logic, record not found

  // 1. No user found
  // 2. User found, but no comments --> empty array
  @GetMapping(value = "/comments")
  UserCommentDTO getUserComments(@RequestParam int userId);

  @GetMapping(value = "/test/npe")
  String testNPE();

  // 404 -> request path issue or resource not found
  // 204 -> id not found. Processed the business logic, record not found

  @GetMapping(value = "/test/modelmapper")
  UserDTO testModelMapper();
}
