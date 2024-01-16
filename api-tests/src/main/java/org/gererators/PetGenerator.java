package org.gererators;

import java.util.List;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.models.PetCategory;
import org.models.PetDto;
import org.models.PetTagDto;
import org.models.enums.PetStatus;

@UtilityClass
public class PetGenerator extends AbstractGenerator {

  public static PetDto pet() {
    return pet(PetStatus.AVAILABLE);
  }

  public static PetDto pet(PetStatus status) {
    var category = PetCategory.builder()
        .id(RandomStringUtils.randomNumeric(1, 6))
        .name(AUTO_PREFIX + RandomStringUtils.randomAlphabetic(4))
        .build();

    var tag = PetTagDto.builder()
        .id(RandomStringUtils.randomNumeric(1, 6))
        .name(AUTO_PREFIX + RandomStringUtils.randomAlphabetic(4))
        .build();

    return PetDto.builder()
        .id(RandomStringUtils.randomNumeric(1, 6))
        .name(AUTO_PREFIX + RandomStringUtils.randomAlphabetic(4))
        .status(status.getDisplayName())
        .category(category)
        .tags(List.of(tag))
        .build();
  }
}
