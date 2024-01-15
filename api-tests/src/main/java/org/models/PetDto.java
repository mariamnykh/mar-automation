package org.models;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetDto implements Serializable {
  private String id;
  private String name;
  private String status;
  private PetCategory category;
  private List<PetTagDto> tags;
  private List<String> photoUrls;
}
