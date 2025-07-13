package com.bootcamp.demo.bc_calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface BcCalculatorOperation {

  @GetMapping(value = "/operation/{x}")
  String getX(String x);

  @GetMapping(value = "/operation/{y}")
  String getY(String y);

  @GetMapping(value = "/operation/{operation}")
  String getOperation(String operation);
 
  @GetMapping(value = "/operation/{x}/{y}/{operation}")
  String operation(@PathVariable String x, @PathVariable String y, @PathVariable String operation);

 
  
}
