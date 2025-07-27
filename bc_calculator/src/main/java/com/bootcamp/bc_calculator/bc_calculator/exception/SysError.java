package com.bootcamp.bc_calculator.bc_calculator.exception;

import lombok.Getter;

@Getter
public enum SysError {
  INVALID_INPUT(9, "Invalid Input."),
  ;
  
  private int code;
  private String message;

  private SysError(int code, String message) {
    this.code = code;
    this.message = message;
  }
  public static void main(String[] args) {
    System.out.println(INVALID_INPUT.getMessage());
  }
}
