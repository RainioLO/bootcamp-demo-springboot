package com.bootcampsbforum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcampsbforum.infra.ApiResp;
import com.bootcampsbforum.infra.JPHClientException;
import com.bootcampsbforum.infra.RequestParamException;
import com.bootcampsbforum.infra.Syscode;

@RestControllerAdvice
public class LocalExceptionHandler {

  @ExceptionHandler(RequestParamException.class) // what to catch ...
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Void> requestParamExceptionHandler(RequestParamException e) { // extend BusinessRuntime Exception
    return ApiResp.<Void>builder() //
        .status(Syscode.REQUEST_PARAM_EXCEPTION) //
        .data(null) //
        .build(); //
  }
}
