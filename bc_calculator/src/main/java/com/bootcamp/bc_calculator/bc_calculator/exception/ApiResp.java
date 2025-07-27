package com.bootcamp.bc_calculator.bc_calculator.exception;

import lombok.Getter;

@Getter
public class ApiResp<T> {
  private int code;
  private String message;
  private T data;

  public static <T> Builder<T> builder() {
    return new Builder<>();
  }

  private ApiResp(Builder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  } 

  @Getter
  public static class Builder<T> {
    private int code;
    private String message;
    private T data;
  

  public Builder<T> invalidInput() {
    this.code = SysError.INVALID_INPUT.getCode();
    this.message = SysError.INVALID_INPUT.getMessage();
    return this;
  }

  public Builder<T> data(T data) {
    this.data = data;
    return this;
  }
  public ApiResp<T> build() {
    return new ApiResp<>(this);
  }
}
}