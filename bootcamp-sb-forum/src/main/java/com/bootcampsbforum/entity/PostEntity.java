package com.bootcampsbforum.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Posts")
@Getter
@Setter 
@AllArgsConstructor
@NoArgsConstructor
// @ToString
// @Builder // Don't use builder in Entity
public class PostEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id // PK primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String body;
  
  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id") // FK
  @JsonBackReference
  private UserEntity user;

}
