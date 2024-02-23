package com.bootcampsbforum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcampsbforum.entity.PostEntity;


@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
  
}
