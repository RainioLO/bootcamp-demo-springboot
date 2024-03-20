package com.bcproductdata.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bcproductdata.entity.QuoteEntity;


@Repository
public interface StockQuoteRepository extends JpaRepository<QuoteEntity, Long> {

  List<QuoteEntity> findByQuoteStockCode(String quoteStockCode);

  @Query(
      value = "SELECT q FROM QuoteEntity q WHERE q.quoteStockCode = :symbol ORDER BY q.quoteDate DESC LIMIT 1")
  QuoteEntity getMostRecentQuoteEntityBySymbol(@Param("symbol") String symbol);

}
