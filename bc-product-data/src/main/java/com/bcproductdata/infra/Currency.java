package com.bcproductdata.infra;

import com.bcproductdata.exception.InvalidCurrencyException;

public enum Currency {

  USD,;

  public static Currency toCurrency(String currency) {
    for (Currency cur : Currency.values()) {
      if (cur.name().toLowerCase().equals(currency)) {
        return cur;
      }
    }
    throw new InvalidCurrencyException(Syscode.INVALID_CURRENCY_EXCEPTION);
  }

  public static boolean isValidCurrency(String currency) {
    for (Currency cur : Currency.values()) {
      if (cur.name().toLowerCase().equals(currency))
        return true;
    }
    return false;
  }


}
