package com.bootcampsbforum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcampsbforum.controller.UserOperation;
import com.bootcampsbforum.model.dto.jph.User;
import com.bootcampsbforum.service.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController implements UserOperation {

    @Autowired
    private UserService userService;

  @Override
  public List<User> getUsers(){
    System.out.println("start controller");
    return userService.getUsers();
  }
  
}
