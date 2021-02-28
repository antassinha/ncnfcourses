package com.example.testFlutterBE.DTO.responses;

import com.example.testFlutterBE.entity.Resource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindResourcesResponse {
  private String name;
  private String resourceUri;

  public FindResourcesResponse(Resource resource) {
    BeanUtils.copyProperties(resource,this);
  }
}
