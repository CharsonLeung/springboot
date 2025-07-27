package com.bootcamp.bc_calculator.bc_calculator.controller.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.bc_calculator.bc_calculator.controller.BcCalculatorOperation;
import com.bootcamp.bc_calculator.bc_calculator.exception.SysError;
import com.bootcamp.bc_calculator.bc_calculator.lib.Operation;
import com.bootcamp.bc_calculator.bc_calculator.model.dto.ResultDTO;

@RestController
public class BcCalculatorController implements BcCalculatorOperation {

  @Override
  public ResultDTO operation(String x, String y, String operation) {
  Double result = 0.0;
    if (operation.equals(Operation.add.toString())) {
       result = BigDecimal.valueOf(Double.parseDouble(x))
                .add(BigDecimal.valueOf(Double.parseDouble(y))).doubleValue();
  } else if (operation.equals(Operation.sub.toString())) {
       result =  BigDecimal.valueOf(Double.parseDouble(x))
                .subtract(BigDecimal.valueOf(Double.parseDouble(y))).doubleValue();
  } else if (operation.equals(Operation.mul.toString())) { 
       result =  BigDecimal.valueOf(Double.parseDouble(x))
                .multiply(BigDecimal.valueOf(Double.parseDouble(y))).doubleValue();
  } else if (operation.equals(Operation.div.toString())) {
       result =  BigDecimal.valueOf(Double.parseDouble(x))
                .divide(BigDecimal.valueOf(Double.parseDouble(y)), 5, RoundingMode.HALF_UP)
                .doubleValue();
  } else {
      return ResultDTO.builder()
            .code(SysError.INVALID_INPUT.getCode())
            .message(SysError.INVALID_INPUT.getMessage())
            .build();}
          return ResultDTO.builder()
            .x(x)
            .y(y)
            .operation(operation)
            .result(Double.toString(result))
            .code(null)
            .build();
  }

@Override
@RequestMapping(value = "/operation", method = RequestMethod.POST)
public ResultDTO postOperation(String x, String y, String operation) {
  Double result = 0.0;
    if (operation.equals(Operation.add.toString())) {
       result = BigDecimal.valueOf(Double.parseDouble(x))
                .add(BigDecimal.valueOf(Double.parseDouble(y))).doubleValue();
  } else if (operation.equals(Operation.sub.toString())) {
       result =  BigDecimal.valueOf(Double.parseDouble(x))
                .subtract(BigDecimal.valueOf(Double.parseDouble(y))).doubleValue();
  } else if (operation.equals(Operation.mul.toString())) { 
       result =  BigDecimal.valueOf(Double.parseDouble(x))
                .multiply(BigDecimal.valueOf(Double.parseDouble(y))).doubleValue();
  } else if (operation.equals(Operation.div.toString())) {
       result =  BigDecimal.valueOf(Double.parseDouble(x))
                .divide(BigDecimal.valueOf(Double.parseDouble(y)), 5, RoundingMode.HALF_UP)
                .doubleValue();
  } else {return ResultDTO.builder()
            .code(SysError.INVALID_INPUT.getCode())
            .message(SysError.INVALID_INPUT.getMessage())
            .build();}
          return ResultDTO.builder()
            .x(x)
            .y(y)
            .operation(operation)
            .result(Double.toString(result))
            .code(null)
            .build();
  }

  @Override
  public ResultDTO operation2(String x, String y, String operation) {
  Double result = 0.0;
    if (operation.equals(Operation.add.toString())) {
       result = BigDecimal.valueOf(Double.parseDouble(x))
                .add(BigDecimal.valueOf(Double.parseDouble(y))).doubleValue();
  } else if (operation.equals(Operation.sub.toString())) {
       result =  BigDecimal.valueOf(Double.parseDouble(x))
                .subtract(BigDecimal.valueOf(Double.parseDouble(y))).doubleValue();
  } else if (operation.equals(Operation.mul.toString())) { 
       result =  BigDecimal.valueOf(Double.parseDouble(x))
                .multiply(BigDecimal.valueOf(Double.parseDouble(y))).doubleValue();
  } else if (operation.equals(Operation.div.toString())) {
       result =  BigDecimal.valueOf(Double.parseDouble(x))
                .divide(BigDecimal.valueOf(Double.parseDouble(y)), 5, RoundingMode.HALF_UP)
                .doubleValue();
  } else {return ResultDTO.builder()
            .code(SysError.INVALID_INPUT.getCode())
            .message(SysError.INVALID_INPUT.getMessage())
            .build();}
          return ResultDTO.builder()
            .x(x)
            .y(y)
            .operation(operation)
            .result(Double.toString(result))
            .code(null)
            .build();
  }
}
