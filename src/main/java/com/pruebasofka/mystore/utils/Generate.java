package com.pruebasofka.mystore.utils;

import com.pruebasofka.mystore.models.Product;
import java.io.IOException;
import java.util.List;

public class Generate {

  public static List<Product> getProductsData(String filter) throws IOException {
    List<Product> productsData;
    try {
      productsData = Product.getProducts(CsvUtilities.getDataTest("products", filter));
    } catch (IOException e) {
      throw new IOException("Archivo no encontrado", e);
    }
    return productsData;
  }
}
