package com.bcproductdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bcproductdata.entity.MarketEntity;

public interface MarketRepository extends JpaRepository<MarketEntity, Long> {

  @Query(
      value = "SELECT m FROM MarketEntity m WHERE m.quoteCoinCode = :symbol ORDER BY m.quoteDate DESC LIMIT 1")
  MarketEntity getMostRecentMarketEntityBySymbol(
      @Param("symbol") String symbol);

}
