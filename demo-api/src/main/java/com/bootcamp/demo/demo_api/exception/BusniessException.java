package com.bootcamp.demo.demo_api.exception;

import lombok.Getter;

// ! For Spring boot, usually we use "unchecked" exception
// because we have Global Exception Handling (RestControllerAdvice)
@Getter
public class BusniessException extends RuntimeException {
  private int code;

  public BusniessException(SysError sysError) {
    super(sysError.getMessage());
    this.code = sysError.getCode();
  }
  // public UserNotFoundException(int code, String message) {
  //  super(message);
  //  this.code = code;
  //}

  
}
