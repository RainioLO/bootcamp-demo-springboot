package com.bcproductdata.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bcproductdata.dto.StockDailyDTO;
import com.bcproductdata.entity.QuoteEntity;
import com.bcproductdata.entity.StockDailyEntity;
import com.bcproductdata.entity.StockIdEntity;
import com.bcproductdata.mapper.StockDailyMapper;
import com.bcproductdata.mapper.StockIdMapper;
import com.bcproductdata.model.StockId;
import com.bcproductdata.repository.StockIdRepository;
import com.bcproductdata.repository.StockQuoteRepository;
import com.bcproductdata.service.RedisService;
import com.bcproductdata.service.StockDailyService;
import jakarta.transaction.Transactional;

@Service
public class StockDailyServiceImpl implements StockDailyService {

  @Autowired
  private StockIdMapper stockIdMapper;

  @Autowired
  private StockQuoteRepository stockQuoteRepository;

  @Autowired
  private StockIdRepository stockIdRepository;

  @Autowired
  private StockDailyMapper stockDailyMapper;

  @Autowired
  private RedisService redisService;

  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public List<StockDailyEntity> getStockDaily(String symbol) {

    StockId id = stockIdMapper.mapSymbolId(symbol);

    QuoteEntity qEntity =
        stockQuoteRepository.getMostRecentQuoteEntityBySymbol(symbol);

    StockDailyEntity todayEntity =
        stockDailyMapper.mapStockDailyEntity(qEntity, id);

    // System.out.println("Today Entity = " + todayEntity);


    StockIdEntity stockIdEntity =
        stockIdRepository.findByStockId(id.getStockId());

    List<StockDailyEntity> stockDailyEntities =
        stockIdEntity.getStockDailyEntities();

    // Decending order
    Collections.sort(stockDailyEntities,
        (e1, e2) -> e2.getTradeDate().compareTo(e1.getTradeDate()));

    if (!(stockDailyEntities.get(0).getTradeDate()
        .equals(todayEntity.getTradeDate()))) {
      stockDailyEntities.add(todayEntity);
    }

    return stockDailyEntities;
  }


  @Override
  @Transactional
  public void saveDataToRedis() throws JsonProcessingException {

    // Get valid stock IDs
    List<StockIdEntity> idEntities = stockIdRepository.findAll();

    // convert from entity to id
    List<StockId> ids = idEntities.stream()//
        .map(e -> stockIdMapper.mapSymbolId(e))//
        .collect(Collectors.toList());

    for (StockId id : ids) {

      // generate key of redis
      String keyString = new StringBuilder("stock:daily:")//
          .append(id.getStockId())//
          .toString();

      // Get Primary Key Object from repository
      StockIdEntity stockIdEntity =
          stockIdRepository.findByStockId(id.getStockId());

      // get a list of daily record from primary key object
      List<StockDailyEntity> stockDailyEntities =
          stockIdEntity.getStockDailyEntities();

      // sort daily record in decending order of date
      List<StockDailyDTO> stockDailyDTOs = stockDailyEntities.stream()//
          .map(StockDailyDTO::mapToStockDailyDTO)//
          .sorted(Comparator.comparing(StockDailyDTO::getTradeDate).reversed())
          .collect(Collectors.toList());

      // System.out.println("List of DTO = " + stockDailyDTOs);

      // generate value of redis
      String value = objectMapper.writeValueAsString(stockDailyDTOs);

      // System.out.println("key = " + keyString + ", value = " + value);
      // save to redis
      redisService.setValue(keyString, value);

    }


  }



}
