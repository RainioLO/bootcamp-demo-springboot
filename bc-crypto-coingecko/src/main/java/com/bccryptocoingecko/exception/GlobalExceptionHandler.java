package com.bccryptocoingecko.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import com.bccryptocoingecko.infra.ApiResponse;
import com.bccryptocoingecko.infra.CurrencyNotFoundException;
import com.bccryptocoingecko.infra.KeyExpiredException;
import com.bccryptocoingecko.infra.Syscode;

@RestControllerAdvice

public class GlobalExceptionHandler {


  @ExceptionHandler(HttpClientErrorException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse<Void> HttpClientErrorExceptionHandler(Exception e) {
    return ApiResponse.<Void>builder() //
        .code(Syscode.COINGECKO_FAIL_EXCEPTION.getCode()) //
        .message(Syscode.COINGECKO_FAIL_EXCEPTION.getMessage()) //
        .data(null) //
        .build(); //
  }

  @ExceptionHandler(NullPointerException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse<Void> NullPointerExceptionHandler(NullPointerException e) {
    return ApiResponse.<Void>builder() //
        .code(Syscode.NPE_EXCEPTION.getCode()) //
        .message(Syscode.NPE_EXCEPTION.getMessage()) //
        .data(null) //
        .build(); //
  }

  @ExceptionHandler(KeyExpiredException.class)
  @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
  public ApiResponse<Void> KeyExpiredExceptionHandler(KeyExpiredException e) {
    return ApiResponse.<Void>builder() //
        .code(getRespCode(e).getCode()) //
        .message(getRespCode(e).getMessage())//
        .data(null) //
        .build(); //
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
  public ApiResponse<Void> IllegalArgumentExceptionHandler(Exception e) {
    return ApiResponse.<Void>builder() //
        .code(Syscode.NPE_EXCEPTION.getCode()) //
        .message(Syscode.NPE_EXCEPTION.getMessage())//
        .data(null) //
        .build(); //
  }

  @ExceptionHandler(CurrencyNotFoundException.class)
  @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
  public ApiResponse<Void> CurrencyNotFoundExceptionHandler(
      CurrencyNotFoundException e) {
    return ApiResponse.<Void>builder() //
        .code(Syscode.CURRENCY_NOTFOUND.getCode()) //
        .message(Syscode.CURRENCY_NOTFOUND.getMessage()) //
        .data(null) //
        .build(); //
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResponse<Void> ExceptionHandler(Exception e) {
    return ApiResponse.<Void>builder() //
        .code(Syscode.GENERAL_EXCEPTION.getCode()) //
        .message(Syscode.GENERAL_EXCEPTION.getMessage()) //
        .data(null) //
        .build(); //
  }

  private static Syscode getRespCode(Exception e) {
    if (e instanceof RuntimeException)
      return Syscode.COINGECKO_FAIL_EXCEPTION;
    if (e instanceof HttpClientErrorException)
      return Syscode.COINGECKO_FAIL_EXCEPTION;
    if (e instanceof IllegalArgumentException)
      return Syscode.NPE_EXCEPTION;
    return Syscode.GENERAL_EXCEPTION;
  }

}
