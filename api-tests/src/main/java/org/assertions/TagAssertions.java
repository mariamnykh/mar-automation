package org.assertions;

import org.assertj.core.api.AbstractAssert;
import org.models.PetTagDto;

public class TagAssertions extends AbstractAssert<TagAssertions, PetTagDto> implements IAssertions{

  public TagAssertions(PetTagDto actual) {
    super(actual, TagAssertions.class);
  }

  public static TagAssertions assertThat(PetTagDto actual) {
    return new TagAssertions(actual);
  }

  public TagAssertions hasId(String id) {
    softly.assertThat(actual.getId())
        .isEqualTo(id)
        .as(String.format("Expected id param is not present in response %s", actual))
        .isNotNull()
        .isExactlyInstanceOf(String.class);
    return this;
  }

  public TagAssertions hasName(String name) {
    softly.assertThat(actual.getName())
        .isEqualTo(name)
        .as(String.format("Expected name param is not present in response %s", actual))
        .isNotNull()
        .isExactlyInstanceOf(String.class);
    return this;
  }
}
