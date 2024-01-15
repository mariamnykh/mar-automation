package org.assertions;

import org.assertj.core.api.SoftAssertions;

public interface IAssertions {
  SoftAssertions softly = new SoftAssertions();

  default void assertAll(){
    softly.assertAll();
  }
}
