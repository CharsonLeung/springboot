package com.bootcamp.bc_calculator.bc_calculator.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultDTO {
  private String x;
  private String y;
  private String operation;
  private String result;
  private Integer code;
  private String message;

  
}
