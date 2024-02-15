package com.bootcampsbforum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import com.bootcampsbforum.infra.ApiResp;
import com.bootcampsbforum.infra.JPHClientException;
import com.bootcampsbforum.infra.ResourceNotFound;
import com.bootcampsbforum.infra.Syscode;

@RestControllerAdvice // Bean: @ControllerAdvice + @ResponseBody, will help to catch the logic between the method
// let itself to be bean let other new
public class GlobalExceptionHandler { // is the catcher

  // from up to down
  // check each of the method if have retrun new Exception ...
  @ExceptionHandler(JPHClientException.class) // what to catch ...
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResp<Void> JPHClientExceptionHandler(JPHClientException e) { // extend BusinessRuntime Exception
    return ApiResp.<Void>builder() //
        .code(e.getCode()) //
        .message(e.getMessage()) //
        .data(null).build(); //
  }

  @ExceptionHandler(RestClientException.class) // what to catch ...
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResp<Void> restClientExceptionHandler(RestClientException e) { // can throw here alos, but poor log
    return ApiResp.<Void>builder().code(Syscode.REST_CLIENT_EXCEPTION.getCode())
        .message(Syscode.REST_CLIENT_EXCEPTION.getMessage()).data(null).build();
  }

  @ExceptionHandler(ResourceNotFound.class)
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResp<Void> npeExceptionHandler(ResourceNotFound e) {
    return ApiResp.<Void>builder() //
        .code(Syscode.NOTFOUND.getCode()) //
        .message(Syscode.NOTFOUND.getMessage()) //
        .data(null) //
        .build();
  }

  @ExceptionHandler(NullPointerException.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResp<Void> npeExceptionHandler(NullPointerException e) {
    return ApiResp.<Void>builder().code(Syscode.NPE_EXCEPTION.getCode())
        .message(Syscode.NPE_EXCEPTION.getMessage()).data(null).build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
  public ApiResp<Void> npeExceptionHandler(Exception e) {
    return ApiResp.<Void>builder().code(Syscode.GENERAL_EXCEPTION.getCode())
        .message(Syscode.GENERAL_EXCEPTION.getMessage()).data(null).build();
  }
}
