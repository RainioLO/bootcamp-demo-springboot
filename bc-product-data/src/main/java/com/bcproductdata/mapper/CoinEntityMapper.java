package com.bcproductdata.mapper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bcproductdata.dto.Market;
import com.bcproductdata.entity.CoinEntity;
import com.bcproductdata.entity.CoinIdEntity;
import com.bcproductdata.entity.MarketEntity;
import com.bcproductdata.exception.BusinessRuntimeException;
import com.bcproductdata.infra.Syscode;
import com.bcproductdata.model.CoinId;
import com.bcproductdata.repository.CoinIdRepository;

@Component
public class CoinEntityMapper {

  // @Autowired
  // private CoinIdMapper coinIdMapper;

  @Autowired
  private CoinIdRepository coinIdRepository;

  public CoinEntity mapCoinEntity(Market market, CoinId id) {

    List<CoinIdEntity> coinIdEntities =
        coinIdRepository.findByCoinId(id.getCoinId());

    if (coinIdEntities.size() == 0) {
      throw new BusinessRuntimeException(Syscode.ERROR);
    }

    CoinIdEntity coinIdEntity = coinIdEntities.get(0);

    CoinEntity coinEntity = new CoinEntity(null, //
        id.getCoinId(), //
        market.getCurrentPrice(), //
        market.getPriceChangePercent24h(), //
        (double) market.getMarketCap(), //
        market.getImage(), //
        // null);
        coinIdEntity);

    // coinIdEntity.setCoinEntity(coinEntity);

    return coinEntity;

  }


  public CoinEntity mapCoinEntity(MarketEntity market, CoinId id) {

    List<CoinIdEntity> coinIdEntities =
        coinIdRepository.findByCoinId(id.getCoinId());

    if (coinIdEntities.size() == 0) {
      throw new BusinessRuntimeException(Syscode.ERROR);
    }

    CoinIdEntity coinIdEntity = coinIdEntities.get(0);

    CoinEntity coinEntity = new CoinEntity(null, //
        market.getName(), //
        market.getCurrentPrice(), //
        market.getPriceChangePct24h(), //
        market.getMarketCap(), //
        market.getImage(), //
        coinIdEntity);

    // coinIdEntity.setCoinEntity(coinEntity);

    return coinEntity;

  }

}
