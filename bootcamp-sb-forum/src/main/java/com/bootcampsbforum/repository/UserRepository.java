package com.bootcampsbforum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcampsbforum.entity.User;

@Repository // Bean // componenetScan will find this class -> create bean --> put into the spring context
public interface UserRepository extends JpaRepository<User, Long> { // create a primary key auto generated strategy// JpaRepository<Entity, Key Type>

  // Hibernate (implementation class) // cannot see the code of Hibernate here --> 
  // create Bean -> Spring Context
  // Objective: Implement JPA interface
  // help to insert into

  // 對應不同product --> connect to different


}
