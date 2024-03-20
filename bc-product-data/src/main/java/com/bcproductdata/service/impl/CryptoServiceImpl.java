package com.bcproductdata.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bcproductdata.dto.Market;
import com.bcproductdata.entity.CoinEntity;
import com.bcproductdata.entity.CoinIdEntity;
import com.bcproductdata.entity.MarketEntity;
import com.bcproductdata.exception.BusinessRuntimeException;
import com.bcproductdata.infra.Currency;
import com.bcproductdata.infra.Scheme;
import com.bcproductdata.infra.Syscode;
import com.bcproductdata.mapper.CoinEntityMapper;
import com.bcproductdata.mapper.MarketMapper;
import com.bcproductdata.mapper.UriCompBuilder;
import com.bcproductdata.model.ApiRespMarkets;
import com.bcproductdata.model.CoinId;
import com.bcproductdata.model.CoinIdEnum;
import com.bcproductdata.repository.CoinIdRepository;
import com.bcproductdata.repository.CoinRepository;
import com.bcproductdata.repository.MarketRepository;
import com.bcproductdata.service.CoinIdService;
import com.bcproductdata.service.CryptoService;
import jakarta.transaction.Transactional;

@Service
public class CryptoServiceImpl implements CryptoService {

  @Value(value = "${api.internal.crypto.host}")
  private String host;

  @Value(value = "${api.internal.crypto.port}")
  private int port;

  @Value(value = "${api.internal.crypto.basepath}")
  private String basepath;

  @Value(value = "${api.internal.crypto.endpoints.list}")
  private String listEndpoint;

  @Value(value = "${api.internal.crypto.endpoints.markets}")
  private String marketsEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private CoinIdService coinIdService;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private MarketMapper marketMapper;

  @Autowired
  private CoinEntityMapper coinEntityMapper;

  // @Autowired
  // private CoinIdMapper coinIdMapper;

  @Autowired
  private MarketRepository marketRepository;

  @Autowired
  private CoinIdRepository coinIdRepository;


  @Autowired
  private CoinRepository coinRepository;

  @Override
  public Boolean storeCoinsToDB() throws JsonProcessingException {

    List<Market> markets = this.getMarkets(Currency.USD);

    List<MarketEntity> entities = markets.stream() //
        .map(e -> marketMapper.mapMarketEntity(e, Currency.USD)) //
        .collect(Collectors.toList());

    marketRepository.saveAll(entities);

    return true;
  }

  @Override
  public Boolean clearCoinsFromDB() throws JsonProcessingException {
    marketRepository.deleteAll();
    return true;
  }

  @Override
  public Boolean storeBitcoinsToDB() throws JsonProcessingException {

    CoinId id = CoinId.builder()//
        .coinId(CoinIdEnum.BITCOIN.name().toLowerCase())//
        .build();

    String urlString = UriCompBuilder.urlCoinsMarket(Scheme.HTTP, host, port,
        basepath, marketsEndpoint, Currency.USD, id.getCoinId());

    String jsonString = restTemplate.getForObject(urlString, String.class);

    ApiRespMarkets apiResp =
        objectMapper.readValue(jsonString, ApiRespMarkets.class);

    List<Market> markets = apiResp.getData();

    if (markets.size() == 0) {
      throw new BusinessRuntimeException(Syscode.ERROR);
    }

    List<MarketEntity> entities = markets.stream() //
        .map(e -> marketMapper.mapMarketEntity(e, Currency.USD)) //
        .collect(Collectors.toList());

    marketRepository.saveAll(entities);

    return true;

  }

  @Override
  @Transactional
  public Boolean storeCoinEntitiesToDB() throws JsonProcessingException {

    this.clearCoinEntitiesFromDB();

    List<CoinId> coinIds = coinIdService.getCoinIds();

    for (CoinId id : coinIds) {

      MarketEntity marketEntity =
          marketRepository.getMostRecentMarketEntityBySymbol(id.getCoinId());

      if (marketEntity == null) {

        Market market = this.getMarket(Currency.USD, id);

        marketEntity = marketMapper.mapMarketEntity(market, Currency.USD);

      }

      CoinEntity coinEntity = coinEntityMapper.mapCoinEntity(marketEntity, id);

      coinRepository.save(coinEntity);

    }

    return true;
  }

  @Override
  @Transactional
  public Boolean clearCoinEntitiesFromDB() throws JsonProcessingException {

    List<CoinIdEntity> coinIdEntities = coinIdRepository.findAll();

    for (CoinIdEntity coinIdEntity : coinIdEntities) {
      coinIdEntity.setCoinEntity(null);
    }

    coinRepository.deleteAll();

    return true;
  }


  @Override
  public List<CoinEntity> getCoinMarketPrices() {
    return coinRepository.findAll();
  }


  private List<Market> getMarkets(Currency currency)
      throws JsonProcessingException {

    List<CoinId> coinIds = coinIdService.getCoinIds();

    if (coinIds.size() == 0) {
      throw new BusinessRuntimeException(Syscode.ERROR);
    }

    String ids = coinIds.stream().map(e -> e.getCoinId())
        .collect(Collectors.joining(","));

    String urlString = UriCompBuilder.urlCoinsMarket(Scheme.HTTP, host, port,
        basepath, marketsEndpoint, Currency.USD, ids);

    String jsonString = restTemplate.getForObject(urlString, String.class);

    ApiRespMarkets apiResp =
        objectMapper.readValue(jsonString, ApiRespMarkets.class);

    List<Market> markets = apiResp.getData();

    return markets;
  }

  private Market getMarket(Currency currency, CoinId id)
      throws JsonProcessingException {

    String idString = id.getCoinId();

    String urlString = UriCompBuilder.urlCoinsMarket(Scheme.HTTP, host, port,
        basepath, marketsEndpoint, Currency.USD, idString);

    String jsonString = restTemplate.getForObject(urlString, String.class);

    ApiRespMarkets apiResp =
        objectMapper.readValue(jsonString, ApiRespMarkets.class);

    List<Market> markets = apiResp.getData();

    if (markets.size() == 0) {
      throw new BusinessRuntimeException(Syscode.ERROR);
    }

    return markets.get(0);
  }



}
