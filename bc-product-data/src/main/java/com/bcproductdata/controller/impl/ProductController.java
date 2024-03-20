package com.bcproductdata.controller.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bcproductdata.controller.ProductOperation;
import com.bcproductdata.dto.Product;
import com.bcproductdata.dto.StockDailyDTO;
import com.bcproductdata.entity.CoinEntity;
import com.bcproductdata.entity.StockDailyEntity;
import com.bcproductdata.entity.StockEntity;
import com.bcproductdata.infra.ApiResponse;
import com.bcproductdata.mapper.ProductMapper;
import com.bcproductdata.service.CryptoService;
import com.bcproductdata.service.FinnhubService;
import com.bcproductdata.service.RedisService;
import com.bcproductdata.service.StockDailyService;

@RestController
@RequestMapping(value = "/data/api/v1")
public class ProductController implements ProductOperation {

  @Autowired
  private CryptoService cryptoService;

  @Autowired
  private FinnhubService finnhubService;

  @Autowired
  private ProductMapper productMapper;

  @Autowired
  private StockDailyService stockDailyService;

  @Autowired
  private RedisService redisService;

  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public ApiResponse<List<Product>> getProducts()
      throws JsonProcessingException {

    List<Product> products = new LinkedList<>();

    List<Product> coinsProduct = cryptoService.getCoinMarketPrices()//
        .stream()//
        .map(e -> productMapper.mapProduct(e))//
        .collect(Collectors.toList());

    List<Product> stocksProduct = finnhubService.getStockMarketPrices()//
        .stream()//
        .map(e -> productMapper.mapProduct(e))//
        .collect(Collectors.toList());

    products.addAll(coinsProduct);
    products.addAll(stocksProduct);

    return ApiResponse.<List<Product>>builder()//
        .ok()//
        .data(products)//
        .build();

  }


  @Override
  public ApiResponse<List<Product>> getStockMarketPrices()
      throws JsonProcessingException {

    List<StockEntity> stockEntities = finnhubService.getStockMarketPrices();

    List<Product> products = stockEntities.stream()//
        .map(e -> productMapper.mapProduct(e))//
        .collect(Collectors.toList());

    return ApiResponse.<List<Product>>builder()//
        .ok()//
        .data(products)//
        .build();
  }


  @Override
  public ApiResponse<List<Product>> getCoinMarketPrices()
      throws JsonProcessingException {

    List<CoinEntity> coinEntities = cryptoService.getCoinMarketPrices();

    List<Product> products = coinEntities.stream()//
        .map(e -> productMapper.mapProduct(e))//
        .collect(Collectors.toList());

    return ApiResponse.<List<Product>>builder()//
        .ok()//
        .data(products)//
        .build();

  }

  @Override
  public ApiResponse<List<StockDailyDTO>> getStockDaily(String symbol)
      throws JsonProcessingException {

    List<StockDailyEntity> stockDailyEntities =
        stockDailyService.getStockDaily(symbol);

    List<StockDailyDTO> stockDailyDTOs;

    if (stockDailyEntities.size() == 0) {

      String keyString = new StringBuilder("stock:daily:")//
          .append(symbol)//
          .toString();

      String jsonString = redisService.getValue(keyString);

      StockDailyDTO[] dtos =
          objectMapper.readValue(jsonString, StockDailyDTO[].class);

      stockDailyDTOs = Arrays.stream(dtos)//
          .collect(Collectors.toList());

    } else {

      stockDailyDTOs = stockDailyEntities.stream()//
          .map(StockDailyDTO::mapToStockDailyDTO)//
          .sorted(Comparator.comparing(StockDailyDTO::getTradeDate).reversed())//
          .collect(Collectors.toList());
    }

    return ApiResponse.<List<StockDailyDTO>>builder()//
        .ok()//
        .data(stockDailyDTOs)//
        .build();

  }

}
