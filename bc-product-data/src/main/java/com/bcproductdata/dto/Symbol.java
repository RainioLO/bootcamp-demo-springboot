package com.bcproductdata.dto;

import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Symbol {

  private String currency;
  private String description;
  private String displaySymbol;
  private String figi;
  private String isin;
  private String mic;
  private String symbol;
  private String symbol2;
  private String type;

  public static boolean isValidSymbol(List<Symbol> symbols, String symbol) {

    for (Symbol sym: symbols) {
      if (sym.getSymbol().equals(symbol)) {
        return true;
      }
    }
    return false;
  }


}