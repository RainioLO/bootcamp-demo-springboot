package com.demo.springboot.bootcampsbcalculator.service.Impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.springboot.bootcampsbcalculator.model.Calculate;
import com.demo.springboot.bootcampsbcalculator.model.Result;
import com.demo.springboot.bootcampsbcalculator.model.dto.CalculatorDTO;
import com.demo.springboot.bootcampsbcalculator.model.dto.mapper.ResultMapper;
import com.demo.springboot.bootcampsbcalculator.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

  @Autowired
  private ResultMapper resultMapper;

  @Override
  public Result divide(double x, double y) {
    if (y == 0)
      throw new ArithmeticException("Can not divide 0");
    BigDecimal result = BigDecimal.valueOf(x).divide(BigDecimal.valueOf(y), 5,
        RoundingMode.HALF_UP);

    CalculatorDTO calculatorDTO = CalculatorDTO.builder()//
        .x(String.valueOf(x))//
        .y(String.valueOf(y))//
        .operation(Calculate.DIVIDE.getOperationCode())//
        .build();

    Result divResult = resultMapper.map(calculatorDTO); // input DTO to Result
    divResult.setResult(String.valueOf(result));
    return divResult;
  }

  // autoired will help to ind the method
  @Override
  public Result add(double x, double y) {
    CalculatorDTO calculatorDTO = CalculatorDTO.builder()//
        .x(String.valueOf(x))//
        .y(String.valueOf(y))//
        .operation(Calculate.ADD.getOperationCode())//
        .build();

    Result addResult = resultMapper.map(calculatorDTO);
    addResult.setResult(String.valueOf(x + y));

    return addResult;
  }

  @Override
  public Result multiply(double x, double y) {
    CalculatorDTO calculatorDTO = CalculatorDTO.builder()//
        .x(String.valueOf(x))//
        .y(String.valueOf(y))//
        .operation(Calculate.MULTIPLY.getOperationCode())//
        .build();
    Result mulResult = resultMapper.map(calculatorDTO);
    mulResult.setResult(String.valueOf(x * y));
    return mulResult;
  }

  @Override
  public Result substract(double x, double y) {
    CalculatorDTO calculatorDTO = CalculatorDTO.builder()//
        .x(String.valueOf(x))//
        .y(String.valueOf(y))//
        .operation(Calculate.MULTIPLY.getOperationCode())//
        .build();
    Result subResult = resultMapper.map(calculatorDTO);
    subResult.setResult(String.valueOf(x - y));
    return subResult;
  }


}
