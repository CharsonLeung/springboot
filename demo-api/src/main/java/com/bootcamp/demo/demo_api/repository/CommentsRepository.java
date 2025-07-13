package com.bootcamp.demo.demo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_api.entity.CommentsEntity;

@Repository
public interface CommentsRepository extends JpaRepository<CommentsEntity, Long> { 
  
}

