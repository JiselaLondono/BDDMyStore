package com.pruebasofka.mystore.interactions;

import static com.pruebasofka.mystore.userinterfaces.Payment.ORDER_DATA_FOR_BANK_WIRE;
import static com.pruebasofka.mystore.userinterfaces.Payment.ORDER_DATA_FOR_CHECK;
import static com.pruebasofka.mystore.utils.Constants.BANK_WIRE;
import static com.pruebasofka.mystore.utils.Constants.CHECK;
import static com.pruebasofka.mystore.utils.Constants.LINE_BREAK;
import static com.pruebasofka.mystore.utils.Constants.ORDER_CODE;
import static com.pruebasofka.mystore.utils.Constants.POINT;
import static com.pruebasofka.mystore.utils.Constants.SPACE;
import static com.pruebasofka.mystore.utils.enums.ErrorMessages.INVALID_PAYMENT_METHOD_ERROR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.pruebasofka.mystore.exceptions.InvalidValueException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

public class GetOrderReference implements Interaction {

  private static final int ORDER_CODE_POSITION = 9;
  private static final int ORDER_ITEM_CHECK = 4;
  private static final int ORDER_ITEM_BANK_WIRE = 6;

  private String paymentMethod;

  public GetOrderReference(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  @Step("{0} obtains the order reference, according to the payment method used")
  @Override
  public <T extends Actor> void performAs(T actor) {
    switch (paymentMethod) {
      case BANK_WIRE:
        actor.remember(ORDER_CODE, getOrderCodeForBankWire(actor));
        break;
      case CHECK:
        actor.remember(ORDER_CODE, getOrderCodeForCheck(actor));
        break;
      default:
        throw new InvalidValueException(
            String.format(INVALID_PAYMENT_METHOD_ERROR.getMessage(), paymentMethod));
    }
  }

  public static GetOrderReference forThePaymentMethod(String paymentMethod) {
    return instrumented(GetOrderReference.class, paymentMethod);
  }

  private String getOrderCodeForCheck(Actor actor) {
    return ORDER_DATA_FOR_CHECK
        .resolveFor(actor)
        .getText()
        .split(LINE_BREAK)[ORDER_ITEM_CHECK]
        .split(SPACE)[ORDER_CODE_POSITION]
        .replace(POINT, "");
  }

  private String getOrderCodeForBankWire(Actor actor) {
    return ORDER_DATA_FOR_BANK_WIRE
        .resolveFor(actor)
        .getText()
        .split(LINE_BREAK)[ORDER_ITEM_BANK_WIRE]
        .split(SPACE)[ORDER_CODE_POSITION];
  }
}
