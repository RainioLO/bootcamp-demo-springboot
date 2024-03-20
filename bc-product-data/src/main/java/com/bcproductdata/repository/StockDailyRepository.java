package com.bcproductdata.repository;

import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bcproductdata.entity.StockDailyEntity;
import com.bcproductdata.entity.StockIdEntity;

@Repository
public interface StockDailyRepository
    extends JpaRepository<StockDailyEntity, Long> {

  @Query(
      value = "SELECT se FROM StockDailyEntity se WHERE se.stockIdEntity2 = :stockIdEntity AND se.tradeDate = :date")
  StockDailyEntity getDailyEntityByDateAndSymbol(
      @Param("stockIdEntity") StockIdEntity stockIdEntity,
      @Param("date") LocalDate date);

}
