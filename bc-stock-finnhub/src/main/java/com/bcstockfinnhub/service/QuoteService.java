package com.bcstockfinnhub.service;

import com.bcstockfinnhub.model.Quote;

public interface QuoteService {

  Quote getQuote(String symbol) throws Exception;
  
}
