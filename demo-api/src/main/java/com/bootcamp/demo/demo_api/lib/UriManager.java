package com.bootcamp.demo.demo_api.lib;

import org.springframework.web.util.UriComponentsBuilder;

public class UriManager {
  private UriComponentsBuilder uriComponentsBuilder;

  public UriManager() {
    this.uriComponentsBuilder = UriComponentsBuilder.newInstance().scheme("https");
  }
  public static UriManager newInstance() {
    return new UriManager();
  }
  public UriManager host(String host) {
    this.uriComponentsBuilder.host(host);
    return this;
  } 


  public UriManager scheme(String scheme) {
    this.uriComponentsBuilder.scheme(scheme);
    return this;
  }
  public UriManager path(String path) {
    this.uriComponentsBuilder.path(path);
    return this;
  }
  public UriManager pathSegment(String... pathSegment) {
    this.uriComponentsBuilder.pathSegment(pathSegment);
    return this;
  }

  public String getUrl() {
    return this.uriComponentsBuilder.build().toUriString();
  }
  
  public static void main(String[] args) {
    String url = UriManager.newInstance()
                  .host("www.apple.com")
                  .pathSegment("api/v1")
                  .path("/users")
                  .getUrl();
    System.out.println(url);
                }
}
