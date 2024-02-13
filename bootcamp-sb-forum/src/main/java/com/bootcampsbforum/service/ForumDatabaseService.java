package com.bootcampsbforum.service;

import java.util.List;
import com.bootcampsbforum.entity.User;

public interface ForumDatabaseService {

  // inject the local user to the database
  List<User> saveUsers(List<User> users); // the entity

  void deleteAllUsers();

  User saveUser(User user);

}
