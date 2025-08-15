package com.thymeleaf1.demo_thymeleaf.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HelloworldPage {
  @GetMapping(value = "/hellopage")
  public String helloPage(Model model) { // bean
    // String x = "!!!";
    model.addAttribute("message", "!!!");
    return "helloworld"; // html file name
  }
}