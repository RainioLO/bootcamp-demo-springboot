package com.bootcampsbforum.service;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bootcampsbforum.infra.ApiResp;
import com.bootcampsbforum.model.dto.jph.User;


public interface UserService {

  List<User> getUsers();

  User getUser(int index);

  com.bootcampsbforum.entity.User findByUsername(String username);

  // List<User> findAllByEmailAndPhone(String email, String phone);

  // List<User> findAllByEmailOrPhone(String email, String phone);

  // @Query("SELECT e FROM User e WHERE Integer.valueOf(e.addrLat) > : lat")
  // List<User> findAllByAddrLatGreaterThan(@Param("lat") Integer latitude);

  // @Query(value = "SELECT count(1) FROM USERS u WHERE u.name LIKE ':prefix%' ", nativeQuery = true)
  // Long countUserByNameStartWith(@Param("prefix") String prefix);
  // List<User> findAllByAddrLatGreaterThan(Double latitude);

  List<com.bootcampsbforum.entity.User> getAllByEmailOrPhone(String email,
      String phone, Sort sort);

  List<com.bootcampsbforum.entity.User> getUsersByAddrLatGreaterThan(
      Double latitude);

  Long countUserByName(String prefix);

  void updateUserEmailById(Long id, String email);

  com.bootcampsbforum.entity.User updateUserById(Long id,
      com.bootcampsbforum.entity.User user);

}
