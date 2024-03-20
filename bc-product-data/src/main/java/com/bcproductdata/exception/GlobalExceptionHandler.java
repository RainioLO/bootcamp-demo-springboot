package com.bcproductdata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import com.bcproductdata.infra.ApiResponse;
import com.bcproductdata.infra.Syscode;

@RestControllerAdvice

public class GlobalExceptionHandler {


  @ExceptionHandler(InvalidCurrencyException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse<Void> InvalidCurrencyExceptionHandler(
      InvalidCurrencyException e) {
    return ApiResponse.<Void>builder() //
        .status(Syscode.INVALID_CURRENCY_EXCEPTION) //
        .data(null) //
        .build();
  }


  @ExceptionHandler(ThirdAPIException.class)
  @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
  public ApiResponse<Void> ThirdAPIExceptionHandler(ThirdAPIException e) {
    return ApiResponse.<Void>builder() //
        .status(Syscode.CLIENT_RESPONSE_EXCEPTION) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(SymbolNotFoundException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse<Void> SymbolNotFoundExceptionHandler(
      SymbolNotFoundException e) {
    return ApiResponse.<Void>builder() //
        .status(Syscode.INVALID_SYMBOL) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(NullPointerException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse<Void> NullPointerExceptionHandler(NullPointerException e) {
    return ApiResponse.<Void>builder() //
        .status(Syscode.NPE_EXCEPTION) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
  public ApiResponse<Void> IllegalArgumentExceptionHandler(Exception e) {
    return ApiResponse.<Void>builder() //
        .status(Syscode.NPE_EXCEPTION) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResponse<Void> ExceptionHandler(Exception e) {
    return ApiResponse.<Void>builder() //
        .status(Syscode.GENERAL_EXCEPTION) //
        .data(null) //
        .build();
  }

  // private static Syscode getRespCode(Exception e) {
  // if (e instanceof RuntimeException)
  // return Syscode.COINGECKO_FAIL_EXCEPTION;
  // if (e instanceof HttpClientErrorException)
  // return Syscode.COINGECKO_FAIL_EXCEPTION;
  // if (e instanceof IllegalArgumentException)
  // return Syscode.NPE_EXCEPTION;
  // return Syscode.GENERAL_EXCEPTION;
  // }

}
