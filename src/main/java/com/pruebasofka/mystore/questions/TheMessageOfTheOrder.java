package com.pruebasofka.mystore.questions;

import static com.pruebasofka.mystore.userinterfaces.Payment.ORDER_COMPLETED_BANK_MSG;
import static com.pruebasofka.mystore.userinterfaces.Payment.ORDER_COMPLETED_CHECK_MSG;
import static com.pruebasofka.mystore.utils.Constants.BANK_WIRE;
import static com.pruebasofka.mystore.utils.Constants.CHECK;
import static com.pruebasofka.mystore.utils.enums.ErrorMessages.INVALID_PAYMENT_METHOD_ERROR;

import com.pruebasofka.mystore.exceptions.InvalidValueException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheMessageOfTheOrder implements Question<String> {

  private String paymentMethod;

  public TheMessageOfTheOrder(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  @Override
  public String answeredBy(Actor actor) {
    switch (paymentMethod) {
      case BANK_WIRE:
        return Text.of(ORDER_COMPLETED_BANK_MSG).viewedBy(actor).asString();
      case CHECK:
        return Text.of(ORDER_COMPLETED_CHECK_MSG).viewedBy(actor).asString();
      default:
        throw new InvalidValueException(
            String.format(INVALID_PAYMENT_METHOD_ERROR.getMessage(), paymentMethod));
    }
  }

  public static TheMessageOfTheOrder paidBy(String paymentMethod) {
    return new TheMessageOfTheOrder(paymentMethod);
  }
}
