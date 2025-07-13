package com.bootcamp.demo.demo_api.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_api.dto.HSBCUserDTO;
import com.bootcamp.demo.demo_api.dto.HSUserDTO;
import com.bootcamp.demo.demo_api.entity.UserEntity;

// static method: input -> output ()
// instance method: new xxxx().method()
@Component
public class DTOMapper {
  // ! Method Signaure  = method name + parameters
  public HSBCUserDTO mapToHSBC(UserEntity userEntity) {
      System.out.println("Hello");
    return HSBCUserDTO.builder() //
      .email(userEntity.getEmail()) //
      .name(userEntity.getName()) //
      .username(userEntity.getUsername()) //
      .build();
  }

public HSUserDTO maptoHS(UserEntity userEntity) {
  return HSUserDTO.builder()
      .name(userEntity.getName())
      .phone(userEntity.getPhone())
      .username(userEntity.getUsername())
      .website(userEntity.getWebsite())
      .build();
  }
}
