package com.thymeleaf1.demo_thymeleaf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// ! RESTFUL API
@RestController // @Controller + @ResponseBody, return JSON body
public class HelloworldController {
  @GetMapping(value = "/hello")
  public String greeting() {
    return "I'm Vincent";
  }
}