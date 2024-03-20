package com.bcproductdata.infra;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class ApiResponse<T> {

  private String code;
  private String message;
  private T data;

  private ApiResponse(ApiResponseBuilder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  // ApiResponse.<T>builder().code(xxx).message(xxx).data(xxx).build()

  public static <T> ApiResponseBuilder<T> builder() {
    return new ApiResponseBuilder<>();
  }

  public static class ApiResponseBuilder<T> {

    private String code;
    private String message;
    private T data;

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

    public ApiResponseBuilder<T> data(T data) {
      this.data = data;
      return this;
    }

    public ApiResponse<T> build() {
      return new ApiResponse<>(this);
    }
  }
}
