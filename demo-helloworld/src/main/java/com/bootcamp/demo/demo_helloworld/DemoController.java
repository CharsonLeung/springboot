package com.bootcamp.demo.demo_helloworld;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_helloworld.ShoppingMall.Cinema;
import com.bootcamp.demo.demo_helloworld.ShoppingMall.Cinema.Film;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@ResponseBody
public class DemoController {

  @GetMapping(value = "/hello") // api endpoint (avoid duplicate endpoint URL)
  public String helloworld() {
      return "HelloWorld!";
  }
  @GetMapping(value = "/int")
  public Integer getInt() {
      return 123;
  }
  @GetMapping(value = "/double")
  public Double getDouble() {
      return 3.33333333;
  }
  @GetMapping("/bigdecimal")
  public BigDecimal bd() {
    int now = LocalTime.now().getSecond();
    if (now % 2 == 0) {
      return BigDecimal.valueOf(6.7).add(BigDecimal.valueOf(7.5));
        } else {
    return BigDecimal.valueOf(Math.pow(7.777, 2)).multiply(BigDecimal.valueOf(Math.PI));
        }
   }
   @GetMapping("/cat")
   public Cat getCat() {
       Cat c1 = new Cat("Tom", 13);
       return c1;
   }

   @GetMapping("/catlist")
   public List<Cat> getCatList() {
    Cat c2 = new Cat("Meow", 19);

    return new ArrayList<>(Arrays.asList(c2));
   }

  // ! update URL, try again
  @GetMapping(value = "/goodbye")
  public String goodbye() {
   return "Goodbye";
  } 
  // ! update return type, return different types (BigDecimal, Wrapper Class)
  // ! create one more api, return cat object
  @GetMapping(value = "/cat1")
  public Cat getCat1() {
    return Cat.builder()
        .name("John")
        .age(13)
        .build();
  }
  @GetMapping(value = "/meow")
  public String meow() {
    Cat catMeows = new Cat("Meow", 9);
      return catMeows.meow();
  }
  
  
  // ! create one more api, return List<Cat> object
  @GetMapping(value = "/cats")
  public List<Cat> getCats() {
    return List.of(new Cat("John", 13), new Cat("Peter", 20));
  }
  // ! how about hashmap?
  @GetMapping(value = "/catmap")
  public Map<String, List<Cat>> getCapMap() {
    List<Cat> catList1 = List.of(new Cat("John", 15), new Cat("Peter", 20));
    List<Cat> catList2 = List.of(new Cat("Mary", 10));
    Map<String, List<Cat>> catMap = new HashMap<>();
    catMap.put("ABC", catList1);
    catMap.put("IJK", catList2);
    return catMap;
  }
  // ! Return ShoppingMall
  @GetMapping(value = "/shoppingmall")
  public ShoppingMall getShoppingMall() {
    Film releasedFilm1 = new Film("ABC", "01-JAN-2025");
    Film releasedFilm2 = new Film("DEF", "26-JAN-2025");
    Cinema cinema =
      Cinema.builder().releasedFilms(List.of(releasedFilm1, releasedFilm2))
          .openedDate("14-FEB-2024").name("ABC cinema").build();
    return ShoppingMall.builder()
        .cinema(cinema)
        .area(100L)
        .name("K11")
        .shopCategories(List.of("Food", "Sport"))
        .build();
  }
}