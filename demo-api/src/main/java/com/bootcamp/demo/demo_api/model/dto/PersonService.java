package com.bootcamp.demo.demo_api.model.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PersonService {
  //private double height;
  //private double weight;

  // weight / height ^ 2

  // instance method -> bmi
  //public double bmi() {
  //  BigDecimal divisor = BigDecimal.valueOf(this.height)
  //      .multiply(BigDecimal.valueOf(this.height));
  //  return BigDecimal.valueOf(this.weight)
  //      .divide(divisor, 2, RoundingMode.HALF_DOWN)
  //      .doubleValue();
  // }
  // static method -> bmi
  // ! Input -> Output
  public static double bmi(double height, double weight) {
    
    BigDecimal divisor = BigDecimal.valueOf(height)
        .multiply(BigDecimal.valueOf(height));
    return BigDecimal.valueOf(weight)
        .divide(divisor, 2, RoundingMode.HALF_DOWN)
        .doubleValue();
  }
  
public static void main(String[] args) {
  // Java
  PersonService.bmi(1.75, 65);
  // Spring
  // @Component PersonService
  // @Autnwired PErsonServive
  // @Bean

}
}
