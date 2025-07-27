package com.bootcamp.bc_calculator.bc_calculator.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
  private int code;

  public BusinessException(SysError sysError) {
    super(sysError.getMessage());
    this.code = sysError.getCode();
  }
}
