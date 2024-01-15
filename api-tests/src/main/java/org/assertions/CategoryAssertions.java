package org.assertions;

import org.assertj.core.api.AbstractAssert;
import org.models.PetCategory;

public class CategoryAssertions extends AbstractAssert<CategoryAssertions, PetCategory> implements IAssertions{

  public CategoryAssertions(PetCategory actual) {
    super(actual, CategoryAssertions.class);
  }

  public static CategoryAssertions assertThat(PetCategory actual) {
    return new CategoryAssertions(actual);
  }

  public CategoryAssertions hasId(String id) {
    softly.assertThat(actual.getId())
        .isEqualTo(id)
        .as(String.format("Expected id param is not present in response %s", actual))
        .isNotNull()
        .isExactlyInstanceOf(String.class);
    return this;
  }

  public CategoryAssertions hasName(String name) {
    softly.assertThat(actual.getName())
        .isEqualTo(name)
        .as(String.format("Expected name param is not present in response %s", actual))
        .isNotNull()
        .isExactlyInstanceOf(String.class);
    return this;
  }
}
