package com.demo.springboot.bootcampsbcalculator.service.Impl;

import org.springframework.stereotype.Service;
import com.demo.springboot.bootcampsbcalculator.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

  @Override
  public double divide(int x, int y) {
    if (y == 0)
      throw new ArithmeticException("Can not divide 0");
    return x / y;
  }

  @Override
  public int add(int x, int y) {
    return x + y;
  }

  @Override
  public int multiply(int x, int y) {
    return x * y;
  }

  @Override
  public int substract(int x, int y) {
    return x - y;
  }
}
