package com.pruebasofka.mystore.utils.enums;

public enum ErrorMessages {
  RESOURCE_NOT_FOUND_ERROR("Required resource not found."),
  INVALID_PAYMENT_METHOD_ERROR("El payment method %s is invalid."),
  EXPECTED_MESSAGE_ERROR("The order completed message is invalid."),
  AMOUNT_PRESENTED_ERROR("The value of the amount presented is incorrect."),
  AMOUNT_VALUE_ERROR("An amount of $%s was expected, but a value of $%s was obtained"),
  TOTAL_ORDER_PRICE_ERROR(
      "The total price of the order presented in the registry is not correct. Expected: %s, obtained: %s."),
  PAYMENT_METHOD_ERROR("The payment method indicated in the registration is incorrect."),
  ORDER_NOT_FOUND_ERROR("The %s order was not found within the user's order history."),
  INVALID_ORDER_DATA_ERROR(
      "There are inconsistencies with the order information recorded in the order history.");

  private String message;

  ErrorMessages(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
