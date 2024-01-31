package com.demo.springboot.bootcampsbcalculator.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.springboot.bootcampsbcalculator.controller.CalculatorOperation;
import com.demo.springboot.bootcampsbcalculator.service.CalculatorService;


@RestController // @Controller + ResponseBody
@RequestMapping(value = "/api/v1")
public class CalculatorController implements CalculatorOperation {

  @Autowired
  private CalculatorService calculatorService;

  @Override()
  public double calculate(int x, int y, String operation) {
    switch (operation) {
      case "a":
        return calculatorService.add(x, y);
      case "d":
        return calculatorService.divide(x, y);
      case "m":
        return calculatorService.multiply(x, y);
      case "s":
        return calculatorService.substract(x, y);
      default:
        throw new UnsupportedOperationException(
            "Operation " + operation + " is not supported.");
    }
  }


}
