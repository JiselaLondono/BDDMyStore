package com.pruebasofka.mystore.tasks;

import static com.pruebasofka.mystore.userinterfaces.GeneralOptions.CONFIRM_ORDER;
import static com.pruebasofka.mystore.userinterfaces.Payment.PAYMENT_METHOD;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class PayOrder implements Task {

  private String paymentMethod;

  public PayOrder(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  @Step("{0} selects the payment method and pays the order")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(PAYMENT_METHOD.of(paymentMethod)), Click.on(CONFIRM_ORDER));
  }

  public static PayOrder by(String paymentMethod) {
    return instrumented(PayOrder.class, paymentMethod);
  }
}
