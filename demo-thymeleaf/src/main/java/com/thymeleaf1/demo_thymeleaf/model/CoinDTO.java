package com.thymeleaf1.demo_thymeleaf.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true) // ignore unknown fields
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) // SnakeCase = underscore
public class CoinDTO {
  private String id;
  private String symbol;
  private String name;
  private String image;
  // @JsonProperty(value = "current_price")
  private Double currentPrice;
  private Double marketCap;
  // private Long market_cap_rank;
  @JsonProperty(value = "price_change_percentage_24h")
  private Double priceChangePercentage24h; // 527.13,
  private Double totalVolume; // 64216741849,
  private LocalDateTime lastUpdated; // "2025-08-14T12:14:53.184Z"
}
