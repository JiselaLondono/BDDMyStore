package com.pruebasofka.mystore.interactions;

import static com.pruebasofka.mystore.userinterfaces.Payment.CONFIRMATION_MESSAGE_BANK;
import static com.pruebasofka.mystore.userinterfaces.Payment.CONFIRMATION_MESSAGE_CHECK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class GetOrderReference implements Interaction {

  private String paymentMethod;

  public GetOrderReference(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    switch (paymentMethod) {
      case "bank wire":
        actor.remember("OrderReference", getOrderReferenceForBankWire(actor));
        break;
      case "check":
        actor.remember("OrderReference", getOrderReferenceForCheck(actor));
        break;
      default:
        throw new AssertionError("Pum, me estallé");
    }
  }

  public static GetOrderReference fromThePaymentMethod(String paymentMethod) {
    return instrumented(GetOrderReference.class, paymentMethod);
  }

  private String getOrderReferenceForCheck(Actor actor) {
    return CONFIRMATION_MESSAGE_CHECK
        .resolveFor(actor)
        .getText()
        .split("\n")[4]
        .split(" ")[9]
        .replace(".", "");
  }

  private String getOrderReferenceForBankWire(Actor actor) {
    return CONFIRMATION_MESSAGE_BANK.resolveFor(actor).getText().split("\n")[6].split(" ")[9];
  }
}
