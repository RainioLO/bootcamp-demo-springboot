package com.bcproductdata.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bcproductdata.service.CryptoService;
import com.bcproductdata.service.FinnhubService;
import jakarta.transaction.Transactional;

@Component
public class AppRunner implements CommandLineRunner {

  @Autowired
  private CryptoService cryptoService;

  @Autowired
  private FinnhubService finnhubService;

  @Override
  @Transactional
  public void run(String... args) throws Exception {

    cryptoService.clearCoinsFromDB();
    cryptoService.storeCoinsToDB();
    // cryptoService.storeBitcoinsToDB();

    finnhubService.clearQuotesFromDB();
    finnhubService.saveQuotesToDB();
    // finnhubService.storeAAPLQuoteToDB();

    finnhubService.clearProfilesFromDB();
    finnhubService.saveProfilesToDB();
    // finnhubService.storeAAPLProfileToDB();

    finnhubService.reflashStockDailyEntityInDB();



  }

}
