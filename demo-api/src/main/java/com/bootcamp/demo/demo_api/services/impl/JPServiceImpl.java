package com.bootcamp.demo.demo_api.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.demo_api.entity.CommentsEntity;
import com.bootcamp.demo.demo_api.entity.PostEntity;
import com.bootcamp.demo.demo_api.entity.UserEntity;
import com.bootcamp.demo.demo_api.exception.BusniessException;
import com.bootcamp.demo.demo_api.exception.SysError;
import com.bootcamp.demo.demo_api.lib.Scheme;
import com.bootcamp.demo.demo_api.mapper.EntityMapper;
import com.bootcamp.demo.demo_api.model.dto.CommentsDTO;
import com.bootcamp.demo.demo_api.model.dto.PostDTO;
import com.bootcamp.demo.demo_api.model.dto.UserDTO;
import com.bootcamp.demo.demo_api.repository.CommentsRepository;
import com.bootcamp.demo.demo_api.repository.PostRepository;
import com.bootcamp.demo.demo_api.repository.UserRepository;
import com.bootcamp.demo.demo_api.services.JPService;

@Service
public class JPServiceImpl implements JPService {
  // ! @Value has dependency, complete injection befoer server start completed
  @Value("${service-api.jsonplaceholder.host}")
  private String domain;

  @Value("$(service-api.jsonplaceholder.endpoints.users)")
  private String usersEndpoint;

  @Value("$(service-api.jsonplaceholder.endpoints.posts)")
  private String postsEndpoint;

  @Value("$(service-api.jsonplaceholder.endpoints.comments)")
  private String commentsEndpoint;
  
  @Autowired // if cannot autowire, server down. because controller cannot autowire.
  private RestTemplate restTemplate; // build-in library

  @Autowired
  @Qualifier(value = "student") // explicit bean name
  private String abc; 

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private CommentsRepository commentsRepository;

  @Autowired
  private EntityMapper entityMapper;

  @Override
  public List<UserDTO> getUsers() {
    // String url = "https://" + domain + usersEndpoint
    
    String url = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.getValue())
        .host(domain) //
        .path(usersEndpoint) //
        .build() //
        .toUriString();
    System.out.println("url=" + url);

    // ! getForObject():
    // 1. call API. receive JSON String
    // 2. connect from JSON String to Java Object
    UserDTO[] users = this.restTemplate.getForObject(url, UserDTO[].class); // .class does not accept generic
    return Arrays.asList(users);
  }
  
  @Override
  public List<UserEntity> getAndSaveUsers() {
    // ! Convert List<UserDTO> to List<UserEntity>
    List<UserEntity> userEntities = this.getUsers().stream()
      .map(e -> this.entityMapper.map(e))
      .collect(Collectors.toList());
this.userRepository.deleteAll();
    // save to DB
return this.userRepository.saveAll(userEntities);
  }

  @Override
  public List<PostEntity> getAndSavePosts() {
    List<PostEntity> postEntities = this.getPosts().stream()
      .map(e -> {
        UserEntity userEntity = 
            this.userRepository.findByJphUserId(e.getUserId())
            .orElseThrow(() -> new BusniessException(SysError.USER_NOT_FOUND));
   return this.entityMapper.map(e, userEntity);
  }).collect(Collectors.toList());
return this.postRepository.saveAll(postEntities);
}


  @Override
  public List<CommentsEntity> getAndSaveComments() {
    //System.out.println(this.postRepository.findByJphPostId());
    List<CommentsEntity> commentsEntities = this.getComments().stream()
      .map(e -> {
        PostEntity postEntity =
          this.postRepository.findByJphPostId(e.getPostId())
              .orElseThrow(() -> new RuntimeException("Post not found."));
        return this.entityMapper.map(e, postEntity);
      }).collect(Collectors.toList());
    return this.commentsRepository.saveAll(commentsEntities);
}

private List<CommentsDTO> getComments() {
  String url = UriComponentsBuilder.newInstance() //
      .scheme(Scheme.HTTPS.getValue())
      .host(domain) //
      .path(commentsEndpoint) //
      .build() //
      .toUriString();
  System.out.println("url=" + url);
  CommentsDTO[] commentsDTOs = 
      this.restTemplate.getForObject(url, CommentsDTO[].class);
  return Arrays.asList(commentsDTOs);
  }

private List<PostDTO> getPosts() {
  String url = UriComponentsBuilder.newInstance() //
      .scheme(Scheme.HTTPS.getValue())
      .host(domain) //
      .path(postsEndpoint) //
      .build() //
      .toUriString();
  System.out.println("url=" + url);
  PostDTO[] users = this.restTemplate.getForObject(url, PostDTO[].class);
  return Arrays.asList(users);
  }
@Override
public List<PostEntity> getPostsByUserId(Long userId) {
  UserEntity userEntity = this.userRepository.findById(userId) //
      .orElseThrow(() -> new RuntimeException("User not found."));
  return this.postRepository.findByUserEntiity(userEntity);
}

@Override
public List<UserEntity> findAllUsers() {
  return this.userRepository.findAll();
}
  }
