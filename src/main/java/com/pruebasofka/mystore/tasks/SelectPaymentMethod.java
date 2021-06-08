package com.pruebasofka.mystore.tasks;

import static com.pruebasofka.mystore.userinterfaces.GeneralOptions.NEXT;
import static com.pruebasofka.mystore.userinterfaces.Payment.PAYMENT_METHOD;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SelectPaymentMethod implements Task {
  private String paymentMethod;

  public SelectPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Click.on(PAYMENT_METHOD.of(paymentMethod)), Click.on(NEXT.of("I confirm my order")));
  }

  public static SelectPaymentMethod named(String paymentMethod) {
    return instrumented(SelectPaymentMethod.class, paymentMethod);
  }
}
