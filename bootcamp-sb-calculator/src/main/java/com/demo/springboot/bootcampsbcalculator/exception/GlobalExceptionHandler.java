package com.demo.springboot.bootcampsbcalculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.demo.springboot.bootcampsbcalculator.infra.ApiResp;
import com.demo.springboot.bootcampsbcalculator.infra.Syscode;
import com.demo.springboot.bootcampsbcalculator.infra.exception.InvalidCalculationException;

@RestControllerAdvice

public class GlobalExceptionHandler {

  @ExceptionHandler(InvalidCalculationException.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResp<Void> InvalidCalculationExceptionHandler(
      InvalidCalculationException e) {
    return ApiResp.<Void>builder().code(Syscode.NO_SUCH_CODE.getCode())
        .message(Syscode.NO_SUCH_CODE.getMessage()).build();
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResp<Void> IllegalArgumentExceptionHandler(
      IllegalArgumentException e) {
    return ApiResp.<Void>builder().code(Syscode.INVALID_INPUT.getCode())
        .message(Syscode.INVALID_INPUT.getMessage()).build();
  }

  @ExceptionHandler(ArithmeticException.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResp<Void> ArithmeticExceptionExceptionHandler(
    ArithmeticException e) {
    return ApiResp.<Void>builder().code(Syscode.MATH_PROBLEM.getCode())
        .message(Syscode.MATH_PROBLEM.getMessage()).build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResp<Void> npeExceptionHandler(Exception e) {
    return ApiResp.<Void>builder().code(Syscode.GENERAL_EXCEPTION.getCode())
        .message(Syscode.GENERAL_EXCEPTION.getMessage()).build();
  }

}
