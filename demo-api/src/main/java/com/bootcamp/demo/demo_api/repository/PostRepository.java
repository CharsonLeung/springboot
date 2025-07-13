package com.bootcamp.demo.demo_api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_api.entity.PostEntity;
import com.bootcamp.demo.demo_api.entity.UserEntity;
import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
  // ! Jpa Method returns:
  // 1. Optional<PostEntity>
  // 2. PostEntity
  // 3. List<PostEntity>

  Optional<PostEntity> findByJphPostId(Long jphPostId);
  
  // ! Important (select by FK)
  List<PostEntity> findByUserEntiity(UserEntity userEntity);
  
  List<PostEntity> findByTitle(String title);
}