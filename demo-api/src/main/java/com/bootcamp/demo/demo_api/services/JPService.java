package com.bootcamp.demo.demo_api.services;

import java.util.List;
import com.bootcamp.demo.demo_api.entity.CommentsEntity;
import com.bootcamp.demo.demo_api.entity.PostEntity;
import com.bootcamp.demo.demo_api.entity.UserEntity;
import com.bootcamp.demo.demo_api.model.dto.UserDTO;

public interface JPService {
  List<UserDTO> getUsers();
  List<UserEntity> getAndSaveUsers();
  List<PostEntity> getAndSavePosts();
  List<CommentsEntity> getAndSaveComments();

  List<PostEntity> getPostsByUserId(Long userId);

  List<UserEntity> findAllUsers();
}