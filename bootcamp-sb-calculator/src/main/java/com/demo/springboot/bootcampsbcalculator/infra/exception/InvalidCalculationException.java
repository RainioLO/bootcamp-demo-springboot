package com.demo.springboot.bootcampsbcalculator.infra.exception;

import com.demo.springboot.bootcampsbcalculator.infra.Syscode;

public class InvalidCalculationException extends BusinessException {

  public InvalidCalculationException(Syscode syscode) {
    super(syscode);
  }

}
