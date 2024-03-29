package com.bootcampsbforum.service.Impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcampsbforum.infra.JPHClientException;
import com.bootcampsbforum.infra.Syscode;
import com.bootcampsbforum.mapper.GovMapper;
import com.bootcampsbforum.model.dto.jph.User;
import com.bootcampsbforum.service.ForumDatabaseService;
import com.bootcampsbforum.service.GovService;
import com.bootcampsbforum.service.UserService;

@Service
public class GovServiceHolder implements GovService {

  @Autowired
  private UserService userservice;

  @Autowired
  private ForumDatabaseService forumDatabaseService;

  @Autowired
  private GovMapper govMapper;

  @Override
  public User getUser(int id) {
    User user = userservice.getUser(id);
    forumDatabaseService.deleteAllUsers();
    if (user != null) {
      // convert entity to dto user
      forumDatabaseService.saveUser(govMapper.mapEntity(user));
    }
    return user;
  }

  @Override
  public List<User> getUsers() {
    // call JPH
    List<User> users = userservice.getUsers();
    if (users.size() == 0){
      throw new JPHClientException(Syscode.JPH_NOT_AVAILABLE);
    }

    // save all
    List<com.bootcampsbforum.entity.UserEntity> userEntities = users.stream()//
        .map(e -> govMapper.mapEntity(e))//
        .collect(Collectors.toList());
    forumDatabaseService.saveUsers(userEntities); // from jph to entities and save in database
    // return
    return users; // return userEntities to the database
  }

}
