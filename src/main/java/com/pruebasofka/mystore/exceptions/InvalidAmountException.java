package com.pruebasofka.mystore.exceptions;

public class InvalidAmountException extends AssertionError {

  public InvalidAmountException(String message, Throwable cause) {
    super(message, cause);
  }
}
