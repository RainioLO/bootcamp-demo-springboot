package com.bcstockfinnhub.exception;

import org.springframework.web.client.RestClientException;
import com.bcstockfinnhub.infra.Syscode;

public class ThirdAPIException extends RestClientException {

  private String code;

  public ThirdAPIException(Syscode syscode) {
    super(syscode.getMessage());
    this.code = syscode.getCode();
  }


}
