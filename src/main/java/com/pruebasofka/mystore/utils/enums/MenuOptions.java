package com.pruebasofka.mystore.utils.enums;

public enum MenuOptions {
  SIGN_IN("Sign in"),
  SIGN_OUT("Sign out"),
  CONTACT_US("Contact us"),
  WOMEN("Women");

  private String value;

  MenuOptions(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
