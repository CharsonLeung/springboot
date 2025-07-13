package com.bootcamp.demo.demo_api.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_api.entity.CommentsEntity;
import com.bootcamp.demo.demo_api.entity.PostEntity;
import com.bootcamp.demo.demo_api.entity.UserEntity;
import com.bootcamp.demo.demo_api.model.dto.CommentsDTO;
import com.bootcamp.demo.demo_api.model.dto.PostDTO;
import com.bootcamp.demo.demo_api.model.dto.UserDTO;

@Component // Create class -> Bean
public class EntityMapper { // method name + number = 
  public PostEntity map(PostDTO postDTO, UserEntity userEntity) {
    return PostEntity.builder() //
      .jphPostId(postDTO.getId()) //
      .title(postDTO.getTitle()) //
      .body(postDTO.getBody()) //
      .userEntity(userEntity) // ! Set FK
      .build();
  }
  public CommentsEntity map(CommentsDTO commentsDTO, PostEntity postEntity) {
    return CommentsEntity.builder()
            .name(commentsDTO.getName())
            .email(commentsDTO.getEmail())
            .body(commentsDTO.getBody())
            .postEntity(postEntity)
            .build();
  }
  public UserEntity map(UserDTO userDTO) {
    return UserEntity.builder() //
        .jphUserId(userDTO.getId()) //
        .email(userDTO.getEmail()) //
        .phone((userDTO.getPhone())) //
        .username(userDTO.getUsername()) //
        .website(userDTO.getWebsite()) //
        .name(userDTO.getName()) //
        .build();
  }
}
