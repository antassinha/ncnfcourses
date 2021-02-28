package com.example.testFlutterBE.DTO.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCoursesRequest {
  @NonNull
  private String name;
  private String description;
  private String language;
  private String thumbnailUrl;
  private String resourceName;
  private String resourceUrl;

}
