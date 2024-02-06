package com.bootcampsbforum.infra;

public class ResourceNotFound extends BusinessRuntimeException {

  public ResourceNotFound(Syscode syscode) { // can only pass enum
    super(syscode);
  }

}
