package com.bcproductdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bcproductdata.entity.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, Long> {

}
