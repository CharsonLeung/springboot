package com.bootcamp.bc_calculator.bc_calculator.controller;

import com.bootcamp.bc_calculator.bc_calculator.model.dto.ResultDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface BcCalculatorOperation {

  @GetMapping(value = "/operation")
  ResultDTO operation(@RequestParam String x, @RequestParam String y, @RequestParam String operation);

  @PostMapping(value = "/operation")
  ResultDTO postOperation(@RequestBody String x, @RequestBody String y, @RequestBody String operation);
  
  @GetMapping(value = "/operation/{x}/{y}/{operation}")
  ResultDTO operation2(@PathVariable String x, @PathVariable String y, @PathVariable String operation);
  
}
