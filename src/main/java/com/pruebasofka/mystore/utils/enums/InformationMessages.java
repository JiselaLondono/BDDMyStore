package com.pruebasofka.mystore.utils.enums;

public enum InformationMessages {
  AMOUNT_VALIDATION_MESSAGE("The value of the amount presented is correct."),
  PAYMENT_METHOD_MESSAGE("The payment method presented in the registry is correct."),
  PRICE_VALIDATION_MESSAGE("The total price of the order presented in the registry is correct."),
  ORDER_FOUND_MESSAGE("Order %s found successfully within the user's order history.");

  private String message;

  InformationMessages(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
