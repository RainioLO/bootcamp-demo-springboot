package com.bootcampsbforum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcampsbforum.controller.UserOperation;
import com.bootcampsbforum.infra.ApiResp;
import com.bootcampsbforum.infra.Syscode;
import com.bootcampsbforum.model.dto.jph.User;
import com.bootcampsbforum.service.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController implements UserOperation {

  @Autowired
  private UserService userService;

  @Override
  public List<User> getUsers() {
    System.out.println("start controller");
    return userService.getUsers();
  }


  @Override
  public ApiResp<com.bootcampsbforum.entity.User> findByUsername(
      String username) {
    return ApiResp.<com.bootcampsbforum.entity.User>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(userService.findByUsername(username)) //
        .build();
  }

  @Override
  public ApiResp<Long> countUserByName(String prefix) {
    return ApiResp.<Long>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(userService.countUserByName(prefix)) //
        .build();
  }

  @Override
  public ApiResp<List<com.bootcampsbforum.entity.User>> getUsersByLatGreaterThan(
      String latitude) {
    List<com.bootcampsbforum.entity.User> users =
        userService.getUsersByAddrLatGreaterThan(Double.valueOf(latitude));
    return ApiResp.<List<com.bootcampsbforum.entity.User>>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(users) //
        .build();
  }

  @Override
  public ApiResp<List<com.bootcampsbforum.entity.User>> getUsersByEmailAndPhone(
      String email, String phone) {
    Sort sortByEmailDesc = Sort.by("email").ascending();
    List<com.bootcampsbforum.entity.User> users =
        userService.getAllByEmailOrPhone(email, phone, sortByEmailDesc);
    return ApiResp.<List<com.bootcampsbforum.entity.User>>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(users) //
        .build();
  }

  @Override
  public ApiResp<Void> updateUserEmailById(@PathVariable Long id,
      @PathVariable String email) {
    userService.updateUserEmailById(id, email);
    return ApiResp.<Void>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(null) //
        .build();
  }

  @Override
  public ApiResp<com.bootcampsbforum.entity.User> updateUser(
      @PathVariable Long userId,
      @RequestBody com.bootcampsbforum.entity.User user) {

    return ApiResp.<com.bootcampsbforum.entity.User>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(userService.updateUserById(userId, user)) //
        .build();

  }
}


