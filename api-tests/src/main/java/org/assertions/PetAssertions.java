package org.assertions;

import org.assertj.core.api.AbstractAssert;
import org.models.PetDto;

public class PetAssertions extends AbstractAssert<PetAssertions, PetDto> implements IAssertions{

  public PetAssertions(PetDto actual) {
    super(actual, PetAssertions.class);
  }

  public static PetAssertions assertThat(PetDto actual) {
    return new PetAssertions(actual);
  }

  public PetAssertions hasId(String id) {
    softly.assertThat(actual.getId())
        .isEqualTo(id)
        .as(String.format("Expected id param is not present in response %s", actual))
        .isNotNull()
        .isExactlyInstanceOf(String.class);
    return this;
  }

  public PetAssertions hasName(String name) {
    softly.assertThat(actual.getName())
        .isEqualTo(name)
        .as(String.format("Expected name param is not present in response %s", actual))
        .isNotNull()
        .isExactlyInstanceOf(String.class);
    return this;
  }

  public PetAssertions hasStatus(String status) {
    softly.assertThat(actual.getStatus())
        .isEqualTo(status)
        .as(String.format("Expected status param is not present in response %s", actual))
        .isNotNull()
        .isExactlyInstanceOf(String.class);
    return this;
  }
}
