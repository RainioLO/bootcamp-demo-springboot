package com.bootcampsbforum.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bootcampsbforum.entity.User;
import com.bootcampsbforum.infra.ApiResp;
import java.util.List;


@Repository // Bean // componenetScan will find this class -> create bean --> put into the spring context
public interface UserRepository extends JpaRepository<User, Long> { // create a primary key auto generated strategy// JpaRepository<Entity, Key Type>

  //save(), saveAll()
  // Hibernate (implementation class) // cannot see the code of Hibernate here --> 
  // create Bean -> Spring Context
  // Objective: Implement JPA interface
  // help to insert into

  // 對應不同product --> connect to different

  // select * from users where username = ?
  User findByUsername(String username);

  // Hibernate support method generation 
  // findAll, findFirst

  List<User> findAllByEmailAndPhone(String email, String phone);

  List<User> findAllByEmailOrPhone(String email, String phone, Sort sort);

  //JPQL e is the whole entity
  // is java ...
  @Query("SELECT e FROM User e WHERE CAST(e.addrLat AS double) > :lat")
  List<User> findAllByAddrLatGreaterThan(@Param("lat") Double latitude);

  //Native SQL // different product may have different syntax , dont write sql in the java
  // Product specific, may re compile
  @Query(value = "SELECT count(1) FROM USERS u WHERE lower(u.name) LIKE lower(concat(:prefix, '%'))", nativeQuery = true)
  Long countUserByNameStartWith(@Param("prefix") String prefix);
  // List<User>findAllByAddrLatGreaterThan

  // Hibernate (implementation class) -> Bean -> Spring Context
  // Objectives implement JPA interface

  // JPQL
  @Modifying
  @Query("UPDATE User u SET u.email = :newEmail WHERE u.id = :userId")
  void updateUser(@Param("userId") Long id, @Param("newEmail") String email);


}
