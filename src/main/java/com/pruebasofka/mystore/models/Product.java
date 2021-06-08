package com.pruebasofka.mystore.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Product {

  private String name;
  private String price;
  private String category;
  private String subcategory;
  private int quantity;
  private String size;
  private String color;

  public Product(Map<String, String> productData) {
    this.name = productData.get("name");
    this.category = productData.get("category");
    this.subcategory = productData.get("subcategory");
    this.quantity = Integer.parseInt(productData.get("quantity"));
    this.size = productData.get("size");
    this.color = productData.get("color");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getSubcategory() {
    return subcategory;
  }

  public void setSubcategory(String subcategory) {
    this.subcategory = subcategory;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public static List<Product> getProducts(List<Map<String, String>> productsList) {
    List<Product> products = new ArrayList<>();
    productsList.forEach(product -> products.add(new Product(product)));
    return products;
  }
}
