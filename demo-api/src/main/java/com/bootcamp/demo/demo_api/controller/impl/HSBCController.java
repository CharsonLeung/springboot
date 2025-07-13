package com.bootcamp.demo.demo_api.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_api.controller.HSBCOperation;
import com.bootcamp.demo.demo_api.dto.HSBCUserDTO;
import com.bootcamp.demo.demo_api.mapper.DTOMapper;
import com.bootcamp.demo.demo_api.services.JPService;

@RestController
public class HSBCController implements HSBCOperation {
  @Autowired
  private JPService jpService;

  // ! List<UserDTO> -> Postman (JSON) (Serialization)
  @Autowired
  private DTOMapper dtoMapper;

  @Override
  public List<HSBCUserDTO> getUsers() {
    return this.jpService.findAllUsers().stream() //
        .map(e -> this.dtoMapper.mapToHSBC(e)) //
        .collect(Collectors.toList());
  }
  
}
