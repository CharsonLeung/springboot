package com.bootcamp.demo.demo_api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_api.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  // JPA Methods
  Optional<UserEntity> findByJphUserId(Long jphUserId);
}

