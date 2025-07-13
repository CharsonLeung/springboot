package com.bootcamp.demo.bc_calculator.controller.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_calculator.controller.BcCalculatorOperation;
import com.bootcamp.demo.bc_calculator.lib.Operation;

@RestController
@ResponseBody
public class BCCalculatorController implements BcCalculatorOperation {

  @Override
  public String getX(String x) {
    return x;
  }

  @Override
  public String getY(String y) {
    return y;
  }

  @Override
  public String getOperation(String operation) {
    return operation;
  }
  
  
  @Override
  public String operation(String x, String y, String operation) {
    Double result = 0.0;
    if (operation.equals(Operation.add.getValue())) {
       result = BigDecimal.valueOf(Double.parseDouble(x))
                .add(BigDecimal.valueOf(Double.parseDouble(y))).doubleValue();
  } else if (operation.equals(Operation.subtract.getValue())) {
       result =  BigDecimal.valueOf(Double.parseDouble(x))
                .subtract(BigDecimal.valueOf(Double.parseDouble(y))).doubleValue();
  } else if (operation.equals(Operation.multiply.getValue())) { 
       result =  BigDecimal.valueOf(Double.parseDouble(x))
                .multiply(BigDecimal.valueOf(Double.parseDouble(y))).doubleValue();
  } else if (operation.equals(Operation.divide.getValue())) {
       result =  BigDecimal.valueOf(Double.parseDouble(x))
                .divide(BigDecimal.valueOf(Double.parseDouble(y)), 5, RoundingMode.HALF_UP)
                .doubleValue();
  } else {return Double.toString(result);}
      return Double.toString(result);
  } 
  public static void main(String[] args) {
    BCCalculatorController c = new BCCalculatorController();
    Double a = 3.4;
    Double b = 6.6;
    System.out.println(c.operation(Double.toString(a), Double.toString(b), "div"));
    System.out.println(c.operation(Double.toString(a), Double.toString(b), "add"));
    System.out.println(c.operation(Double.toString(a), Double.toString(b), "sub"));
    System.out.println(c.operation(Double.toString(a), Double.toString(b), "mul"));
    System.out.println(Double.toString(3.3));
  }
}

