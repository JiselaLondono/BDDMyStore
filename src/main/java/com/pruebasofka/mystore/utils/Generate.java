package com.pruebasofka.mystore.utils;

import static com.pruebasofka.mystore.utils.enums.CsvFileNames.PRODUCTS;
import static com.pruebasofka.mystore.utils.enums.ErrorMessages.RESOURCE_NOT_FOUND_ERROR;

import com.pruebasofka.mystore.models.Product;
import java.io.IOException;
import java.util.List;

public class Generate {

  public static List<Product> getProductsData(String filter) throws IOException {
    List<Product> productsData;
    try {
      productsData = Product.getProducts(CsvUtilities.getDataTest(PRODUCTS.getFileName(), filter));
    } catch (IOException e) {
      throw new IOException(RESOURCE_NOT_FOUND_ERROR.getMessage(), e);
    }
    return productsData;
  }
}
