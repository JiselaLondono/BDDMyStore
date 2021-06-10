package com.pruebasofka.mystore.utils.enums;

public enum InformationMessages {
  AMOUNT_VALIDATION_MESSAGE("The value of the amount presented is correct.");

  private String message;

  InformationMessages(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
