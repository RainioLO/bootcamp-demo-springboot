package com.bcproductdata.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bcproductdata.entity.StockIdEntity;

@Repository
public interface StockIdRepository extends JpaRepository<StockIdEntity, Long> {

  // List<StockIdEntity> findByStockId(String stockId);

  List<StockIdEntity> findByStockIdIn(List<String> stockIds);

  @Query(value = "SELECT se FROM StockIdEntity se WHERE se.stockId = :stockId")
  StockIdEntity findByStockId(@Param("stockId") String stockId);

}
