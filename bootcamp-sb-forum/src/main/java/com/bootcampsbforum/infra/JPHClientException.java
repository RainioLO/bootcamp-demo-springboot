package com.bootcampsbforum.infra;

public class JPHClientException extends BusinessRuntimeException {

  public JPHClientException(Syscode syscode) {
    super(syscode);
  }
}
