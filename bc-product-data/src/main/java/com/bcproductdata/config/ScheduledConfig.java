package com.bcproductdata.config;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.bcproductdata.service.CryptoService;
import com.bcproductdata.service.FinnhubService;
import com.bcproductdata.service.StockDailyService;
import jakarta.transaction.Transactional;

@Configuration
@EnableScheduling
public class ScheduledConfig {

  @Autowired
  private CryptoService cryptoService;

  @Autowired
  private FinnhubService finnhubService;

  @Autowired
  private StockDailyService stockDailyService;

  // @Scheduled(fixedRate = 60000)
  @Scheduled(cron = "0 * * * * *") // every xx:xx:00
  @Transactional
  void reflashCryptoDB() throws JsonProcessingException {
    // cryptoService.clearCoinsFromDB();
    cryptoService.storeCoinsToDB();

  }

  // @Scheduled(fixedRate = 60000)
  @Scheduled(cron = "0 * * * * *") // every xx:xx:00
  @Transactional
  void reflashCoinEntityDB() throws JsonProcessingException {
    cryptoService.clearCoinEntitiesFromDB();
    cryptoService.storeCoinEntitiesToDB();
  }

  // @Scheduled(fixedRate = 60000)
  @Scheduled(cron = "0 * * * * *") // every xx:xx:00
  @Transactional
  void reflashStocksDB() throws JsonProcessingException {
    // finnhubService.clearProfilesFromDB();
    finnhubService.saveProfilesToDB();
    // finnhubService.clearQuotesFromDB();
    finnhubService.saveQuotesToDB();
  }

  // @Scheduled(fixedRate = 60000)
  @Scheduled(cron = "0 * * * * *") // every xx:xx:00
  @Transactional
  void reflashStockEntityDB() throws JsonProcessingException {
    finnhubService.clearStockEntitiesFromDB();
    finnhubService.storeStockEntitiesToDB();
  }

  // @Scheduled(fixedRate = 10000)
  @Scheduled(cron = "1 * 21 * * *", zone = "America/New_York")
  void saveStockDailyRadis() {

    try {
      stockDailyService.saveDataToRedis();
      System.out
          .println("Stock Daily - Redis update time= " + LocalDateTime.now());
    } catch (Exception ex) {
    }
  }

  // @Scheduled(fixedRate = 60000)
  @Scheduled(cron = "1 * 21 * * *", zone = "America/New_York")
  void reflashStockDailyEntityDB() throws JsonProcessingException {
    finnhubService.reflashStockDailyEntityInDB();
  }

}
