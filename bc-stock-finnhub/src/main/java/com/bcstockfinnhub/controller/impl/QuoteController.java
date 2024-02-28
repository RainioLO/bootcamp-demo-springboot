package com.bcstockfinnhub.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bcstockfinnhub.controller.QuoteOperation;
import com.bcstockfinnhub.infra.ApiResponse;
import com.bcstockfinnhub.infra.Syscode;
import com.bcstockfinnhub.model.Profile;
import com.bcstockfinnhub.model.Quote;
import com.bcstockfinnhub.service.ProfileService;
import com.bcstockfinnhub.service.QuoteService;
import com.bcstockfinnhub.service.RedisService;

@RestController
@RequestMapping(value = "/stock/finnhub/api/v1")
public class QuoteController implements QuoteOperation {

  @Autowired
  private QuoteService quoteService;

  @Autowired
  private ProfileService profileService;

  @Autowired
  private RedisService redisService;

  @Override
  public ApiResponse<Quote> getQuote(String symbol) throws Exception {

    Quote quote = quoteService.getQuote(symbol);

    String key = "stock:finnhub:quote:" + symbol;
    redisService.createQuote(key, quote);

    return ApiResponse.<Quote>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(quote) //
        .build();
  }

  @Override
  public ApiResponse<Profile> getProfile(String symbol) throws Exception {

    Profile profile = profileService.getProfile(symbol);

    String key = "stock:finnhub:profile2:" + symbol;
    redisService.createProfile(key, profile);

    return ApiResponse.<Profile>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(profile) //
        .build();
  }

  @Override
  public ApiResponse<Quote> getRedisQuote(String key) throws Exception {

    Quote redisQuote = redisService.getQuote(key);

    if (redisQuote == null) { // NoResourceFoundException
      return ApiResponse.<Quote>builder() //
          .code(Syscode.ERROR.getCode()) //
          .message(Syscode.ERROR.getMessage()) //
          .data(null) //
          .build();
    }

    return ApiResponse.<Quote>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(redisQuote) //
        .build();
  }

  @Override
  public ApiResponse<Profile> getRedisProfile(String key) throws Exception {

    // String key = "stock:finnhub:profile2:" + "{" + symbol + "}";
    Profile redisProfile = redisService.getProfile(key);

    if (redisProfile == null) {
      return ApiResponse.<Profile>builder() //
          .code(Syscode.ERROR.getCode()) //
          .message(Syscode.ERROR.getMessage()) //
          .data(null) //
          .build();
    }

    return ApiResponse.<Profile>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(redisProfile) //
        .build();
  }

}
