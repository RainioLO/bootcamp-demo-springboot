// package com.bccryptocoingecko.entity;

// import java.io.Serializable;
// import org.springframework.boot.autoconfigure.domain.EntityScan;
// import org.springframework.stereotype.Indexed;
// import com.fasterxml.jackson.annotation.JsonProperty;
// import jakarta.annotation.Generated;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Entity
// @Table(name = "Coins")
// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor

// public class CoinEntity implements Serializable {
//   @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
//   private Long id;
  
//   private String name;
//   private String symbol;
//   private String image;

//   @Column(name = "Price USD")
//   @JsonProperty("current_price")
//   private double currentPrice;

//   @JsonProperty("market_cap_rank")
//   private int marketCapRank;

//   @JsonProperty("high_24h")
//   private double high24h;

//   @JsonProperty("low_24h")
//   private double low24h;
// }