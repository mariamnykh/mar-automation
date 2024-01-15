package org.assertions;

import org.assertj.core.api.AbstractAssert;
import org.models.GeneralResponse;

public class GeneralAssertions extends AbstractAssert<GeneralAssertions, GeneralResponse> implements IAssertions{

  public GeneralAssertions(GeneralResponse actual) {
    super(actual, GeneralAssertions.class);
  }

  public static GeneralAssertions assertThat(GeneralResponse actual) {
    return new GeneralAssertions(actual);
  }

  public GeneralAssertions hasMessage(String message) {
    softly.assertThat(actual.getMessage())
        .isEqualTo(message)
        .as(String.format("Expected message param is not present in response %s", actual))
        .isNotNull()
        .isExactlyInstanceOf(String.class);
    return this;
  }

  public GeneralAssertions hasType(String type) {
    softly.assertThat(actual.getType())
        .isEqualTo(type)
        .as(String.format("Expected type param is not present in response %s", actual))
        .isNotNull()
        .isExactlyInstanceOf(String.class);
    return this;
  }

  public GeneralAssertions hasStatusCode(String code) {
    softly.assertThat(actual.getCode())
        .isEqualTo(code)
        .as(String.format("Expected code param is not present in response %s", actual))
        .isNotNull()
        .isExactlyInstanceOf(String.class);
    return this;
  }
}
