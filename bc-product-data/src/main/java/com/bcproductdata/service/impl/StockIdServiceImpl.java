package com.bcproductdata.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.bcproductdata.dto.Symbol;
import com.bcproductdata.entity.StockIdEntity;
import com.bcproductdata.exception.BusinessRuntimeException;
import com.bcproductdata.infra.Scheme;
import com.bcproductdata.infra.Syscode;
import com.bcproductdata.mapper.StockIdMapper;
import com.bcproductdata.mapper.UriCompBuilder;
import com.bcproductdata.model.StockId;
import com.bcproductdata.repository.StockIdRepository;
import com.bcproductdata.service.StockIdService;

@Service
public class StockIdServiceImpl implements StockIdService {

  @Value(value = "${api.internal.stock.host}")
  private String host;

  @Value(value = "${api.internal.stock.port}")
  private int port;

  @Value(value = "${api.internal.stock.basepath}")
  private String basepath;

  @Value(value = "${api.internal.stock.endpoints.quote}")
  private String quoteEndpoint;

  @Value(value = "${api.internal.stock.endpoints.profile2}")
  private String profileEndpoint;

  @Value(value = "${api.internal.stock.endpoints.symbols}")
  private String symbolEndpoint;

  @Autowired
  private StockIdRepository stockIdRepository;

  @Autowired
  private StockIdMapper stockIdMapper;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<StockId> setStockId(List<StockId> ids)
      throws JsonProcessingException {
    List<Symbol> symbols = this.getSymbols();

    Set<StockId> stockIds = stockIdRepository.findAll() //
        .stream() //
        .map(e -> stockIdMapper.mapSymbolId(e)) //
        .collect(Collectors.toSet());

    for (StockId id : ids) {
      if (!(Symbol.isValidSymbol(symbols, id.getStockId()))) {
        throw new BusinessRuntimeException(Syscode.ERROR);
      }
    }

    stockIds.addAll(ids);

    List<StockIdEntity> entities = stockIds.stream() //
        .map(e -> stockIdMapper.mapSymbolIdEntity(e)) //
        .collect(Collectors.toList());

    stockIdRepository.deleteAll();
    stockIdRepository.saveAll(entities);

    return ids;
  }

  @Override
  public List<StockId> getStockIds() throws JsonProcessingException {
    return stockIdRepository.findAll() //
        .stream() //
        .map(e -> stockIdMapper.mapSymbolId(e)) //
        .collect(Collectors.toList());
  }

  // @Override
  public List<StockIdEntity> getStockIdEntities()
      throws JsonProcessingException {
    return stockIdRepository.findAll() //
        .stream() //
        .collect(Collectors.toList());
  }

  @Override
  public Boolean deleteStockId(List<StockId> ids)
      throws JsonProcessingException {

    // System.out.println("Delete Coin.");
    Set<StockId> stockIds = stockIdRepository.findAll() //
        .stream() //
        .map(e -> stockIdMapper.mapSymbolId(e)) //
        .collect(Collectors.toSet());

    if (!(stockIds.containsAll(ids))) {
      return false;
    }

    List<String> idStrings =
        ids.stream().map(e -> e.getStockId()).collect(Collectors.toList());

    List<StockIdEntity> entitiesToRemove =
        stockIdRepository.findByStockIdIn(idStrings);

    stockIdRepository.deleteAll(entitiesToRemove);

    return true;

  }


  @Override
  public Boolean deleteAllStockIds() throws JsonProcessingException {

    stockIdRepository.deleteAll();

    return true;
  }


  @Override
  public List<Symbol> getSymbols() throws JsonProcessingException {
    String urlString =
        UriCompBuilder.url(Scheme.HTTP, host, port, basepath, symbolEndpoint);

    Symbol[] symbols = restTemplate.getForObject(urlString, Symbol[].class);

    return Arrays.stream(symbols) //
        .collect(Collectors.toList());

  }

}
