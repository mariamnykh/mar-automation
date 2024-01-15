package org.configs;

import lombok.Getter;

public enum ErrorMessages {
  PET_NOT_FOUND("Pet not found"),
  ERROR("error");

  @Getter
  private final String message;

  ErrorMessages(String message) {
    this.message = message;
  }

  public String getDisplayName() {
    return message;
  }
}
