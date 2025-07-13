package com.vtxlab.demo.helloworld.demo_helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@ResponseBody
public class HelloController {
  @GetMapping(value = "/hello") // api endpoint (avoid duplicate endpoint URL)
  public String helloWorld() {
      return "Hello. Welcome to Spring Boot!!!!";
  }

 // ! update URL, try again
  // ! update return type, return different types (BigDecimal, Wrapper Class)
  // ! create one more api, return cat object
  // ! create one more api, return List<Cat> object
  // ! how about hashmap?
  // ! Return ShoppingMall

}
