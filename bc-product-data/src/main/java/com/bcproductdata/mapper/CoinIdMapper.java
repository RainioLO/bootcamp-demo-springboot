package com.bcproductdata.mapper;

import org.springframework.stereotype.Component;
import com.bcproductdata.entity.CoinIdEntity;
import com.bcproductdata.model.CoinId;

@Component
public class CoinIdMapper {

  public CoinId mapCoinId(CoinIdEntity entity) {
    return CoinId.builder() //
        .coinId(entity.getCoinId()) //
        .build();
  }

  public CoinIdEntity mapCoinIdEntity(CoinId id) {

    CoinIdEntity coinIdEntity = new CoinIdEntity(null, id.getCoinId(), null);

    return coinIdEntity;
  }

}
