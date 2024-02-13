package com.bootcampsbforum.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcampsbforum.entity.User;
import com.bootcampsbforum.repository.UserRepository;
import com.bootcampsbforum.service.ForumDatabaseService;

@Service
public class ForumDatabaseHolder implements ForumDatabaseService {

  // service call repository layer
  @Autowired
  private UserRepository userRepository; // no metter interface or not just autowire

  @Override
  public List<User> saveUsers(List<User> users) {
    return userRepository.saveAll(users);
  }

  @Override
  public void deleteAllUsers() {
    userRepository.deleteAll(); // the userRepository have the key User Entity
  }

  @Override
  public User saveUser(User user) { // save entity in the server
    return userRepository.save(user);
  }

}
