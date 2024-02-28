package com.bcstockfinnhub.infra;

import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor

public class ApiResponse<T> {

  private String code;
  private String message;
  private T data;
  
}
