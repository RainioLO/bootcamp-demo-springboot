package com.bcproductdata.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
// @ToString
// @Builder
@Entity
@Table(name = "tproduct_stocks_list")
public class StockIdEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "stock_code")
  private String stockId;

  @OneToOne(mappedBy = "stockIdEntity", cascade = CascadeType.ALL, orphanRemoval = true) // serialization
  @JsonManagedReference // prevent infinite loop
  private StockEntity stockEntity; 

  @OneToMany(mappedBy = "stockIdEntity2", cascade = CascadeType.ALL, orphanRemoval = true) // serialization
  @JsonManagedReference // prevent infinite loop
  private List<StockDailyEntity> stockDailyEntities = new ArrayList<>(); 

}
