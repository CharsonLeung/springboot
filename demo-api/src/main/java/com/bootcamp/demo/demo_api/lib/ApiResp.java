package com.bootcamp.demo.demo_api.lib;

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

    //public Buidler<T> code(int code) {
    //  this.code = code;
    //  return this;
    //}

    public Builder<T> ok() {
      this.code = SysCode.OK.getCode();
      this.message = SysCode.OK.getMessage();
      return this;
    }

    public Builder<T> fail() {
      this.code = SysCode.FAIL.getCode();
      this.message = SysCode.FAIL.getMessage();
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
  public static void main(String[] args) {
    ApiResp<String> apiResp = ApiResp.<String>builder() //
      // .code(99998) //
      // .message("abcdef") //
      .data("Vincent")
      .build();
    // apiResp.setData(13); Not OK
    
    // Not ok
    //apiResp = ApiResp.<Integer>builder()
    //  .code(99998) //
    //  .message("abcdef") //
    //  .data(13)
    //  .build();
  }
}
