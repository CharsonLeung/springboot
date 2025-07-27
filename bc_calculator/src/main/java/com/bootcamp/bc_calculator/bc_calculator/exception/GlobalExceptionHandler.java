package com.bootcamp.bc_calculator.bc_calculator.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = BusinessException.class)
  public ApiResp<ErrorDTO> catchBusinessException(BusinessException ex) {
    ErrorDTO errorDTO = ErrorDTO.builder() //
      .code(ex.getCode()) //
      .message(ex.getMessage()) //
      .build();
    return ApiResp.<ErrorDTO>builder()
      .invalidInput()
      .data(errorDTO)
      .build();
  }

  @ExceptionHandler(value = RuntimeException.class)
  public ErrorDTO catchRuntimeException(RuntimeException ex) {
    return ErrorDTO.builder()
        .code(SysError.INVALID_INPUT.getCode()) //
        .message(SysError.INVALID_INPUT.getMessage()) //
        .build();
  }
}
