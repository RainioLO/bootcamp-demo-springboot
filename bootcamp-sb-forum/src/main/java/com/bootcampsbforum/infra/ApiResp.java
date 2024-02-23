package com.bootcampsbforum.infra;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// ApiResp.builder().code().message().data().build();

// ApiResponse is for serialization (RestTemplate call -> ObjectMapper), getter, setter are required (from Object to Json, by ObjeectMapper, writeStringasValue)
// For deserlization (controller(spring) -> ObjectMapper) (restful call) (from Json to Object) ,only getter is required

// RestTemplate.getObject() is similar to RedisHelper.get()

// @Getter
// @Builder
//@JsonSerialize
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResp<T> {

  private String code;

  private String message;

  private T data; // our data in any type

  // builder()
  // public static builder(){

  // }

  public ApiResp(ApiResponseBuilder<T> builder) { // constructor
    this.code = builder.code;
    this.data = builder.data;
    this.message = builder.message;
  }

  public static <T> ApiResponseBuilder<T> builder() {
    // ApiResponseBuilder<T> apiResponseBuilder = new ApiResponseBuilder<>();
    // apiResponseBuilder.code = Syscode.OK.getCode(); // static class
    // apiResponseBuilder.message = Syscode.OK.getMessage();
    // return apiResponseBuilder; // when new this --> same as the return type
    return new ApiResponseBuilder<>();
  }


  public static class ApiResponseBuilder<T> {

    private String code;
    private String message;
    private T data;

    public ApiResponseBuilder<T> code(String code) {
      this.code = code;
      return this;
    }

    public ApiResponseBuilder<T> message(String message) {
      this.message = message;
      return this;
    }

    public ApiResponseBuilder<T> data(T data) {
      this.data = data;
      return this;
    }

    public ApiResponseBuilder<T> ok() {
      this.code = Syscode.OK.getCode();
      this.message = Syscode.OK.getMessage();
      return this;
    }

    public ApiResponseBuilder<T> status(Syscode syscode) {
      this.code = syscode.getCode();
      this.message = syscode.getMessage();
      return this;
    }

    public ApiResp<T> build() {
      return new ApiResp<>(this);
    }

  }
}
