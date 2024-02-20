package com.bootcampsbforum.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Access database
@Entity // Coonnect to the database is @Entity --> JPA direcly control the database
@Table(name = "Users") // the database table name
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Setter
public class User implements Serializable { // if no implement cannot put the attribute to the interface

  // all round, multi platform

  // define the column in the table
  @Id // PK primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generated
  private long id;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;
  private String street;
  private String suite;
  private String city;
  private String zipcode;
  @Column(name = "ADDRESS_LAT") // set the column name as
  private String addrLat;
  @Column(name = "ADDRESS_LNG")
  private String addrLong;
  @Column(name = "COMPANY_NAME")
  private String cName;
  @Column(name = "COMPANY_CATCH_PHRASE")
  private String cCatchPhrase;
  @Column(name = "COMPANY_BUSINESS_SERVICE")
  private String cBusService;

}

