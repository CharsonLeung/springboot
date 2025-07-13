package com.bootcamp.demo.demo_jpa.services;

import java.util.List;
import java.util.Optional;
import com.bootcamp.demo.demo_jpa.entity.StaffEntity;

// Normal Java

public interface StaffService {
  StaffEntity save(StaffEntity staffEntity);

  Optional<StaffEntity> findById(Long id); // could be non-exist
  
  List<StaffEntity> findAll();
  
  Boolean deleteById(Long id); // found the id or not?
  
  StaffEntity updateById(Long id, StaffEntity staffEntity);
  
  StaffEntity updateNameById(Long id, String name);
}