package com.pruebasofka.mystore.utils.enums;

public enum ErrorMessages {
  RESOURCE_NOT_FOUND_ERROR("Required resource not found."),
  INVALID_PAYMENT_METHOD_ERROR("El payment method %s is invalid."),
  EXPECTED_MESSAGE_ERROR("The order completed message is invalid."),
  AMOUNT_PRESENTED_ERROR("The value of the amount presented is incorrect."),
  AMOUNT_VALUE_ERROR("An amount of $%s was expected, but a value of $%s was obtained");

  private String message;

  ErrorMessages(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
