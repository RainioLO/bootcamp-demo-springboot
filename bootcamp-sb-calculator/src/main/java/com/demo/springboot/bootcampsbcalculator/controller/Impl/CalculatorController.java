package com.demo.springboot.bootcampsbcalculator.controller.Impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.springboot.bootcampsbcalculator.controller.CalculatorOperation;
import com.demo.springboot.bootcampsbcalculator.infra.ApiResp;
import com.demo.springboot.bootcampsbcalculator.infra.Syscode;
import com.demo.springboot.bootcampsbcalculator.infra.exception.BusinessException;
import com.demo.springboot.bootcampsbcalculator.infra.exception.InvalidCalculationException;
import com.demo.springboot.bootcampsbcalculator.infra.exception.ResourceNotFound;
import com.demo.springboot.bootcampsbcalculator.model.Calculate;
import com.demo.springboot.bootcampsbcalculator.model.Result;
import com.demo.springboot.bootcampsbcalculator.model.dto.CalculatorDTO;
import com.demo.springboot.bootcampsbcalculator.service.CalculatorService;


@RestController // @Controller + ResponseBody
@RequestMapping(value = "/api/v1")
public class CalculatorController implements CalculatorOperation {

  @Autowired
  private CalculatorService calculatorService;

  @Override
  public ApiResp<Result> calculate( // ApiResp the total response including the data and the status
      CalculatorDTO calculatorDTO) throws BusinessException {

    Result result = null;
    Calculate calcOperation =
        Calculate.fromString(calculatorDTO.getOperation());

    switch (calcOperation) {
      case ADD:
        result = calculatorService.add(Double.parseDouble(calculatorDTO.getX()),
            Double.parseDouble(calculatorDTO.getY()));
        break;
      case DIVIDE:
        result =
            calculatorService.divide(Double.parseDouble(calculatorDTO.getX()),
                Double.parseDouble(calculatorDTO.getY()));
        break;
      case MULTIPLY:
        result =
            calculatorService.multiply(Double.parseDouble(calculatorDTO.getX()),
                Double.parseDouble(calculatorDTO.getY()));
        break;
      case SUBTRACT:
        result = calculatorService.substract(
            Double.parseDouble(calculatorDTO.getX()),
            Double.parseDouble(calculatorDTO.getY()));
        break;
      default:
        throw new UnsupportedOperationException(
            "Operation " + calculatorDTO.getOperation() + " is not supported.");
    }
    return ApiResp.<Result>builder() // ApiResp build and return an object
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(result) //
        .build(); // ResponseEntity.ok() -> http status = 200
  }

  @Override
  public ApiResp<Result> getCalculate(String x, String y, String operation)
      throws BusinessException {

    Result result = null;
    Calculate calcOperation = Calculate.fromString(operation);

    switch (calcOperation) {
      case ADD:
        result =
            calculatorService.add(Double.parseDouble(x), Double.parseDouble(y));
        break;
      case DIVIDE:
        result = calculatorService.divide(Double.parseDouble(x),
            Double.parseDouble(y));
        break;
      case MULTIPLY:
        result = calculatorService.multiply(Double.parseDouble(x),
            Double.parseDouble(y));
        break;
      case SUBTRACT:
        result = calculatorService.substract(Double.parseDouble(x),
            Double.parseDouble(y));
        break;
      default:
        throw new UnsupportedOperationException(
            "Operation " + operation + " is not supported.");
    }
    return ApiResp.<Result>builder() // ApiResp build and return an object
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(result) //
        .build(); // ResponseEntity.ok() -> http status = 200
  }
}



// @Override
// public String getCalculation(String x, String y, String operation) {
// Calculate calcOperation = Calculate.fromString(operation);
// switch (calcOperation) {
// case ADD:
// return calculatorService.add(Integer.parseInt(x), Integer.parseInt(y));
// case DIVIDE:
// return calculatorService.divide(Integer.parseInt(x),
// Integer.parseInt(y));
// case MULTIPLY:
// return calculatorService.multiply(Integer.parseInt(x),
// Integer.parseInt(y));
// case SUBTRACT:
// return calculatorService.substract(Integer.parseInt(x),
// Integer.parseInt(y));
// default:
// throw new UnsupportedOperationException(
// "Operation " + operation + " is not supported.");
// }
// }

