package com.pruebasofka.mystore.questions;

import static com.pruebasofka.mystore.userinterfaces.Payment.ORDER_COMPLETED_BANK_MSG;
import static com.pruebasofka.mystore.userinterfaces.Payment.ORDER_COMPLETED_CHECK_MSG;

import com.pruebasofka.mystore.exceptions.InvalidValueException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheMessage implements Question<String> {
  private String paymentMethod;

  public TheMessage(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  @Override
  public String answeredBy(Actor actor) {
    switch (paymentMethod) {
      case "bank wire":
        return Text.of(ORDER_COMPLETED_BANK_MSG).viewedBy(actor).asString();
      case "check":
        return Text.of(ORDER_COMPLETED_CHECK_MSG).viewedBy(actor).asString();
      default:
        throw new InvalidValueException("EL payment method " + paymentMethod + " is invalid.");
    }
  }

  public static TheMessage forThePaymentMethod(String paymentMethod) {
    return new TheMessage(paymentMethod);
  }
}
