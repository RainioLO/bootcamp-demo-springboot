package com.bcstockfinnhub.model;

import com.bcstockfinnhub.exception.SymbolNotFoundException;
import com.bcstockfinnhub.infra.Syscode;
import lombok.Getter;

@Getter
public enum Symbol {

  AAPL("AAPL"), TSLA("TSLA"), MSFT("MSFT"),;

  private String message;

  private Symbol(String message) {
    this.message = message;
  }

  public static Symbol fromString(String request) {
    for (Symbol symbol : Symbol.values()) {
      if (symbol.getMessage().equals(request)) {
        return symbol;
      }
    }
    throw new SymbolNotFoundException(Syscode.INVALID_SYMBOL);
  }
}
