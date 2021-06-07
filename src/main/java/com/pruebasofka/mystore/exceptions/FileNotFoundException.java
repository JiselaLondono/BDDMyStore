package com.pruebasofka.mystore.exceptions;

public class FileNotFoundException extends RuntimeException {
  public FileNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
