package com.pruebasofka.mystore.tasks;

import static com.pruebasofka.mystore.userinterfaces.GeneralOptions.PROCEED_TO_CHECKOUT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class ConfirmSummary implements Task {

  @Step("{0} confirms the summary of the purchase to be made")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(PROCEED_TO_CHECKOUT));
  }

  public static ConfirmSummary ofTheSelectedProducts() {
    return instrumented(ConfirmSummary.class);
  }
}
