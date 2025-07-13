package com.bootcamp.demo.demo_api.model.dto;

import lombok.Getter;

@Getter
public class CommentsDTO {
  private Long id;
  private String name;
  private String email;
  private String body;
  private Long postId;
  
}
