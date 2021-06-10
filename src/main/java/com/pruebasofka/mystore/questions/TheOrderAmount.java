package com.pruebasofka.mystore.questions;

import static com.pruebasofka.mystore.interactions.SelectProduct.getPrice;
import static com.pruebasofka.mystore.userinterfaces.Payment.PAYMENT_AMOUNT;
import static com.pruebasofka.mystore.utils.Constants.AMOUNT;
import static com.pruebasofka.mystore.utils.Constants.DELIVERY_PRICE;
import static com.pruebasofka.mystore.utils.enums.ErrorMessages.AMOUNT_VALUE_ERROR;
import static com.pruebasofka.mystore.utils.enums.InformationMessages.AMOUNT_VALIDATION_MESSAGE;

import com.pruebasofka.mystore.models.Product;
import java.util.List;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheOrderAmount implements Question<Boolean> {

  private static final Logger LOGGER = LoggerFactory.getLogger(TheOrderAmount.class);
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
    double shippingPrice = actor.recall(DELIVERY_PRICE);
    finalAmount = finalAmount + shippingPrice;
    actor.remember(AMOUNT, finalAmount);
    if (finalAmount != getPrice(actor, PAYMENT_AMOUNT)) {
      LOGGER.error(
          String.format(
              AMOUNT_VALUE_ERROR.getMessage(), finalAmount, getPrice(actor, PAYMENT_AMOUNT)));
      return false;
    }
    LOGGER.info(AMOUNT_VALIDATION_MESSAGE.getMessage());
    return true;
  }

  public static TheOrderAmount correspondsToTheProducts(List<Product> products) {
    return new TheOrderAmount(products);
  }
}
