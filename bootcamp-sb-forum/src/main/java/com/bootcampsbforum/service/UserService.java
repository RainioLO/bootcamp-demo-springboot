package com.bootcampsbforum.service;

import java.util.List;
import com.bootcampsbforum.model.dto.jph.User;


public interface UserService {
  
  List<User> getUsers();

  User getUser(int index);
}
