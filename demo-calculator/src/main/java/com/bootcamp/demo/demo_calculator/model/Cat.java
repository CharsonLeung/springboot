package com.bootcamp.demo.demo_calculator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Cat {
  private static int counter = 0;

  private Integer id;
  private String name;
  private Integer age;

  public Cat(String name, Integer age) {
    this.id = ++counter;
    this.age = age;
    this.name = name;
  }
}