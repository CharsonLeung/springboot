package com.bootcamp.demo.demo_helloworld;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// ! reflection

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingMall {
  private String name;
  private Long area;
  private Cinema cinema;
  @JsonProperty(value = "shopCategory")
  private List<String> shopCategories;
  // ! List is same as Array, in Serialization perspective

  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  public static class Cinema {
    private String name;
    private String openedDate;
    private List<Film> releasedFilms;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Film {
      private String name;
      private String releaseDate;
    }
  }
}