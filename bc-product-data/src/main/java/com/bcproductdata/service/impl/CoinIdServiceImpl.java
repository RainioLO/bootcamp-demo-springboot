package com.bcproductdata.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bcproductdata.dto.Coin;
import com.bcproductdata.entity.CoinIdEntity;
import com.bcproductdata.exception.BusinessRuntimeException;
import com.bcproductdata.infra.Scheme;
import com.bcproductdata.infra.Syscode;
import com.bcproductdata.mapper.CoinIdMapper;
import com.bcproductdata.mapper.UriCompBuilder;
import com.bcproductdata.model.ApiRespCoins;
import com.bcproductdata.model.CoinId;
import com.bcproductdata.repository.CoinIdRepository;
import com.bcproductdata.service.CoinIdService;

@Service
public class CoinIdServiceImpl implements CoinIdService {

  @Value(value = "${api.internal.crypto.host}")
  private String host;

  @Value(value = "${api.internal.crypto.port}")
  private int port;

  @Value(value = "${api.internal.crypto.basepath}")
  private String basepath;

  @Value(value = "${api.internal.crypto.endpoints.list}")
  private String listEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private CoinIdRepository coinIdRepository;

  // @Autowired
  // private CoinRepository coinRepostory;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private CoinIdMapper coinIdMapper;

  @Override
  public List<CoinId> setCoinId(List<CoinId> ids)
      throws JsonProcessingException {

    List<Coin> coins = this.getCoins();

    List<CoinId> coinIdList = coins.stream() //
        .map(e -> {
          CoinId id = new CoinId();
          id.setCoinId(e.getId());
          return id;
        }) //
        .collect(Collectors.toList());

    if (!(coinIdList.containsAll(ids))) {
      throw new BusinessRuntimeException(Syscode.ERROR);
    }

    Set<CoinId> coinIds = coinIdRepository.findAll() //
        .stream() //
        .map(e -> coinIdMapper.mapCoinId(e)) //
        .collect(Collectors.toSet());

    for (CoinId id : ids) {
      if (coinIds.contains(id))
        continue;

      coinIdRepository.save(coinIdMapper.mapCoinIdEntity(id));
    }


    return ids;

  }

  @Override
  public List<CoinId> getCoinIds() throws JsonProcessingException {

    List<CoinIdEntity> updatedEntities = coinIdRepository.findAll();

    return updatedEntities.stream() //
        .map(e -> coinIdMapper.mapCoinId(e)) //
        .collect(Collectors.toList());

  }

  @Override
  public Boolean deleteCoinId(List<CoinId> ids) throws JsonProcessingException {

    Set<CoinId> coinIds = coinIdRepository.findAll() //
        .stream() //
        .map(e -> coinIdMapper.mapCoinId(e)) //
        .collect(Collectors.toSet());

    if (!(coinIds.containsAll(ids))) {
      return false;
    }

    List<String> idStrings =
        ids.stream().map(e -> e.getCoinId()).collect(Collectors.toList());

    List<CoinIdEntity> entitiesToRemove =
        coinIdRepository.findByCoinIdIn(idStrings);

    coinIdRepository.deleteAll(entitiesToRemove);

    return true;

  }

  @Override
  public Boolean deleteAllCoinIds() throws JsonProcessingException {

    coinIdRepository.deleteAll();

    return true;
  }

  @Override
  public List<Coin> getCoins() throws JsonProcessingException {

    String urlString2 =
        UriCompBuilder.url(Scheme.HTTP, host, port, basepath, listEndpoint);

    String JsonString = restTemplate.getForObject(urlString2, String.class);

    ApiRespCoins apiResp =
        objectMapper.readValue(JsonString, ApiRespCoins.class);

    List<Coin> coinList = apiResp.getData();

    return coinList;

  }

}
