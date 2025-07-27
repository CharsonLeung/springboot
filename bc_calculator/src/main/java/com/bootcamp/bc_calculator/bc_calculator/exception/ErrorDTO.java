package com.bootcamp.bc_calculator.bc_calculator.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorDTO {
  private int code;
  private String message;
}
