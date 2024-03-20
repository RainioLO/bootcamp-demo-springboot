package com.bcproductdata.dto;

import java.io.Serializable;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.bcproductdata.entity.StockDailyEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@EqualsAndHashCode
public class StockDailyDTO implements Serializable {

  @JsonProperty(value = "productId")
  private String productId;

  @JsonProperty(value = "tradeDate")
  private LocalDate tradeDate;

  @JsonProperty(value = "dayHigh")
  private Double dayHigh;

  @JsonProperty(value = "dayLow")
  private Double dayLow;

  @JsonProperty(value = "dayOpen")
  private Double dayOpen;

  @JsonProperty(value = "dayClose")
  private Double dayClose;

  public static StockDailyDTO mapToStockDailyDTO(StockDailyEntity entity) {

    return new StockDailyDTO(entity.getStockIdEntity2().getStockId(), //
        entity.getTradeDate(), //
        entity.getDayHigh(), //
        entity.getDayLow(), //
        entity.getDayOpen(), //
        entity.getDayClose() //
    );
  }

}