package com.bcproductdata.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// @Builder
// @ToString
@Entity
@Table(name = "tproduct_coins_list")
public class CoinIdEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "coin_code")
  private String coinId;

  @OneToOne(mappedBy = "coinIdEntity", cascade = CascadeType.ALL,
      orphanRemoval = true) // serialization
  @JsonManagedReference // prevent infinite loop
  private CoinEntity coinEntity;

}
