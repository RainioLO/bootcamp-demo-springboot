package com.bootcampsbforum.service;

import java.util.List;
import com.bootcampsbforum.entity.UserEntity;

public interface ForumDatabaseService {

  // inject the local user to the database
  List<UserEntity> saveUsers(List<UserEntity> users); // the entity

  void deleteAllUsers();

  UserEntity saveUser(UserEntity user);

}
