package com.bootcampsbforum.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcampsbforum.dto.gov.UserCommentDTO;
import com.bootcampsbforum.dto.gov.UserDTO;
import com.bootcampsbforum.dto.gov.UserPostDTO;
import com.bootcampsbforum.infra.ApiResp;

public interface GovOperation {

  // @GetMapping(value = "/user/{userId}")
  // UserPostDTO getUser(@PathVariable int userId);

  // 1. No user found
  // 2. User found, but no post --> empty array
  @GetMapping(value = "/users")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResp<UserPostDTO> getUser(@RequestParam(value = "id") int userId);

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