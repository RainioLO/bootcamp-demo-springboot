package com.demo.springboot.bootcampsbcalculator.service;

import com.demo.springboot.bootcampsbcalculator.model.Result;

public interface CalculatorService {
  
  Result divide(double x, double y);

  Result add (double x, double y);

  Result multiply (double x, double y);

  Result substract (double x, double y);
}
