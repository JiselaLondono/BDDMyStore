package com.pruebasofka.mystore.utils.enums;

public enum CsvFileNames {
  PRODUCTS("products");

  private String fileName;

  CsvFileNames(String fileName) {
    this.fileName = fileName;
  }

  public String getFileName() {
    return fileName;
  }
}
