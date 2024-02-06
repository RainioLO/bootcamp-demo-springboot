package com.demo.springboot.bootcampsbcalculator.infra.exception;

import com.demo.springboot.bootcampsbcalculator.infra.Syscode;

public class ResourceNotFound extends BusinessException {

  public ResourceNotFound(Syscode syscode) { // can only pass enum
    super(syscode);
  }

}
