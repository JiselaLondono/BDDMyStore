package com.pruebasofka.mystore.exceptions;

public class InvalidOrderInformationException extends AssertionError {

  public InvalidOrderInformationException(String message, Throwable cause) {
    super(message, cause);
  }
}
