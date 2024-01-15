package org.models.enums;

public enum PetStatus {
  AVAILABLE("available"),
  PENDING("pending"),
  SOLD("sold");

  String displayName;

  PetStatus(String displayName){
    this.displayName = displayName;
  }

  public String getDisplayName(){
    return displayName;
  }
}
