package com.pruebasofka.mystore.questions;

import static com.pruebasofka.mystore.interactions.SelectProduct.getPrice;
import static com.pruebasofka.mystore.userinterfaces.Payment.PAYMENT_AMOUNT_TXT;

import com.pruebasofka.mystore.models.Product;
import java.util.List;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheOrderAmount implements Question<Boolean> {
  private List<Product> products;

  public TheOrderAmount(List<Product> products) {
    this.products = products;
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    double finalAmount = 0.0;
    for (Product product : products) {
      finalAmount = finalAmount + (product.getPrice() * product.getQuantity());
    }
    double shippingPrice = actor.recall("DeliveryPrice");
    finalAmount = finalAmount + shippingPrice;
    actor.remember("amount", finalAmount);
    return (finalAmount == getPrice(actor, PAYMENT_AMOUNT_TXT));
  }

  public static TheOrderAmount correspondsToTheProducts(List<Product> products) {
    return new TheOrderAmount(products);
  }
}
