package com.bootcamp.demo.demo_api.model.dto;

import lombok.Getter;
// ! Data Transfer Object
// model/dto -> call external api, then dto is for description
@Getter
public class UserDTO {
  private Long id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private Company company;
  private String phone;
  private String website;

  @Getter
  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
    
    @Getter
    public static class Geo {
      private String lat;
      private String lng;
    }
  }
  
  @Getter
  public static class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}
