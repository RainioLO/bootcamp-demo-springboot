package com.demo.springboot.bootcampsbcalculator.model;

import com.demo.springboot.bootcampsbcalculator.infra.Syscode;
import com.demo.springboot.bootcampsbcalculator.infra.exception.InvalidCalculationException;

public enum Calculate {

  DIVIDE("div"), MULTIPLY("mul"), ADD("add"), SUBTRACT("sub");

  private final String operationCode;

  Calculate(String operationCode) {
    this.operationCode = operationCode;
  }

  public String getOperationCode() {
    return this.operationCode;
  }

  public static Calculate fromString(String operationCode)
      throws InvalidCalculationException {
    for (Calculate operation : Calculate.values()) {
      if (operation.getOperationCode().equalsIgnoreCase(operationCode)) {
        return operation;
      }
    }
    throw new InvalidCalculationException(Syscode.NO_SUCH_CODE);
  }
}
