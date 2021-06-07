package com.pruebasofka.mystore.utils;

import com.pruebasofka.mystore.exceptions.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
  private PropertiesReader() {}

  public static Properties getProperties(String path) {
    try {
      FileInputStream file = new FileInputStream(path);
      return getProperties(file);
    } catch (IOException e) {
      throw new FileNotFoundException(
          String.format("FILE_NOT_FOUND_ERROR.getMessage()", path) + e.getMessage(), e);
    }
  }

  private static Properties getProperties(FileInputStream file) throws IOException {
    Properties properties = new Properties();
    Throwable throwable = null;
    try {
      properties.load(file);
    } catch (IOException e) {
      throwable = e;
      throw e;
    } finally {
      if (throwable != null) {
        closeFileAfterFailedExecution(file, throwable);
      } else {
        file.close();
      }
    }
    return properties;
  }

  private static void closeFileAfterFailedExecution(FileInputStream file, Throwable throwable) {
    try {
      file.close();
    } catch (IOException e) {
      throwable.addSuppressed(e);
    }
  }
}
