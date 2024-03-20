package com.bcproductdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcproductdata.entity.CoinIdEntity;
import java.util.List;

@Repository
public interface CoinIdRepository extends JpaRepository<CoinIdEntity, Long> {

  List<CoinIdEntity> findByCoinId(String coinId);

  List<CoinIdEntity> findByCoinIdIn(List<String> coinIds);

}
