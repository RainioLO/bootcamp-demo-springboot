package com.bootcampsbforum.infra;

public class RequestParamException extends BusinessRuntimeException {

  public RequestParamException(Syscode syscode) {
    super(syscode);
  }

  public RequestParamException(){
    
  }


}
