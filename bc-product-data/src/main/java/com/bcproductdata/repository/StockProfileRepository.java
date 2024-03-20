package com.bcproductdata.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bcproductdata.entity.ProfileEntity;


@Repository
public interface StockProfileRepository
    extends JpaRepository<ProfileEntity, Long> {

  List<ProfileEntity> findByQuoteStockCode(String quoteStockCode);

  @Query(
      value = "SELECT p FROM ProfileEntity p WHERE p.quoteStockCode = :symbol ORDER BY p.quoteDate DESC LIMIT 1")
  ProfileEntity getMostRecentProfileEntityBySymbol(
      @Param("symbol") String symbol);

}
